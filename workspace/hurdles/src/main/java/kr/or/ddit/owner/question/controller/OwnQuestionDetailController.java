package kr.or.ddit.owner.question.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.owner.question.service.QuestionService;
import kr.or.ddit.vo.QuestionVo;

@WebServlet("/owner/ownQuestionDetail.do")
public class OwnQuestionDetailController extends HttpServlet{
	
	QuestionService questionService = QuestionService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String questionNoStr = req.getParameter("questionNo");	
	
	int questionNo = Integer.parseInt(questionNoStr);
	
	QuestionVo question = questionService.detail(questionNo);
	String questionError = "";
	
	if(question.getQuestionAnswer()==null) {
		question.setQuestionAnswer(questionError);
	}
	
	
	req.setAttribute("question", question);

	
	
	ServletContext ctx = req.getServletContext();
	ctx.getRequestDispatcher("/WEB-INF/view/owner/question/ownQuestionDetail.jsp").forward(req, resp);
			
		
		
	}

}
