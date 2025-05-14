package kr.or.ddit.owner.order_product.dao;

public class OrderProductDao implements IOrderProductDao {
	private static OrderProductDao instance;

	private OrderProductDao() {

	}

	public static OrderProductDao getInstance() {
		if (instance == null) {
			instance = new OrderProductDao();
		}

		return instance;
	}
}
