package kr.or.ddit.site.orders.dao;

import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.OrdersVo;

public class OrdersDao extends MybatisDao implements IOrdersDao {
	private static OrdersDao instance;

	private OrdersDao() {

	}

	public static OrdersDao getInstance() {
		if (instance == null) {
			instance = new OrdersDao();
		}

		return instance;
	}

	@Override
	public int ordersInsert(OrdersVo orders) {
		// TODO Auto-generated method stub
		return insert("orders.ordersInsert", orders);
	}

	@Override
	public int odersNoGet() {
		// TODO Auto-generated method stub
		return selectOne("orders.odersNoGet");
	}
}
