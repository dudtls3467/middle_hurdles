package kr.or.ddit.site.cart.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.site.cart.service.CartService;
import kr.or.ddit.site.cart.service.ICartService;
import kr.or.ddit.vo.CartVo;

@WebServlet("/site/cartDelete.do")
public class CartDeleteController extends HttpServlet {

	ICartService cartService = CartService.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cartNoStr = req.getParameter("cartNo");
		int cartNo = Integer.parseInt(cartNoStr);

		int[] cartRemoveIds = { cartNo };
		int delete = cartService.delete(cartRemoveIds);
		System.out.println(delete);
	}
}
