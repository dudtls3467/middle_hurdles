package kr.or.ddit.main.owner.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.main.owner.service.OwnerMainService;
import kr.or.ddit.vo.MainVo;
import kr.or.ddit.vo.MemberVo;

@WebServlet("/owner/main.do")
public class OwnerMainController extends HttpServlet {
	
	OwnerMainService ownerMainService = OwnerMainService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		MemberVo member = (MemberVo)session.getAttribute("member");
		int memberNo = member.getMemberNo();
		
		MainVo mainVo = new MainVo();
		mainVo.setMemberNo(memberNo);
		
		int ownGetTotalPrice = ownerMainService.ownGetTotalPrice(mainVo);
		int ownGetCountReservation = ownerMainService.ownGetCountReservation(mainVo);
		int ownGetCountOrder = ownerMainService.ownGetCountOrder(mainVo);
		int ownReviewCount = ownerMainService.ownReviewCount(mainVo);
		int ownReviewScore = ownerMainService.ownReviewScore(mainVo);
		//고객만족도(평점)
		double reviewPer = (double)ownReviewScore/5*100;
		System.out.println(reviewPer);
		int ownRestaurant = ownerMainService.ownRestaurant(mainVo);
		
		req.setAttribute("ownRestaurant", ownRestaurant);
		req.setAttribute("reviewPer", reviewPer);
		req.setAttribute("ownGetTotalPrice", ownGetTotalPrice);
		req.setAttribute("ownGetCountReservation", ownGetCountReservation);
		req.setAttribute("ownGetCountOrder", ownGetCountOrder);
		req.setAttribute("ownReviewCount", ownReviewCount);
		req.setAttribute("ownReviewScore", ownReviewScore);
		
		
		ServletContext ctx = req.getServletContext();

		ctx.getRequestDispatcher("/WEB-INF/view/owner/main.jsp").forward(req, resp);
	}
}
