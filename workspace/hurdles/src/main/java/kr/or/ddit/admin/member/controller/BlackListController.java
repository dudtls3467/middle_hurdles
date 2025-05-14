package kr.or.ddit.admin.member.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.member.service.BlackService;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;
import kr.or.ddit.vo.MemberVo;

@WebServlet("/admin/blackList.do")
public class BlackListController extends HttpServlet{
	
	BlackService blackService = BlackService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pagenation<MemberVo> pagenation = RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
	    pagenation.setSearchVo(RequestToVoMapper.mapRequestToVo(req, MemberVo.class));
//	    pagenation.getSearchVo().setBoardCodeNo(3); // 공지사항으로 세팅
	      

//		int totalCount = blackService.getAllCount(pagenation);
//		pagenation.setTotalRecordCount(totalCount);

		System.out.println(pagenation);
		List<MemberVo> blackList = blackService.list(pagenation);

		req.setAttribute("paginationInfo", pagenation);
		req.setAttribute("blackList", blackList);

		System.out.println(blackList);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/reviewReport/blackList.jsp").forward(req, resp);
		
	}
	
	
}
