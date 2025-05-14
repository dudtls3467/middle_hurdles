package kr.or.ddit.admin.menu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.menu.service.MenuService;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.util.FileUpload;
import kr.or.ddit.util.ParamResult;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.FileVo;
import kr.or.ddit.vo.MenuVo;

@WebServlet("/admin/menuUpdate.do")
@MultipartConfig
public class MenuUpdateController extends HttpServlet {
	MenuService menuService = MenuService.getInstance();
	FileService fileService = FileService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 현재 미사용 - 모달로 처리중임 24.12.28
		String[] params = {"restaurantNo", "menuName", "menuPrice"};
		
		ParamResult paramResult = ParamResult.valid(req, params);// 필수인자 확인
		
		if (paramResult.getCode() == 1 && !paramResult.getMessage().equals("")) {
			// 에러 메시지를 요청 속성에 추가
			req.setAttribute("errorMessage", paramResult.getMessage());

			// 에러 페이지로 포워드
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}
		MenuVo menu = RequestToVoMapper.mapRequestToVo(req, MenuVo.class);

		// 이전 메뉴 정보 가져오기
		List<MenuVo> menuList = menuService.list(menu.getRestaurantNo());
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] requiredParams = { "restaurantNo", "menuNo", "menuName", "menuPrice" };

		ParamResult paramResult = ParamResult.valid(req, requiredParams);// 필수인자 확인

		if (paramResult.getCode() == 1 && !paramResult.getMessage().equals("")) {
			// 에러 메시지를 요청 속성에 추가
			req.setAttribute("errorMessage", paramResult.getMessage());

			// 에러 페이지로 포워드
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}
		
		MenuVo updateMenu = RequestToVoMapper.mapRequestToVo(req, MenuVo.class);

		// 파일 삭제하는지 확인
		if (updateMenu.getRemoveFileId() != 0) {
			int[] removeId = {updateMenu.getRemoveFileId()};
			fileService.deleteFiles(removeId);
			updateMenu.setFileNo(0);
		}

		// 새로운 파일 정보 추가
		FileVo file = FileUpload.fileWrite(req, "menu");
		if (file != null) {
			List<FileVo> filsList = new ArrayList<FileVo>();
			filsList.add(file);
			fileService.addFiles(filsList);
			
			updateMenu.setFileNo(file.getFileNo());
		}
		
		// 메뉴 업데이트
		menuService.update(updateMenu);
		
		resp.sendRedirect(req.getContextPath() + "/admin/restaurantDetail.do?restaurantNo= " + updateMenu.getRestaurantNo());
	}
}
