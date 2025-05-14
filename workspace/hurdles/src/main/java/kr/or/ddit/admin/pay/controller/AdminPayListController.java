package kr.or.ddit.admin.pay.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.pay.service.PayService;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.PayVo;
@WebServlet("/admin/adminpPayList.do")
public class AdminPayListController extends HttpServlet{
	
	PayService payService = PayService.getInstance();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pagenation<PayVo>pagenation = RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
		pagenation.setSearchVo(RequestToVoMapper.mapRequestToVo(req, PayVo.class));
		System.out.println("pay컨트롤러");
		int totalCount = payService.getAllcount(pagenation);
		pagenation.setTotalRecordCount(totalCount);
		
		List<PayVo> list = payService.list(pagenation);
		req.setAttribute("list", list);
		System.out.println("리스트 ========>"+list);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/pay/adminPayList.jsp").forward(req, resp);
	}
	
}
 