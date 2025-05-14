package kr.or.ddit.owner.review.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.owner.review.service.OwnReviewService;
import kr.or.ddit.vo.MemberVo;
import kr.or.ddit.vo.ReviewVo;

@WebServlet("/owner/ownReviewList.do")
public class OwnReviewListController extends HttpServlet{
	
	OwnReviewService ownReviewService = OwnReviewService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		MemberVo memberVo = (MemberVo)session.getAttribute("member");
		
		int memberNo = memberVo.getMemberNo();
		
		ReviewVo reviewVo = new ReviewVo();
		
		reviewVo.setMemberNo(memberNo);
		
		List<ReviewVo> reviewList = ownReviewService.reviewList(reviewVo);
		
		req.setAttribute("reviewList", reviewList);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/owner/review/ownReviewList.jsp").forward(req, resp);
		
		
	}
}
