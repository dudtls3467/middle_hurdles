package kr.or.ddit.admin.restaurant.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/admin/restaurantInsert.do")
@MultipartConfig
public class RestaurantInsertController extends HttpServlet {
	RestaurantService resService = RestaurantService.getInstance();
	FileService fileService = FileService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 음식 카테고리 불러오기
		List<RestaurantCodeVo> restaurantCodeList = resService.getRestaurantCodeList();
		
		// 지역 불러오기
		List<LocalVo> localList = resService.getLocalList();
		
		req.setAttribute("resCodeList", restaurantCodeList);
		req.setAttribute("localList", localList);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/restaurant/restaurantInsert.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] requiredParams = { "localNo", "restaurantCodeNo"};
		
		ParamResult paramResult = ParamResult.valid(req, requiredParams);// 필수인자 확인
		
		if (paramResult.getCode() == 1 && !paramResult.getMessage().equals("")) {
			// 에러 메시지를 요청 속성에 추가
			req.setAttribute("errorMessage", paramResult.getMessage());

			// 에러 페이지로 포워드
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}
		
		RestaurantVo newRes = RequestToVoMapper.mapRequestToVo(req, RestaurantVo.class);

		int resNo = resService.getNo();
		newRes.setRestaurantNo(resNo);

		// 실제 이미지 추가
		List<FileVo> fileList = FileUpload.fileListWrite(req, "restaurant");
		
		if (!fileList.isEmpty()) {
			// 식당 이미지 추가
			fileService.addFiles(fileList);

			// 식당 썸네일 추가
			newRes.setFileNo(fileList.get(0).getFileNo());
		}

		// 식당 추가
		int result = resService.insert(newRes);

		if (!fileList.isEmpty()) {
			// 식당 이미지 조인
			resService.restaurantFileInsert(fileList, resNo);
		}
		
		System.out.println(result);
		if (result == 1) {
			resp.sendRedirect(req.getContextPath() + "/admin/restaurantDetail.do?restaurantNo=" + resNo);
			return;
		}

		// 실패 시 지금 화면 다시 재시작 (값도 넣어주고)
		req.setAttribute("restaurant", newRes);
		resp.sendRedirect(req.getContextPath() + "/admin/restaurantInsert.do");

	}
}
