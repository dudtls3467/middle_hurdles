package kr.or.ddit.admin.review.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.review.service.BlackReviewService;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.ReviewVo;

@WebServlet("/admin/BlackReviewList.do")
public class BlackReviewListController extends HttpServlet {
	
		BlackReviewService blackReviewService = BlackReviewService.getInstance();
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Pagenation<ReviewVo> pagenation = RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
		    pagenation.setSearchVo(RequestToVoMapper.mapRequestToVo(req, ReviewVo.class));
//		    pagenation.getSearchVo().set(N); // 		      

//			int totalCount = blackReviewService.getAllCount(pagenation);
//			pagenation.setTotalRecordCount(totalCount);

			System.out.println(pagenation);
//			List<ReviewVo> blackReviewList = blackReviewService.list(pagenation);

			req.setAttribute("paginationInfo", pagenation);
//			req.setAttribute("blackReviewList", blackReviewList);

//			System.out.println(blackReviewList);
			
			ServletContext ctx = req.getServletContext();
			ctx.getRequestDispatcher("/WEB-INF/view/admin/blackReviewList/blackReviewList.jsp").forward(req, resp);
		}

}
