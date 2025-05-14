package kr.or.ddit.site.pay.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.site.pay.service.IPayService;
import kr.or.ddit.site.pay.service.PayService;

@WebServlet("/site/payInsert.do")
public class PayInsertController extends HttpServlet{

	IPayService payService = PayService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	}
}
