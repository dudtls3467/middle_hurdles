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
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.util.ParamResult;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;
import kr.or.ddit.vo.FileVo;

@WebServlet("/admin/boardDetail.do")
public class BoardDetailController extends HttpServlet {
	BoardService boardService = BoardService.getInstance();
	FileService fileService = FileService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] params = {"boardNo"};
				
		ParamResult paramResult = ParamResult.valid(req, params);// 필수인자 확인
		
		if (paramResult.getCode() == 1 && !paramResult.getMessage().equals("")) {
			// 에러 메시지를 요청 속성에 추가
			req.setAttribute("errorMessage", paramResult.getMessage());
   
			// 에러 페이지로 포워드
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}
		
		BoardVo searchBoard = RequestToVoMapper.mapRequestToVo(req, BoardVo.class);
		List<FileVo> fileList = fileService.boardFileList(searchBoard.getBoardNo());
		BoardVo board = boardService.detail(searchBoard.getBoardNo());
		
		req.setAttribute("board", board);
		req.setAttribute("fileList", fileList);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/board/boardDetail.jsp").forward(req, resp);
	}
}
