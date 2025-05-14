package kr.or.ddit.admin.member.controller;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.admin.member.service.MemberService;
import kr.or.ddit.vo.MemberVo;
import kr.or.ddit.vo.MileageVo;
@WebServlet("/admin/adminMemberMileageInsert.do")
public class AdminMemberMileageInsert extends HttpServlet{
	
	MemberService memberService = MemberService.getInstance();
	kr.or.ddit.site.member.service.MemberService siteMService = kr.or.ddit.site.member.service.MemberService.getInstance();
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		HttpSession session = req.getSession();
//		MemberVo member = (MemberVo) session.getAttribute("member");
		
		
		String memberNoString = req.getParameter("memberNo");
		int memberNo = Integer.parseInt(memberNoString);

		String uesEarnStr = req.getParameter("uesEarn");
	
  
		String pointStr = req.getParameter("point");
		int point = Integer.parseInt(pointStr);

		
		MemberVo member = new MemberVo();
		member.setMemberNo(memberNo);
		int pMileage= siteMService.getMileage(member);
		
		MileageVo mileageVo = new MileageVo();
		mileageVo.setMileageNo(point);
		mileageVo.setMemberNo(memberNo);
		mileageVo.setMileageUsed(uesEarnStr); // 여기 값 변경 (적립 인지 사용인지)
		mileageVo.setMileagePoint(point);

		
		
		 int insertMileage = memberService.MileageInsert(mileageVo);
		
		int updateMileage = uesEarnStr.equals("0") ? pMileage - point :  pMileage + point;
		
		System.out.println(updateMileage);
//		
		MemberVo memberVo = new MemberVo();
		memberVo.setMemberMileage(updateMileage);
		memberVo.setMemberNo(memberNo);
//				
		siteMService.mileageUpdate(memberVo);	
		
		
		

		resp.sendRedirect(req.getContextPath() + "/admin/adminMemberMileageList.do?memberNo=" + memberNo);

	}

	


}
