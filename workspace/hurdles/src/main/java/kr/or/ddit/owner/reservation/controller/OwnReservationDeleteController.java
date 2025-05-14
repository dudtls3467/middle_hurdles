package kr.or.ddit.owner.reservation.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.owner.reservation.service.OwnReservationService;
import kr.or.ddit.vo.ReservationVo;

@WebServlet("/owner/ownDelete.do")
public class OwnReservationDeleteController extends HttpServlet{
	
	OwnReservationService ownReservationService = OwnReservationService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String reservationNoStr= req.getParameter("reservationNo");
		int reservationNo = Integer.parseInt(reservationNoStr);
		
		ReservationVo reservationVo = new ReservationVo();
		reservationVo.setReservationNo(reservationNo);
		
		ownReservationService.delete(reservationVo);
		
		resp.sendRedirect(req.getContextPath() + "/owner/ownerReservationList.do");
	}
}
