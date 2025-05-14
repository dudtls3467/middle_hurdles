package kr.or.ddit.admin.waybill.dao;

public class WaybillDao implements IWaybillDao {
	private static WaybillDao instance;

	private WaybillDao() {

	}

	public static WaybillDao getInstance() {
		if (instance == null) {
			instance = new WaybillDao();
		}

		return instance;
	}
}
