package kr.or.ddit.admin.orders.dao;

public class OrdersDao implements IOrdersDao {
	private static OrdersDao instance;

	private OrdersDao() {

	}

	public static OrdersDao getInstance() {
		if (instance == null) {
			instance = new OrdersDao();
		}

		return instance;
	}
}
