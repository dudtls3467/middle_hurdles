package kr.or.ddit.admin.faq.service;

import java.util.List;

import kr.or.ddit.admin.faq.dao.FaqDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.BoardVo;

public class FaqService implements IFaqService{
	
	/*Singleton*/
	private static FaqService instance;

	private FaqService() {

	}

	public static FaqService getInstance() {

		if (instance == null) {

			instance = new FaqService();

		}

		return instance;

	}
	
	FaqDao faqDao = FaqDao.getInstance();
	
	@Override
	public int getAllCount(Pagenation<BoardVo> param) {
		return faqDao.getAllCount(param);
	}

	@Override
	public List<BoardVo> list(Pagenation<BoardVo> param) {
		return faqDao.list(param);
	}
	
	@Override
	public BoardVo detail(int boardNo) {
		return faqDao.detail(boardNo);
	}

	@Override
	public int insert(BoardVo board) {
		return faqDao.insert(board);
	}

	@Override
	public int update(BoardVo board) {
		return faqDao.update(board);
	}

	@Override
	public int delete(BoardVo boardNo) {
		return faqDao.delete(boardNo);
	}
	
	public int getBoardNo() {
		return faqDao.getBoardNo();
	}


}
