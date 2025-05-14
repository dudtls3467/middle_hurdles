package kr.or.ddit.site.ordersProduct.dao;

import kr.or.ddit.vo.OrdersProductVo;

public interface IOrdersProductDao {
	
	// 주문상품 등록
	public int ordersProductInsert(OrdersProductVo ordersProduct);
	
}
