package kr.or.ddit.admin.faq.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.board.service.BoardService;
import kr.or.ddit.admin.faq.service.FaqService;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.ParamResult;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;

@WebServlet("/admin/faqDetail.do")
public class FaqDetailController extends HttpServlet {
	
	FaqService faqService = FaqService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String boardNoStr = req.getParameter("boardNo");
//		int boardNo = Integer.parseInt(boardNoStr);
//		BoardVo boardVo = new BoardVo();
//		
//		boardVo.setBoardNo(boardNo);
//		
//		BoardVo board = faqService.detail(boardVo);			
//		
//		req.setAttribute("boardNo", board);
//		req.setAttribute("board", board);
//		Pagenation<BoardVo> pagenation = RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
//	    pagenation.setSearchVo(RequestToVoMapper.mapRequestToVo(req, BoardVo.class));
//	    pagenation.getSearchVo().setBoardCodeNo(2);
		

//		List<BoardVo> faqList = faqService.list(pagenation);
//		BoardVo board = BoardService.detail(pagenation);
//		
//		req.setAttribute("board", board);
//		
		
		String boardNoStr = req.getParameter("boardNo");
		
		int boardNo = Integer.parseInt(boardNoStr);
		
		BoardVo board =  faqService.detail(boardNo);
		
		req.setAttribute("board", board);
		
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/faq/faqDetail.jsp").forward(req, resp);
		
		
		
		
		
		
	}

}
