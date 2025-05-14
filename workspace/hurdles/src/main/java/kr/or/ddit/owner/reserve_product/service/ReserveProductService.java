package kr.or.ddit.owner.reserve_product.service;

public class ReserveProductService implements IReserveProductService {
	private static ReserveProductService instance;

	private ReserveProductService() {

	}

	public static ReserveProductService getInstance() {
		if (instance == null) {
			instance = new ReserveProductService();
		}

		return instance;
	}
}
