package kr.or.ddit.site.orders.service;

import kr.or.ddit.vo.OrdersVo;

public interface IOrdersService {

	//주문 INSERT
	public int ordersInsert(OrdersVo orders);
	
	//ORDERS_NO 가져오기
	public int odersNoGet();
}
