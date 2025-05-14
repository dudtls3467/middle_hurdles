package kr.or.ddit.admin.member.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.member.service.MemberService;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.MemberVo;

@WebServlet("/admin/memberList.do")
public class MemberListController extends HttpServlet{
	
	MemberService memberService = MemberService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pagenation<MemberVo> pagenation = RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
		pagenation.setSearchVo(RequestToVoMapper.mapRequestToVo(req, MemberVo.class));

		int totalCount = memberService.getAllCount(pagenation);
		pagenation.setTotalRecordCount(totalCount);
		
		
		
		List<MemberVo>list = memberService.list(pagenation);
		req.setAttribute("list", list);
		
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/member/adminMemberList.jsp").forward(req, resp);
		
	}

}
