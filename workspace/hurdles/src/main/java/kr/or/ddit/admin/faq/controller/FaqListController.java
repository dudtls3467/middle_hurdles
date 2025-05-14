package kr.or.ddit.admin.faq.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.faq.service.FaqService;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;
import kr.or.ddit.vo.RestaurantVo;

@WebServlet("/admin/faqList.do")
public class FaqListController extends HttpServlet {
	
	FaqService faqService = FaqService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Pagenation<BoardVo> pagenation = RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
	    pagenation.setSearchVo(RequestToVoMapper.mapRequestToVo(req, BoardVo.class));
	    pagenation.getSearchVo().setBoardCodeNo(2); // faq으로 세팅
	      

		int totalCount = faqService.getAllCount(pagenation);
		pagenation.setTotalRecordCount(totalCount);

		System.out.println(pagenation);
		List<BoardVo> faqList = faqService.list(pagenation);

		req.setAttribute("paginationInfo", pagenation);
		req.setAttribute("faqList", faqList);

		System.out.println(faqList);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/faq/faqList.jsp").forward(req, resp);
		
		
	}
		

}
