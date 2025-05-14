package kr.or.ddit.admin.waybill.service;

public class WaybillService implements IWaybillService {
	private static WaybillService instance;

	private WaybillService() {

	}

	public static WaybillService getInstance() {
		if (instance == null) {
			instance = new WaybillService();
		}

		return instance;
	}
}
