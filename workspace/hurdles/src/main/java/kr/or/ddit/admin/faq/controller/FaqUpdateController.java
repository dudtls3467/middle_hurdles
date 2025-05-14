package kr.or.ddit.admin.faq.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.faq.service.FaqService;
import kr.or.ddit.util.ParamResult;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;
import kr.or.ddit.vo.FileVo;

@WebServlet("/admin/faqUpdate.do")
@MultipartConfig
public class FaqUpdateController extends HttpServlet {

	FaqService faqService = FaqService.getInstance();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		BoardVo searchBoard = RequestToVoMapper.mapRequestToVo(req, BoardVo.class);
		
		BoardVo board = faqService.detail(searchBoard.getBoardNo());

		req.setAttribute("board", board);

		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/faq/faqUpdate.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardVo board = RequestToVoMapper.mapRequestToVo(req, BoardVo.class);

		int result = faqService.update(board);
		
		if (result == 1) {
			
		}
			
		
//		resp.sendRedirect(req.getContextPath() + "/admin/faqDetail.do?boardNo=" + board.getBoardNo());
		resp.sendRedirect(req.getContextPath()+"/admin/faqList.do");
		
	}
	
	
}
	