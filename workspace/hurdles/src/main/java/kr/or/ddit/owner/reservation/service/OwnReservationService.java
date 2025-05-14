package kr.or.ddit.owner.reservation.service;

import java.util.List;

import kr.or.ddit.owner.reservation.dao.IReservationDao;
import kr.or.ddit.owner.reservation.dao.OwnReservationDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.ReservationVo;

public class OwnReservationService extends MybatisDao implements IReservationDao {
	private static OwnReservationService instance;

	private OwnReservationService() {

	}

	public static OwnReservationService getInstance() {
		if (instance == null) {
			instance = new OwnReservationService();
		}

		return instance;
	}


	OwnReservationDao ownReservationDao = OwnReservationDao.getInstance();


	public int delete(ReservationVo reservationVo) {

		return ownReservationDao.delete(reservationVo);
		
	}


	@Override
	public ReservationVo detail(ReservationVo resNo) {
		// TODO Auto-generated method stub
		return ownReservationDao.detail(resNo);
	}

	@Override
	public int update(ReservationVo resNo) {
		// TODO Auto-generated method stub
		return ownReservationDao.update(resNo);
	}

	@Override
	public List<ReservationVo> list(Pagenation<ReservationVo> pagenation) {
		// TODO Auto-generated method stub
		return ownReservationDao.list(pagenation);
	}

	@Override
	public List<ReservationVo> list(ReservationVo reservationVo) {
		// TODO Auto-generated method stub
		return ownReservationDao.list(reservationVo);
	}
}