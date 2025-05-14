package kr.or.ddit.admin.menu.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.menu.service.MenuService;
import kr.or.ddit.util.ParamResult;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.MenuVo;

@WebServlet("/admin/menuDelete.do")
public class MenuDeleteController extends HttpServlet {
	MenuService menuService = MenuService.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] requiredParams = { "menuNo", "restaurantNo" };

		ParamResult paramResult = ParamResult.valid(req, requiredParams);// 필수인자 확인

		if (paramResult.getCode() == 1 && !paramResult.getMessage().equals("")) {
			// 에러 메시지를 요청 속성에 추가
			req.setAttribute("errorMessage", paramResult.getMessage());

			// 에러 페이지로 포워드
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}
		MenuVo param = RequestToVoMapper.mapRequestToVo(req, MenuVo.class);
		
		// 메뉴 삭제
		menuService.delete(param);
		
		resp.sendRedirect(req.getContextPath() + "/admin/restaurantDetail.do?restaurantNo=" + param.getRestaurantNo());
	}
}
