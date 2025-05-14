package kr.or.ddit.admin.board.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.board.service.BoardService;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.util.FileUpload;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;
import kr.or.ddit.vo.FileVo;

@WebServlet("/admin/boardInsert.do")
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 3, // 파일 개수
	maxFileSize = 1024 * 1024 * 40, // 개별 파일 사이
	maxRequestSize = 1024 * 1024 * 50 // 파일 총 용량
)
public class BoardInsertController extends HttpServlet {
	BoardService boardService = BoardService.getInstance();
	FileService fileService = FileService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/board/boardInsert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardVo board = RequestToVoMapper.mapRequestToVo(req, BoardVo.class);
		int boardNo = boardService.getBoardNo();
		board.setBoardNo(boardNo);
		
		// 게시물 insert 하기
		boardService.insert(board);

		// 진짜 파일 추가
		List<FileVo> fileList = FileUpload.fileListWrite(req, "board");

		if (fileList.size() > 0) {
			// 파일 DB에 저장
			fileService.addFiles(fileList);
			
			// board, Files 연결			
			fileService.addBoardFile(fileList, boardNo);
		}

		resp.sendRedirect(req.getContextPath() + "/admin/boardDetail.do?boardNo=" + boardNo);
	}
}
