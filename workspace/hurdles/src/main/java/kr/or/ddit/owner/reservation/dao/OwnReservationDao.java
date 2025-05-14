package kr.or.ddit.owner.reservation.dao;

import java.util.List;

import kr.or.ddit.owner.reservation.dao.IReservationDao;
import kr.or.ddit.owner.reservation.dao.OwnReservationDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.ReservationVo;

public class OwnReservationDao extends MybatisDao implements IReservationDao {
	private static OwnReservationDao instance;

	private OwnReservationDao() {

	}

	public static OwnReservationDao getInstance() {
		if (instance == null) {
			instance = new OwnReservationDao();
		}

		return instance;
	}


	@Override
	public ReservationVo detail(ReservationVo resNo) {
		// TODO Auto-generated method stub
		return selectOne("reservation.reservationDetail", resNo);
	}

	@Override
	public int update(ReservationVo resNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReservationVo> list(Pagenation<ReservationVo> pagenation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReservationVo> list(ReservationVo reservationVo) {
		// TODO Auto-generated method stub
		return selectList("reservation.ownList", reservationVo);
	}

	public int delete(ReservationVo reservationVo) {
		// TODO Auto-generated method stub
		return delete("reservation.ownDelete",reservationVo);
	}
}