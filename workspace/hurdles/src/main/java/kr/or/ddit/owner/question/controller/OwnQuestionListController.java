package kr.or.ddit.owner.question.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.owner.question.service.QuestionService;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.MemberVo;
import kr.or.ddit.vo.QuestionVo;

@WebServlet("/owner/ownQuestionList.do")
public class OwnQuestionListController extends HttpServlet {
	
	QuestionService questionService = QuestionService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Pagenation<QuestionVo> pagenation = RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
	    pagenation.setSearchVo(RequestToVoMapper.mapRequestToVo(req, QuestionVo.class));
	    HttpSession session = req.getSession(); // 기존 세션 가져오기
		MemberVo member = (session.getAttribute("member") != null) ? (MemberVo) session.getAttribute("member") : new MemberVo();
		System.out.println(member.getMemberNo());
		pagenation.getSearchVo().setMemberNo(member.getMemberNo());
		
//	    pagenation.getSearchVo().setRestaurantNo(0); // 공지사항으로 세팅
	      
		
		int totalCount = questionService.getAllCount(pagenation);
		System.out.println(totalCount);
		pagenation.setTotalRecordCount(totalCount);

		System.out.println(pagenation);
		List<QuestionVo> ownQuestionList = questionService.list(pagenation);

		req.setAttribute("paginationInfo", pagenation);
		req.setAttribute("ownQuestionList", ownQuestionList);

		System.out.println(ownQuestionList);
		System.out.println(ownQuestionList.size());
		
		
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/owner/question/ownQuestionList.jsp").forward(req, resp);
		
		
	}
	
}
