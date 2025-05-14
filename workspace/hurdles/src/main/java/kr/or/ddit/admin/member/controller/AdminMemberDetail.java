package kr.or.ddit.admin.member.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.member.service.MemberService;
import kr.or.ddit.vo.FileVo;
import kr.or.ddit.vo.MemberVo;
import kr.or.ddit.vo.MileageVo;
@WebServlet("/admin/adminMemberDetail.do")
@MultipartConfig
public class AdminMemberDetail extends HttpServlet{
	MemberService memberService = MemberService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		String memberNoStr = req.getParameter("memberNo");
		int memberNo = Integer.parseInt(memberNoStr);			
		
		MemberVo membervo = new MemberVo();
		membervo.setMemberNo(memberNo);
		
		MemberVo mileageMemberVo =memberService.mileageSelect(membervo);
		req.setAttribute("memberMileage", mileageMemberVo);
		
		
		MemberVo member =  memberService.detail(membervo);
		req.setAttribute("memberDetail", member); 
		
		
		
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/member/adminMemberDetail.jsp").forward(req, resp);
			
		
	}
	

}
