package kr.or.ddit.owner.restaurant.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.restaurant.service.RestaurantService;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.util.FileUpload;
import kr.or.ddit.util.ParamResult;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.FileVo;
import kr.or.ddit.vo.LocalVo;
import kr.or.ddit.vo.RestaurantCodeVo;
import kr.or.ddit.vo.RestaurantVo;

@WebServlet("/owner/ownRestaurantUpdate.do")
@MultipartConfig
public class OwnRestaurantUpdateController extends HttpServlet {
	RestaurantService resService = RestaurantService.getInstance();
	FileService fileService = FileService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] requiredParams = {"restaurantNo"};
		
		ParamResult paramResult = ParamResult.valid(req, requiredParams);// 필수인자 확인
		
		if (paramResult.getCode() == 1 && !paramResult.getMessage().equals("")) {
			// 에러 메시지를 요청 속성에 추가
			req.setAttribute("errorMessage", paramResult.getMessage());
			
			// 에러 페이지로 포워드
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}

		RestaurantVo param = RequestToVoMapper.mapRequestToVo(req, RestaurantVo.class);
		
		// 음식 카테고리 불러오기
		List<RestaurantCodeVo> restaurantCodeList = resService.getRestaurantCodeList();
		
		// 지역 불러오기
		List<LocalVo> localList = resService.getLocalList();
		
		// 식당 상세
		RestaurantVo restaurant = resService.detail(param);
		
		// 식당 파일
		List<FileVo> fileList = resService.getFileList(param);
		
		req.setAttribute("resCodeList", restaurantCodeList);
		req.setAttribute("localList", localList);
		req.setAttribute("restaurant", restaurant);
		req.setAttribute("fileList", fileList);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/owner/restaurant/ownRestaurantUpdate.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] params = {"restaurantNo", "localNo", "restaurantCodeNo"};
		
		ParamResult paramResult = ParamResult.valid(req, params);// 필수인자 확인
		
		if (paramResult.getCode() == 1 && !paramResult.getMessage().equals("")) {
			// 에러 메시지를 요청 속성에 추가
			req.setAttribute("errorMessage", paramResult.getMessage());

			// 에러 페이지로 포워드
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}

		RestaurantVo updateParam = RequestToVoMapper.mapRequestToVo(req, RestaurantVo.class);
		int currentFileId = updateParam.getFileNo();
		
		int[] removeFileIds = {};
		if (updateParam.getRemoveFileId() != null) {
			removeFileIds = updateParam.getRemoveFileId();
		}
		
		if (IntStream.of(removeFileIds).anyMatch(id -> id == currentFileId)) {
            updateParam.setFileNo(0);
        }
				
		// 실제 이미지 추가
		List<FileVo> uploadedFiles = FileUpload.fileListWrite(req, "restaurant");
		
		if (!uploadedFiles.isEmpty()) {
			// 식당 이미지 추가
			fileService.addFiles(uploadedFiles);
			
			// 섬네일 삭제 시 파일 삭제 된 경우 파일 첫번째 파일 넣어주기
			if (updateParam.getFileNo() == 0) {
				updateParam.setFileNo(uploadedFiles.get(0).getFileNo());
			}
		}
		
		// 식당 내용 업데이트
		int result = resService.update(updateParam);
		
		if (removeFileIds.length > 0) {
			// 이미지 삭제
			fileService.deleteFiles(removeFileIds);
			
			// 연결된 테이블 삭제 처리
			resService.restrauntFileDelete(removeFileIds);
		}

		if (!uploadedFiles.isEmpty()) {
			// 식당 이미지 조인
			resService.restaurantFileInsert(uploadedFiles, updateParam.getRestaurantNo());
		}
		
		if (result == 1) {
			resp.sendRedirect(req.getContextPath() + "/owner/ownRestaurantDetail.do?restaurantNo=" + updateParam.getRestaurantNo());
			return;
		} else {
			resp.sendRedirect(req.getContextPath() + "/owner/ownRestrauntUpdate.do?restaurantNo=" + updateParam.getRestaurantNo());
		}
	}
}
