package kr.or.ddit.admin.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.board.service.BoardService;
import kr.or.ddit.util.JsonUtil;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;

@WebServlet("/admin/boardListJson.do")
public class BoardListJsonController extends HttpServlet {
	BoardService boardService = BoardService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pagenation<BoardVo> pagenation = RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
		pagenation.setSearchVo(RequestToVoMapper.mapRequestToVo(req, BoardVo.class));

		int totalCount = boardService.getTotalPageCount(pagenation);
		pagenation.setTotalRecordCount(totalCount);
		System.out.println(pagenation);
		List<BoardVo> boardList = boardService.list(pagenation);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("items", boardList);
		
		resp.setContentType("application/json");
		resp.getWriter().write(JsonUtil.toJson(map));
	}
}
