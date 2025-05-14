package kr.or.ddit.admin.orders.service;

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
}
