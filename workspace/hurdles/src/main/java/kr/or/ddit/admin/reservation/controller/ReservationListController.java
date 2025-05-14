package kr.or.ddit.admin.reservation.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.reservation.service.ReservationService;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.MemberVo;
import kr.or.ddit.vo.ReservationVo;
@WebServlet("/admin/ReservationList.do")
public class ReservationListController extends HttpServlet{
	
	ReservationService reservationService = ReservationService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pagenation<ReservationVo>pagenation = RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
		pagenation.setSearchVo(RequestToVoMapper.mapRequestToVo(req, ReservationVo.class));
		
		int totalCount = reservationService.getAllcount(pagenation);
		pagenation.setTotalRecordCount(totalCount);
		
		List<ReservationVo>list = reservationService.list(pagenation);
		req.setAttribute("list", list);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/reservation/adminReservationList.jsp").forward(req, resp);
	}

}
