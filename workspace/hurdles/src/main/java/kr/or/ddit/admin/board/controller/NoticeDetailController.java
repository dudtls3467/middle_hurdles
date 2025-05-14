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

@WebServlet("/admin/noticeDetail.do")
public class NoticeDetailController extends HttpServlet {

	NoticeService noticeService = NoticeService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("detail실행");
		
		String boardNoStr = req.getParameter("boardNo");
		
		int boardNo = Integer.parseInt(boardNoStr);
		
		BoardVo board =  noticeService.detail(boardNo);
		
		req.setAttribute("board", board);
		
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/board/noticeDetail.jsp").forward(req, resp);
		
		
	}
	
}
