package kr.or.ddit.owner.reservation.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.owner.reservation.service.OwnReservationService;
import kr.or.ddit.vo.MemberVo;
import kr.or.ddit.vo.ReservationVo;

@WebServlet("/owner/ownerReservationList.do")
public class OwnReservationListController extends HttpServlet {
	
	OwnReservationService ownReservationService = OwnReservationService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		MemberVo member =(MemberVo) session.getAttribute("member");
		int memberNo = member.getMemberNo();
		
		ReservationVo reservationVo = new ReservationVo();
		
		reservationVo.setMemberNo(memberNo);
		
		List<ReservationVo>reservationList =ownReservationService.list(reservationVo);
		
		req.setAttribute("reservationList", reservationList);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/owner/reservation/ownReservationList.jsp").forward(req, resp);
	}
}
