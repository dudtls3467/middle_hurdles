package kr.or.ddit.owner.restaurant.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.admin.restaurant.service.RestaurantService;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.MemberVo;
import kr.or.ddit.vo.RestaurantVo;

@WebServlet("/owner/ownRestaurantList.do")
public class OwnRestaurantListController extends HttpServlet {
	RestaurantService resService = RestaurantService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVo member = session.getAttribute("member") == null ? new MemberVo()
					: (MemberVo) session.getAttribute("member");
		
		
		System.out.println(member);
		
		Pagenation<RestaurantVo> pagenation = RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
		pagenation.setSearchVo(RequestToVoMapper.mapRequestToVo(req, RestaurantVo.class));
		pagenation.getSearchVo().setMemberNo(member.getMemberNo());
		
		int totalCount = resService.getAllCount(pagenation);
		pagenation.setTotalRecordCount(totalCount);

		List<RestaurantVo> ownRestaurantList = resService.list(pagenation);

		req.setAttribute("paginationInfo", pagenation);
		req.setAttribute("restaurantList", ownRestaurantList);

		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/owner/restaurant/ownRestaurantList.jsp").forward(req, resp);
	}
}
