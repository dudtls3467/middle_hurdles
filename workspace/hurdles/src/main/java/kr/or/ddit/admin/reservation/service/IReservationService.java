package kr.or.ddit.admin.reservation.service;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.ReservationVo;

public interface IReservationService {
	
	//전체리스트
	public List<ReservationVo> list(Pagenation<ReservationVo> pagenation);
	
	//디테일
	public ReservationVo detail(ReservationVo resNo);
	
	//수정
	public int update(ReservationVo resNo);

}
