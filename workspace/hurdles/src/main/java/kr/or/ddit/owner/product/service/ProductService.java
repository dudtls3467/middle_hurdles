package kr.or.ddit.owner.product.service;

public class ProductService implements IProductService {
	private static ProductService instance;

private ProductService() {

}

	public static ProductService getInstance() {
		if (instance == null) {
			instance = new ProductService();
		}

		return instance;
	}
}
