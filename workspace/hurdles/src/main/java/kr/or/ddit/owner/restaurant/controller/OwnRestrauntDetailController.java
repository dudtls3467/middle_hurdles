package kr.or.ddit.owner.restaurant.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.menu.service.MenuService;
import kr.or.ddit.admin.restaurant.service.RestaurantService;
import kr.or.ddit.util.ParamResult;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.FileVo;
import kr.or.ddit.vo.MenuVo;
import kr.or.ddit.vo.RestaurantVo;

@WebServlet("/owner/ownRestaurantDetail.do")
@MultipartConfig
public class OwnRestrauntDetailController extends HttpServlet {
	RestaurantService resService = RestaurantService.getInstance();
	MenuService menuService = MenuService.getInstance();

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

		RestaurantVo restaurant = resService.detail(param);

		// 식당 이미지 파일
		List<FileVo> fileList = resService.getFileList(param);

		// 메뉴 목록
		List<MenuVo> menuList = menuService.list(param.getRestaurantNo());
		// 예약 메뉴
		// 주문 메뉴

		req.setAttribute("restaurant", restaurant);
		req.setAttribute("fileList", fileList);
		req.setAttribute("menuList", menuList);

		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/owner/restaurant/ownRestaurantDetail.jsp").forward(req, resp);
	}
}
