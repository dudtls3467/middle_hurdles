package kr.or.ddit.admin.restaurant.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.restaurant.service.RestaurantService;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.RestaurantVo;

@WebServlet("/admin/restaurantList.do")
public class RestaurantListController extends HttpServlet {
	RestaurantService resService = RestaurantService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pagenation<RestaurantVo> pagenation = RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
		pagenation.setSearchVo(RequestToVoMapper.mapRequestToVo(req, RestaurantVo.class));
		pagenation.getSearchVo().setDelyn("Y");

		int totalCount = resService.getAllCount(pagenation);
		pagenation.setTotalRecordCount(totalCount);

		List<RestaurantVo> restaurantList = resService.list(pagenation);

		req.setAttribute("paginationInfo", pagenation);
		req.setAttribute("restaurantList", restaurantList);

		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/restaurant/restaurantList.jsp").forward(req, resp);
	}
}
