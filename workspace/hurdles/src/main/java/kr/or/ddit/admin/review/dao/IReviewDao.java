package kr.or.ddit.admin.review.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.ReviewReportVo;

public interface IReviewDao {
 
	// 전체 개수 - 백 
	  public int getAllCount(Pagenation<ReviewReportVo> param);
	//  게시물 목록 조회
	  public List<ReviewReportVo> list(Pagenation<ReviewReportVo> pagenation);
	//  게시물 상세보기
	  public ReviewReportVo detail(int reviewNo);
	//  게시물 등록
	  public int insert(ReviewReportVo review);
	//  게시물 수정
	  public int update(ReviewReportVo review);
	//  게시물 삭제
	  public int delete(ReviewReportVo reviewNo);
}
