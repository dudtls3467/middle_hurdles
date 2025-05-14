package kr.or.ddit.site.ordersProduct.service;

import kr.or.ddit.vo.OrdersProductVo;

public interface IOrdersProductService {

	// 주문상품 등록
	public int ordersProductInsert(OrdersProductVo ordersProduct);
}
