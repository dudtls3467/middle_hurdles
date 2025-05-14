package kr.or.ddit.owner.question.service;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.MemberVo;
import kr.or.ddit.vo.QuestionVo;

public interface IQuestionService {

		// 전체 개수 - 백 
		  public int getAllCount(Pagenation<QuestionVo> param);
		//  게시물 목록 조회
		  public List<QuestionVo> list(Pagenation<QuestionVo> pagenation);
		//  게시물 상세보기
		  public QuestionVo detail(int questionNo);
		//  게시물 등록
		  public int insert(QuestionVo question);
		//  게시물 수정
		  public int update(QuestionVo question);
		//  게시물 삭제
		  public int delete(QuestionVo questionNo);
	
}
