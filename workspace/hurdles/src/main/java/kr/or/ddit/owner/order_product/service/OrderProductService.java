package kr.or.ddit.owner.order_product.service;

public class OrderProductService implements IOrderProductService {
	private static OrderProductService instance;

	private OrderProductService() {

	}

	public static OrderProductService getInstance() {
		if (instance == null) {
			instance = new OrderProductService();
		}

		return instance;
	}
}
