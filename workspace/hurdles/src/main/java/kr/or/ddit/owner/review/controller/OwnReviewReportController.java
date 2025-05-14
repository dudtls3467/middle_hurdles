
package kr.or.ddit.owner.review.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.owner.review.service.OwnReviewService;
import kr.or.ddit.vo.ReviewReportVo;
@WebServlet("/owner/ownReviewReport.do")
public class OwnReviewReportController extends HttpServlet{
	
	OwnReviewService ownReviewService = OwnReviewService.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String reviewNoStr=req.getParameter("reviewNo");
		int reviewNo = Integer.parseInt(reviewNoStr);
		String reviewReportDes = req.getParameter("reviewReportDes");
		
		ReviewReportVo reviewReportVo = new ReviewReportVo();
		reviewReportVo.setReviewNo(reviewNo);
		reviewReportVo.setReviewReportDes(reviewReportDes);
	
		
		ReviewReportVo ownReviewOne = ownReviewService.ownReviewOne(reviewReportVo);
		
		ownReviewOne.setReviewReportDes(reviewReportDes);
		ownReviewService.reviewReport(ownReviewOne);
		
		resp.sendRedirect(req.getContextPath() + "/owner/ownReviewList.do");
	}
}
