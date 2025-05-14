package kr.or.ddit.site.orders.service;

import kr.or.ddit.site.orders.dao.IOrdersDao;
import kr.or.ddit.site.orders.dao.OrdersDao;
import kr.or.ddit.site.pay.dao.IPayDao;
import kr.or.ddit.vo.OrdersVo;

public class OrderService implements IOrdersService {
	private static OrderService instance;

	private OrderService() {

	}

	public static OrderService getInstance() {
		if (instance == null) {
			instance = new OrderService();
		}

		return instance;
	}

	IOrdersDao ordersDao = OrdersDao.getInstance();

	@Override
	public int ordersInsert(OrdersVo orders) {
		// 처음 ORDER_NO 가져와서 변수에 담아놓고
		// 오더 INSERT
		// ORDER_PRODUCT INSERT
		// PAY INSERT
		
		// 장바구니 삭제
		// 쿠폰 사용 했으면 처리
		// 마일리지 사용 했으면 처리
		// PROFILE UPDATE (마일리지 적립)

		return ordersDao.ordersInsert(orders);
	}

	@Override
	public int odersNoGet() {
		// TODO Auto-generated method stub
		return ordersDao.odersNoGet();
	}
}
