package kr.or.ddit.main.admin.service;

import java.util.List;

import kr.or.ddit.main.admin.dao.AdminMainDao;
import kr.or.ddit.vo.MainVo;

public class AdminMainService {
	private static AdminMainService instance;
	
	
			
	private AdminMainService() {

	}

	public static AdminMainService getInstance() {
		if (instance == null) {
			instance = new AdminMainService();
		}
		return instance;
	}
	AdminMainDao adminMainDao = AdminMainDao.getInstance();
	
	public int payTotalPrice(MainVo mainVo) {
		return adminMainDao.payTotalPrice(mainVo);
	}
	
	public int reservationCnt(MainVo mainVo) {
		return adminMainDao.reservationCnt(mainVo);
	}
	
	public int memberCnt(MainVo mainVo) {
		return adminMainDao.memberCnt(mainVo);
	}
	
	public int reviewCnt(MainVo mainVo) {
		return adminMainDao.reviewCnt(mainVo);
	}
	
	public List<MainVo> localRestaurantCnt(MainVo mainVo){
		return adminMainDao.localRestaurantCnt(mainVo);
	}
	
	public int ordersCnt(MainVo mainVo) {
		return adminMainDao.ordersCnt(mainVo);
	}

	public List<MainVo> eachPrice(MainVo mainVo) {
		// TODO Auto-generated method stub
		return adminMainDao.eachPrice(mainVo);
	}
}
