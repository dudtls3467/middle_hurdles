package kr.or.ddit.site.ordersProduct.service;

import kr.or.ddit.site.ordersProduct.dao.IOrdersProductDao;
import kr.or.ddit.site.ordersProduct.dao.OrdersProductDao;
import kr.or.ddit.vo.OrdersProductVo;

public class OrdersProductService implements IOrdersProductService {

	private static OrdersProductService instance;

	private OrdersProductService() {

	}

	public static OrdersProductService getInstance() {
		if (instance == null) {
			instance = new OrdersProductService();
		}
		return instance;
	}

	IOrdersProductDao ordersProductDao = OrdersProductDao.getInstance();
	
	@Override
	public int ordersProductInsert(OrdersProductVo ordersProduct) {
		// TODO Auto-generated method stub
		return ordersProductDao.ordersProductInsert(ordersProduct);
	}
}
