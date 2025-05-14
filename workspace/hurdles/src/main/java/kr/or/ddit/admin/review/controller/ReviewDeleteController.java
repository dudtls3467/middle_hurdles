package kr.or.ddit.admin.review.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.review.service.ReviewDeleteService;
import kr.or.ddit.vo.ReviewReportVo;


@WebServlet("/admin/reviewReportDelete.do")
public class ReviewDeleteController extends HttpServlet {
	
	ReviewDeleteService reviewDeleteService = ReviewDeleteService.getInstance();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String reviewReportNoStr= req.getParameter("reviewReportNo");
		int reviewReportNo = Integer.parseInt(reviewReportNoStr);
		
		ReviewReportVo reviewReportVo = new ReviewReportVo();
		
		reviewReportVo.setReviewReportNo(reviewReportNo);
		
		reviewDeleteService.reviewDelete(reviewReportVo);
		
		resp.sendRedirect(req.getContextPath()+"/admin/reviewReportList.do");
	}
}
