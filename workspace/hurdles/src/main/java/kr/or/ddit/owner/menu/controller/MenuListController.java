package kr.or.ddit.owner.menu.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.site.menu.service.MenuService;
import kr.or.ddit.util.ParamResult;
import kr.or.ddit.util.Utils;
import kr.or.ddit.vo.MenuVo;

@WebServlet("/owner/menuList.do")
public class MenuListController extends HttpServlet {
	MenuService menuService = MenuService.getInstance(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] requiredParams = { "restaurantNo" };

		ParamResult paramResult = ParamResult.valid(req, requiredParams);// 필수인자 확인

		if (paramResult.getCode() == 1 && !paramResult.getMessage().equals("")) {
			// 에러 메시지를 요청 속성에 추가
			req.setAttribute("errorMessage", paramResult.getMessage());

			// 에러 페이지로 포워드
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}
		
		String restaurantNo = req.getParameter("restaurantNo");
		String restaurantName = req.getParameter("restaurantName");

		// 메뉴 목록
		MenuVo menu = new MenuVo();
		menu.setRestaurantNo(Utils.parseInt(restaurantNo, 0));
		List<MenuVo> menuList = menuService.menuList(menu);
		
		req.setAttribute("menuList", menuList);
		req.setAttribute("restaurantNo", restaurantNo);
		req.setAttribute("restaurantName", restaurantName);

		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/owner/menu/menuList.jsp").forward(req, resp);

	}
}
