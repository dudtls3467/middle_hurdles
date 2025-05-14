package kr.or.ddit.site.ordersProduct.dao;

import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.OrdersProductVo;

public class OrdersProductDao extends MybatisDao implements IOrdersProductDao {

	private static OrdersProductDao instance;

	private OrdersProductDao() {

	}

	public static OrdersProductDao getInstance() {
		if (instance == null) {
			instance = new OrdersProductDao();
		}
		return instance;
	}
	
	@Override
	public int ordersProductInsert(OrdersProductVo ordersProduct) {
		// TODO Auto-generated method stub
		return insert("ordersProduct.ordersProductInsert", ordersProduct);
	}
}
