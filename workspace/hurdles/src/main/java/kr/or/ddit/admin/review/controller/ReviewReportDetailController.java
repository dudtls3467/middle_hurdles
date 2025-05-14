package kr.or.ddit.admin.review.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.review.service.ReviewReportService;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;
import kr.or.ddit.vo.ReviewReportVo;

@WebServlet("/admin/reviewReportDetail.do")
public class ReviewReportDetailController extends HttpServlet {
	
		ReviewReportService reportService = ReviewReportService.getInstance();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("reviewReportDetail:detail실행");
			
			String reviewNoStr = req.getParameter("reviewReportNo");

			
			int reviewNo = Integer.parseInt(reviewNoStr);
			
			ReviewReportVo review =  reportService.detail(reviewNo);
			
			req.setAttribute("review", review);
			
			
			ServletContext ctx = req.getServletContext();
			ctx.getRequestDispatcher("/WEB-INF/view/admin/reviewReport/reviewReportDetail.jsp").forward(req, resp);
			
		}

}
