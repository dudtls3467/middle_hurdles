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
import kr.or.ddit.vo.CouponVo;
@WebServlet("/admin/AdminMemberCouponList.do")
public class AdminMemberCouponList extends HttpServlet{
	
	MemberService memberService =MemberService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberNoString = req.getParameter("memberNo");
		int memberNo = Integer.parseInt(memberNoString);
		
		CouponVo vo =  new CouponVo();
		vo.setMemberNo(memberNo);
		
		
		List<CouponVo> list = memberService.memberCoupon(vo);
		
		req.setAttribute("list", list);
		req.setAttribute("memberNo",memberNo);
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/member/adminMemberCouponList.jsp").forward(req, resp);
	}

}
