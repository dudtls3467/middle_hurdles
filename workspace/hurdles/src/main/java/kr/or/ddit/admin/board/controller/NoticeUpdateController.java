package kr.or.ddit.admin.board.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.board.service.NoticeService;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;

@WebServlet("/admin/noticeUpdate.do")
@MultipartConfig
public class NoticeUpdateController extends HttpServlet{
	
	NoticeService noticeService = NoticeService.getInstance();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		BoardVo searchBoard = RequestToVoMapper.mapRequestToVo(req, BoardVo.class);
		
		BoardVo board = noticeService.detail(searchBoard.getBoardNo());

		req.setAttribute("board", board);

		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/board/noticeUpdate.jsp").forward(req, resp);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardVo board = RequestToVoMapper.mapRequestToVo(req, BoardVo.class);

		int result = noticeService.update(board);
		
		if (result == 1) {
			
		}
		
		resp.sendRedirect(req.getContextPath()+"/admin/noticeList.do");
		
	}
	
}
