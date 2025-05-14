package kr.or.ddit.admin.pay.service;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.PayVo;


public interface IPayService {
	
	//전체리스트
	public List<PayVo> list(Pagenation<PayVo> pagenation);
	
	//디테일
	public PayVo detail(PayVo payNo);
	
	//수정
	public int update(PayVo payNo);

}
