package kr.or.ddit.owner.menu.controller;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.site.menu.service.MenuService;
import kr.or.ddit.util.ParamResult;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.MenuVo;
import kr.or.ddit.vo.ReserveProductVo;

@WebServlet("/owner/reserveProductDelete.do")
public class ReserveProductDeleteController extends HttpServlet {
	MenuService menuService = MenuService.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] requiredParams = { "reserveProductNo", "restaurantNo" };

		ParamResult paramResult = ParamResult.valid(req, requiredParams);// 필수인자 확인

		if (paramResult.getCode() == 1 && !paramResult.getMessage().equals("")) {
			// 에러 메시지를 요청 속성에 추가
			req.setAttribute("errorMessage", paramResult.getMessage());

			// 에러 페이지로 포워드
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}
		
		String restaurantName = req.getParameter("restaurantName");
		String encodedRestaurantName = URLEncoder.encode(restaurantName, "UTF-8");
		
		ReserveProductVo param = RequestToVoMapper.mapRequestToVo(req, ReserveProductVo.class);
		
		// 메뉴 삭제
		menuService.reserveProductDelete(param);
		
		resp.sendRedirect(req.getContextPath() + "/owner/reserveProductList.do?restaurantNo=" + param.getRestaurantNo()
		 	+ "&restaurantName=" + encodedRestaurantName);
	}
}
