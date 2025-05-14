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
import kr.or.ddit.vo.MileageVo;

@WebServlet("/admin/adminMemberMileageList.do")
@MultipartConfig
public class AdminMemberMileageList extends HttpServlet {

	MemberService memberService = MemberService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberNoString = req.getParameter("memberNo");
		int memberNo = Integer.parseInt(memberNoString);

		MileageVo mileageVo = new MileageVo();
		mileageVo.setMemberNo(memberNo);

		List<MileageVo> mileageList = memberService.MileageList(mileageVo);
		req.setAttribute("list", mileageList);  
		req.setAttribute("memberNo", memberNo);

		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/member/adminMemberMileage.jsp").forward(req, resp);

	}

	
}
