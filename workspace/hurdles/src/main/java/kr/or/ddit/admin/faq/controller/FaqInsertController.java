package kr.or.ddit.admin.faq.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.faq.service.FaqService;
import kr.or.ddit.vo.BoardVo;

@WebServlet("/admin/faqInsert.do")
public class FaqInsertController extends HttpServlet{

	FaqService faqService = FaqService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("faqInsert실행");
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/faq/faqInsert.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post실행");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardVo board = new BoardVo();
		board.setBoardTitle(title);
		board.setBoardContent(content);
		
		faqService.insert(board);
		
		resp.sendRedirect(req.getContextPath()+"/admin/faqList.do");
//		resp.sendRedirect(req.getContextPath()+"faqList.do");
		
		
		
	}
	
}
