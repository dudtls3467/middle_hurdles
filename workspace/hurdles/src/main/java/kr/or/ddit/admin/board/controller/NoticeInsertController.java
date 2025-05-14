package kr.or.ddit.admin.board.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.board.service.NoticeService;
import kr.or.ddit.vo.BoardVo;

@WebServlet("/admin/noticeInsert.do")
public class NoticeInsertController extends HttpServlet{

	NoticeService noticeService = NoticeService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("notice Insert실행");
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/board/noticeInsert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post실행");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
//		String memberNoStr = req.getParameter("memberNo");
		
//		int memberNo = Integer.parseInt(memberNoStr);
		
		BoardVo board = new BoardVo();
		board.setBoardTitle(title);
		board.setBoardContent(content);
//		board.setMemberNo(memberNo);
		
		noticeService.insert(board);
		
		resp.sendRedirect(req.getContextPath()+"/admin/noticeList.do");
		
		
	}
	
}
