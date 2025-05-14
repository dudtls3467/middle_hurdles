package kr.or.ddit.owner.question.controller;

import java.io.IOException;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.bcel.generic.NEW;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
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

@WebServlet("/owner/ownQuestionUpdate.do")
@MultipartConfig
public class OwnQuestionUpdateController  extends HttpServlet{

	QuestionService questionService = QuestionService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
//		QuestionVo searchQuestion = RequestToVoMapper.mapRequestToVo(req, QuestionVo.class);
//		QuestionVo question = questionService.detail(searchQuestion.getQuestionNo());
		
		
//		String questionNoStr = req.getParameter("questionNo");
//		
//		int questionNo = Integer.parseInt(questionNoStr);
//		
//		QuestionVo question = new QuestionVo();
//		
//		question.setQuestionNo(questionNo);
//		
//		req.setAttribute("questionNo", questionNo);
//
//		questionService.update(questionNo);
//		
//		ServletContext ctx = req.getServletContext();
//		ctx.getRequestDispatcher("/WEB-INF/view/owner/question/questionDetail.jsp").forward(req, resp);
		
		QuestionVo searchQuestionVo = RequestToVoMapper.mapRequestToVo(req, QuestionVo.class);
		
		QuestionVo question = questionService.detail(searchQuestionVo.getQuestionNo());

		req.setAttribute("question", question);

		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/owner/question/ownQuestiontUpdate.jsp").forward(req, resp);
		
		
	}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
//			QuestionVo question = RequestToVoMapper.mapRequestToVo(req, QuestionVo.class);
//
//			int result = questionService.update(question);
//			
//			if (result == 1) {
//				
//			}
//			
//			resp.sendRedirect(req.getContextPath()+"/owner/ownQuestionList.do");
			
			
			QuestionVo question = RequestToVoMapper.mapRequestToVo(req, QuestionVo.class);
			System.out.println(question);
			int result = questionService.update(question);
			
			if (result == 1) {                                 
				resp.sendRedirect(req.getContextPath()+"/owner/ownQuestionDetail.do?questionNo="+question.getQuestionNo());
//				resp.sendRedirect(req.getContextPath()+"/owner/ownQuestiontList.do?questionNo="+question.getQuestionNo());
				return;
			} else {
				resp.sendRedirect(req.getContextPath()+"/owner/ownQuestionDetail.do?questionNo="+question.getQuestionNo());
//				resp.sendRedirect(req.getContextPath()+"/owner/ownQuestiontList.do?questionNo="+question.getQuestionNo());
			}
			
			
			
		}
}
