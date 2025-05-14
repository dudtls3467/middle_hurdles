package kr.or.ddit.admin.faq.service;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.BoardVo;

public interface IFaqService {

		// faq 전체 개수 - 백 
		public int getAllCount(Pagenation<BoardVo> param);
		//  게시물 목록 조회
		  public List<BoardVo> list(Pagenation<BoardVo> pagenation);
		//  게시물 상세보기
		  public BoardVo detail(int boardNo);
		//  게시물 등록
		  public int insert(BoardVo board);
		//  게시물 수정
		  public int update(BoardVo board);
		//  게시물 삭제
		  public int delete(BoardVo boardNo);
		
}
