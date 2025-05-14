package kr.or.ddit.admin.member.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.member.service.MemberService;
import kr.or.ddit.vo.GradeVo;

@WebServlet("/admin/adminMemberGradeUpdateController.do")
public class AdminMemberGradeUpdateController extends HttpServlet {

	MemberService memberService = MemberService.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberNoStr = req.getParameter("memberNo");
		int memberNo = Integer.parseInt(memberNoStr);

		String grade = req.getParameter("grade");
		int getdeNo = Integer.parseInt(grade);

		GradeVo gradeVo = new GradeVo();
		gradeVo.setMemberNo(memberNo);
		gradeVo.setGradeNo(getdeNo);
		


		int gradeUp = memberService.memberGradeUpdate(gradeVo);
		System.out.println(gradeUp);

		resp.sendRedirect(req.getContextPath() + "/admin/adminMemberDetail.do?memberNo=" + memberNo);

	}

}
