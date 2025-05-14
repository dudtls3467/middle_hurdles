package kr.or.ddit.admin.board.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.board.service.NoticeService;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;

@WebServlet("/admin/noticeList.do")
public class NoticeListController extends HttpServlet{

	NoticeService noticeService = NoticeService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Pagenation<BoardVo> pagenation = RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
	    pagenation.setSearchVo(RequestToVoMapper.mapRequestToVo(req, BoardVo.class));
	    pagenation.getSearchVo().setBoardCodeNo(1); // 공지사항으로 세팅
	      

		int totalCount = noticeService.getAllCount(pagenation);
		pagenation.setTotalRecordCount(totalCount);

		System.out.println(pagenation);
		List<BoardVo> noticeList = noticeService.list(pagenation);

		req.setAttribute("paginationInfo", pagenation);
		req.setAttribute("noticeList", noticeList);

		System.out.println(noticeList);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/board/noticeList.jsp").forward(req, resp);
	}
}
