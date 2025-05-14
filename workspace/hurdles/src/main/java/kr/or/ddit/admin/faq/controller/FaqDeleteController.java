package kr.or.ddit.admin.faq.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.faq.service.FaqService;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.BoardVo;
import kr.or.ddit.vo.RestaurantVo;

@WebServlet("/admin/faqDelete.do")
public class FaqDeleteController extends HttpServlet{

FaqService faqService = FaqService.getInstance();
	
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardVo param = RequestToVoMapper.mapRequestToVo(req, BoardVo.class);
		int result = faqService.delete(param);
		
		if (result == 1) {
			resp.sendRedirect(req.getContextPath() + "/admin/faqList.do");
			return;
		}

		resp.sendRedirect(req.getContextPath() + "/admin/faqDetail.do?boardNo=" + param.getBoardNo());
		}
		
	}
	
	
	

	

