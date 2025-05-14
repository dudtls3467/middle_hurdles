package kr.or.ddit.owner.reserve_product.dao;

public class ReserveProductDao implements IReserveProductDao {
	private static ReserveProductDao instance;

	private ReserveProductDao() {

	}

	public static ReserveProductDao getInstance() {
		if (instance == null) {
			instance = new ReserveProductDao();
		}

		return instance;
	}
}
