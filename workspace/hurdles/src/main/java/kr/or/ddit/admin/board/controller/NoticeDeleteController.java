package kr.or.ddit.admin.board.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.board.service.NoticeService;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;

@WebServlet("/admin/noticeDelete.do")
public class NoticeDeleteController extends HttpServlet{

	NoticeService noticeService = NoticeService.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardVo param = RequestToVoMapper.mapRequestToVo(req, BoardVo.class);
		int result = noticeService.delete(param);
		
		if (result == 1) {
			resp.sendRedirect(req.getContextPath() + "/admin/noticeList.do");
			return;
		}

		resp.sendRedirect(req.getContextPath() + "/admin/noticeDetail.do?boardNo=" + param.getBoardNo());
	}
		
}
	
