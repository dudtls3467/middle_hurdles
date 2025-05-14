package kr.or.ddit.main.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.main.admin.service.AdminMainService;
import kr.or.ddit.util.JsonUtil;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.MainVo;

@WebServlet("/admin/main.do")
public class AdminMainController extends HttpServlet {
	
	AdminMainService adminMainService = AdminMainService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MainVo mainVo = new MainVo();
		//수수료(매출)
		//double fee = 0.1;
		double payTotalPrice = (double)(adminMainService.payTotalPrice(mainVo));
		int reservationCnt = adminMainService.reservationCnt(mainVo);
		int memberCnt = adminMainService.memberCnt(mainVo);
		int reviewCnt = adminMainService.reviewCnt(mainVo);
		int ordersCnt = adminMainService.ordersCnt(mainVo);
		
		System.out.println(reviewCnt);
		System.out.println(ordersCnt);
		//목표
		double targetMember = 1000;
		double targetPrice = 50_000_000;
		double targetOrder = 9000;
		double targetReview = 800;
		double targetReservation = 500;
		//%
		double ordersPerReview= (double)reviewCnt/ordersCnt*100;
		double targetMM = (double)memberCnt/targetMember*100;
		double targetPP = payTotalPrice/targetPrice*100;
		double targetOO = (double)ordersCnt/targetOrder*100;
		double targetRR = (double)reviewCnt/targetReview*100;
		double targetRes = (double)reservationCnt/targetReservation*100;
		
		//현재
		req.setAttribute("payTotalPrice", payTotalPrice);
		req.setAttribute("reservationCnt", reservationCnt);
		req.setAttribute("memberCnt", memberCnt);
		req.setAttribute("reviewCnt", reviewCnt);
		req.setAttribute("ordersPerReview", ordersPerReview);
		req.setAttribute("ordersCnt", ordersCnt);
		
		//target
		req.setAttribute("targetMember", targetMember);
		req.setAttribute("targetPrice", targetPrice);
		req.setAttribute("targetOrder", targetOrder);
		req.setAttribute("targetReview", targetReview);
		req.setAttribute("targetReservation", targetReservation);
		
		//%
		req.setAttribute("targetMM", targetMM);
		req.setAttribute("targetPP", targetPP);
		req.setAttribute("targetOO", targetOO);
		req.setAttribute("targetRR", targetRR);
		req.setAttribute("targetRes", targetRes);
		
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/admin/main.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MainVo mainVo = new MainVo();
		
		List<MainVo>localRestaurantCnt = adminMainService.localRestaurantCnt(mainVo);
		List<MainVo> eachPrice = adminMainService.eachPrice(mainVo);
		
		System.out.println(eachPrice);
		
		Map<String,Object> map = new HashMap<String,Object>();
		resp.setContentType("application/json");
		map.put("price", eachPrice);
		map.put("item",localRestaurantCnt);
		resp.getWriter().write(JsonUtil.toJson(map));
		
		
	}
	
	
}
