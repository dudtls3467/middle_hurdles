package kr.or.ddit.main.owner.service;

import kr.or.ddit.main.owner.dao.OwnerMainDao;
import kr.or.ddit.vo.MainVo;

public class OwnerMainService {
	
	private static OwnerMainService instance;

	private OwnerMainService() {

	}

	public static OwnerMainService getInstance() {
		if (instance == null) {
			instance = new OwnerMainService();
		}
		return instance;
	}
	OwnerMainDao ownerMainDao = OwnerMainDao.getInstance();
	
	public int ownGetTotalPrice(MainVo mainVo) {
		return ownerMainDao.ownGetTotalPrice( mainVo);
	}
	
	public int ownGetCountReservation(MainVo mainVo) {
		return ownerMainDao.ownGetCountReservation(mainVo);
	}
	
	public int ownGetCountOrder(MainVo mainVo) {
		return ownerMainDao.ownGetCountOrder(mainVo);
	}
	
	
	public int ownReviewCount(MainVo mainVo) {
		return ownerMainDao.ownReviewCount(mainVo);
	}
	
	public int ownReviewScore(MainVo mainVo) {
		return ownerMainDao.ownReviewScore(mainVo);
	}
	public int ownRestaurant(MainVo mainVo) {
		return ownerMainDao.ownRestaurant(mainVo);
	}
}
