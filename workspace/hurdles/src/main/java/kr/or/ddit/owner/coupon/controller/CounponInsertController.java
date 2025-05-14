package kr.or.ddit.owner.coupon.controller;


import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.owner.coupon.service.CouponService;
import kr.or.ddit.vo.CouponVo;
import kr.or.ddit.vo.RestaurantVo;

@WebServlet("/owner/ownCouponInsert.do")
@MultipartConfig
public class CounponInsertController extends HttpServlet{
	
	CouponService couponService = CouponService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("쿠폰 insert실행");
		
		String resNostr = req.getParameter("restaurantNo");
		
		
		req.setAttribute("restaurantNo", resNostr);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/owner/restaurant/ownCouponInsert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
//			HttpSession session = req.getSession(false);
//			RestaurantVo restaurantNo = (RestaurantVo)session.getAttribute("restaurant");
//			RestaurantVo restaurantNo = (RestaurantVo)session.getAttribute("restaurantNo");
			
//			System.out.println("post실행");
			//쿠폰 데이터 받아오기
			String couponName  = req.getParameter("couponName");
			String couponDes = req.getParameter("couponDes");
			String couponPriceStr = req.getParameter("couponPrice");
			String staSrtDate = req.getParameter("startDate");
			String endDate = req.getParameter("endDate");
			String resNostr = req.getParameter("restaurantNo");
			
			System.out.println(couponPriceStr);
			
			int couponPrice = Integer.parseInt(couponPriceStr);
			System.out.println(resNostr);
			int restaurantNo = Integer.parseInt(resNostr);
			
			
			//쿠폰 객체 선언
			CouponVo coupon = new CouponVo();
			//쿠폰 데이터 세팅
			coupon.setCouponName(couponName);
			coupon.setCouponDes(couponDes);
			coupon.setCouponPrice(couponPrice);
			coupon.setStartDate(staSrtDate);
			coupon.setEndDate(endDate);
			coupon.setRestaurantNo(restaurantNo);
			couponService.insert(coupon);
			
			resp.sendRedirect(req.getContextPath()+"/owner/ownRestaurantList.do");
			
	}
	
	

}
