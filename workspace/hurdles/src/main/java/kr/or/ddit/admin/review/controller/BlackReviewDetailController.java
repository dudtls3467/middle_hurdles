//package kr.or.ddit.admin.review.controller;
//
//import java.io.IOException;
//
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import kr.or.ddit.admin.review.service.BlackListService;
//import kr.or.ddit.vo.BoardVo;
//import kr.or.ddit.vo.ReviewReportVo;
//
//@WebServlet("/admin/BlackReviewDetail.do")
//public class BlackReviewDetailController extends HttpServlet {
//	
//	BlackListService blackReviewService = BlackListService.getInstance();
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//System.out.println("detail실행");
//		
//		String reviewNoStr = req.getParameter("riviewNo");
//		
//		int boardNo = Integer.parseInt(reviewNoStr);
//		
//		ReviewReportVo review =  blackReviewService.detail(boardNo);
//		
//		req.setAttribute("review", review);
//		
//		
//		ServletContext ctx = req.getServletContext();
//		ctx.getRequestDispatcher("/WEB-INF/view/admin/blackReviewList/blackReviewDetail.jsp").forward(req, resp);
//		
//	}
//
//}
