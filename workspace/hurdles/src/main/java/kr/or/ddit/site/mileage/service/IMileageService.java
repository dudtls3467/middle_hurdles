package kr.or.ddit.site.mileage.service;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.MileageVo;

public interface IMileageService {
	
	//게시물 개수 조회
	  public int getAllCount(Pagenation<MileageVo> param);
	//  게시물 목록 조회
	  public List<MileageVo> list(Pagenation<MileageVo> pagenation);
	//  게시물 상세보기
	  public MileageVo detail(int mileageNo);
	//  게시물 등록
	  public int insert(MileageVo mileage);
	//  게시물 수정
	  public int update(MileageVo mileage);
	//  게시물 삭제
	  public int delete(MileageVo mileageNo);
	  
	  //마일리지 음수 양수 부여 
	  public List<MileageVo> getMileage(MileageVo mileage );
}
