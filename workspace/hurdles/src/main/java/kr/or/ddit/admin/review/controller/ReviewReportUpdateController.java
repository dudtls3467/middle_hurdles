package kr.or.ddit.admin.review.controller;


import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.review.service.ReviewReportService;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;
import kr.or.ddit.vo.ReviewReportVo;

@WebServlet("/admin/reviewReportUpdate.do")
@MultipartConfig
public class ReviewReportUpdateController extends HttpServlet {
	
	ReviewReportService reviewReportService = ReviewReportService.getInstance();
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ReviewReportVo searchReviewReport = RequestToVoMapper.mapRequestToVo(req, ReviewReportVo.class);
		
		ReviewReportVo ReviewReport = reviewReportService.detail(searchReviewReport.getReviewReportNo());

		req.setAttribute("ReviewReport", ReviewReport);

		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/reviewReport/reviewReportUpdate.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ReviewReportVo ReviewReport = RequestToVoMapper.mapRequestToVo(req, ReviewReportVo.class);

		int result = reviewReportService.update(ReviewReport);
		
		if (result == 1) {
			
		}
		
		resp.sendRedirect(req.getContextPath()+"/admin/reviewReportList.do");
	}

}
