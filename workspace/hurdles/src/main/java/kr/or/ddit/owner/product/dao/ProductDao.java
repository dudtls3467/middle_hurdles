package kr.or.ddit.owner.product.dao;

public class ProductDao implements IProductDao {
	private static ProductDao instance;

	private ProductDao() {

	}

	public static ProductDao getInstance() {
		if (instance == null) {
			instance = new ProductDao();
		}

		return instance;
	}
}
