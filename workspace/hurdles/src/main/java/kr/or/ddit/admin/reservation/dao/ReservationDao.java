package kr.or.ddit.admin.reservation.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.mybatis.MybatisDao;

import kr.or.ddit.vo.ReservationVo;

public class ReservationDao extends MybatisDao implements IReservationDao {
	private static ReservationDao instance;

	private ReservationDao() {

	}

	public static ReservationDao getInstance() {
		if (instance == null) {
			instance = new ReservationDao();
		}

		return instance;
	}

	@Override
	public List<ReservationVo> list(Pagenation<ReservationVo> pagenation) {
		
		return selectList("reservation.adminReservationList",pagenation);
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
		return selectOne("reservation.selectListTotalCount", pagenation);
	}
	
	
	public int getAllCount(Pagenation<ReservationVo> pagenation) {
		return selectOne("reservation.getAllCount", pagenation);
	}
	@Override
	public List<ReservationVo> list() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
