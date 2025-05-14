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
import kr.or.ddit.vo.ReviewReportVo;

@WebServlet("/admin/reviewReportList.do")
public class ReviewReportListController extends HttpServlet {
	
		ReviewReportService reportService = ReviewReportService.getInstance();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Pagenation<ReviewReportVo> pagenation = RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
		    pagenation.setSearchVo(RequestToVoMapper.mapRequestToVo(req, ReviewReportVo.class));
//		    pagenation.getSearchVo().set(N); // 		      

			int totalCount = reportService.getAllCount(pagenation);
			pagenation.setTotalRecordCount(totalCount);
			System.out.println(totalCount);
			List<ReviewReportVo> reviewReportList = reportService.list(pagenation);

			req.setAttribute("paginationInfo", pagenation);
			req.setAttribute("reviewReportList", reviewReportList);


			
			ServletContext ctx = req.getServletContext();
			ctx.getRequestDispatcher("/WEB-INF/view/admin/reviewReport/reviewReportList.jsp").forward(req, resp);
		}

}
