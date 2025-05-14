package kr.or.ddit.owner.reservation.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.ReservationVo;

public interface IReservationDao {

	//전체리스트
	public List<ReservationVo> list(Pagenation<ReservationVo> pagenation);
	
	//디테일
	public ReservationVo detail(ReservationVo resNo);
	
	//수정
	public int update(ReservationVo resNo);
	
	public List<ReservationVo> list(ReservationVo reservationVo);
}

