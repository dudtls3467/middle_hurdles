package kr.or.ddit.site.cart.service;

import java.util.List;

import kr.or.ddit.site.cart.dao.CartDao;
import kr.or.ddit.vo.CartVo;
import kr.or.ddit.vo.MemberVo;

public class CartService implements ICartService {
	private static CartService instance;

	private CartService() {

	}

	public static CartService getInstance() {
		if (instance == null) {
			instance = new CartService();
		}

		return instance;
	}
	
	CartDao cartDao = CartDao.getInstance();

	@Override
	public List<CartVo> list(CartVo Cart) {
		
		return cartDao.list(Cart);
	}

	@Override
	public int insert(CartVo cart) {
		
		return cartDao.insert(cart);
	}

	@Override
	public int update(CartVo cart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cartQtyUpdate(CartVo cart) {
		// TODO Auto-generated method stub
		return cartDao.cartQtyUpdate(cart);
	}

	@Override
	public CartVo getCartByCartNo(int cartNo) {
		// TODO Auto-generated method stub
		return cartDao.getCartByCartNo(cartNo);
	}

	@Override
	public int delete(int[] removeId) {
		// TODO Auto-generated method stub
		return cartDao.delete(removeId);
	}

	@Override
	public int cartDelete(CartVo cart) {
		// TODO Auto-generated method stub
		return cartDao.cartDelete(cart);
	}

	
	
}
