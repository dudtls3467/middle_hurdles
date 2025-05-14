package kr.or.ddit.site.restaurant.controller;

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
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.admin.restaurant.service.RestaurantService;
import kr.or.ddit.site.coupon.service.CouponService;
import kr.or.ddit.site.menu.service.MenuService;
import kr.or.ddit.util.ParamResult;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.CouponVo;
import kr.or.ddit.vo.FileVo;
import kr.or.ddit.vo.MemberVo;
import kr.or.ddit.vo.MenuVo;
import kr.or.ddit.vo.ProductVo;
import kr.or.ddit.vo.ReserveProductVo;
import kr.or.ddit.vo.RestaurantVo;
import kr.or.ddit.vo.ReviewVo;

@WebServlet("/site/restaurantDetail.do")
public class RestaurantDetailController extends HttpServlet {
	RestaurantService resService = RestaurantService.getInstance();
	CouponService couponService = CouponService.getInstance();
	MenuService menuService = MenuService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] requiredParams = { "restaurantNo" };

		ParamResult paramResult = ParamResult.valid(req, requiredParams);// 필수인자 확인

		if (paramResult.getCode() == 1 && !paramResult.getMessage().equals("")) {
			// 에러 메시지를 요청 속성에 추가
			req.setAttribute("errorMessage", paramResult.getMessage());

			// 에러 페이지로 포워드
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}
		
		HttpSession session = req.getSession(); // 기존 세션 가져오기
		MemberVo member = (session.getAttribute("member") != null) ? (MemberVo) session.getAttribute("member") : new MemberVo();
		
		RestaurantVo restaurantParam = RequestToVoMapper.mapRequestToVo(req, RestaurantVo.class);
		restaurantParam.setMemberNo(member.getMemberNo());
		RestaurantVo restaurant = resService.detail(restaurantParam);

		// 식당 이미지 파일
		List<FileVo> fileList = resService.getFileList(restaurantParam);

		// 메뉴 목록
		MenuVo menu = new MenuVo();
		menu.setRestaurantNo(restaurant.getRestaurantNo());
		List<MenuVo> menuList = menuService.menuList(menu);
		
		// 주문 메뉴
		ProductVo product = new ProductVo();
		product.setRestaurantNo(restaurant.getRestaurantNo());
		List<ProductVo> productList = menuService.productList(product);
		
		// 예약 메뉴
		ReserveProductVo reserveProduct = new ReserveProductVo();
		reserveProduct.setRestaurantNo(restaurant.getRestaurantNo());
		List<ReserveProductVo> reserveProductList = menuService.reserveProductList(reserveProduct);

		// 쿠폰 목록
		CouponVo coupon = new CouponVo();
		coupon.setRestaurantNo(restaurant.getRestaurantNo());
		coupon.setMemberNo(member.getMemberNo());
		List<CouponVo> couponList = couponService.list(coupon);
		
		// 리뷰 목록
		Map<String, Object> reviewMap = new HashMap<String, Object>();
		reviewMap.put("memberNo", member.getMemberNo());
		reviewMap.put("restaurantNo", restaurant.getRestaurantNo());
		List<ReviewVo> reviewList = resService.reviewList(reviewMap);

		req.setAttribute("restaurant", restaurant);
		req.setAttribute("fileList", fileList);
		req.setAttribute("menuList", menuList);
		req.setAttribute("productList", productList);
		req.setAttribute("reserveProductList", reserveProductList);
		req.setAttribute("reviewList", reviewList);
		req.setAttribute("couponList", couponList);
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/site/restaurant/restaurantDetail.jsp").forward(req, resp);
	}
}
