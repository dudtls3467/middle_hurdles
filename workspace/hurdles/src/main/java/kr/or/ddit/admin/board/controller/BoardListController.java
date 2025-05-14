package kr.or.ddit.admin.board.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.board.service.BoardService;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;

@WebServlet("/admin/boardList.do")
public class BoardListController extends HttpServlet {
	BoardService boardService = BoardService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pagenation<BoardVo> pagenation = RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
		pagenation.setSearchVo(RequestToVoMapper.mapRequestToVo(req, BoardVo.class));

		int totalCount = boardService.getTotalPageCount(pagenation);
		pagenation.setTotalRecordCount(totalCount);

		List<BoardVo> boardList = boardService.list(pagenation);

		req.setAttribute("paginationInfo", pagenation);
		req.setAttribute("boardList", boardList);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/board/boardList.jsp").forward(req, resp);
	}
}

