package kr.or.ddit.admin.reservation.service;

import java.util.List;

import kr.or.ddit.admin.reservation.dao.ReservationDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.ReservationVo;

public class ReservationService implements IReservationService {
	private static ReservationService instance;

	private ReservationService() {

	}

	public static ReservationService getInstance() {
		if (instance == null) {
			instance = new ReservationService();
		}

		return instance;
	}
	ReservationDao reservationDao = ReservationDao.getInstance();

	@Override
	public List<ReservationVo> list(Pagenation<ReservationVo> pagenation) {
		
		return reservationDao.list(pagenation);
	}

	@Override
	public ReservationVo detail(ReservationVo resNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ReservationVo resNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getTotalPageCount(Pagenation<ReservationVo> pagenation) {
		return reservationDao.getTotalPageCount(pagenation);
	}
	
	public int getAllcount(Pagenation<ReservationVo> pagenation){
		return reservationDao.getAllCount(pagenation);
	}

	

	
}
