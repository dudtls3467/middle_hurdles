package kr.or.ddit.admin.board.service;

import java.util.List;

import kr.or.ddit.admin.board.dao.NoticeDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.BoardVo;

public class NoticeService implements implBoardService {
	
	private NoticeDao noticeDao = NoticeDao.getInstance();

	private static NoticeService instance;

	private NoticeService() {

	}

	public static NoticeService getInstance() {

		if (instance == null) {

			instance = new NoticeService();

		}

		return instance;

	}

	
	@Override
	public int getAllCount(Pagenation<BoardVo> param) {
		return noticeDao.getAllCount(param);
	}
	
	@Override
	public List<BoardVo> list(Pagenation<BoardVo> pagenation) {
		return noticeDao.list(pagenation);
	}

	@Override
	public BoardVo detail(int boardNo) {
		return noticeDao.detail(boardNo);
	}

	@Override
	public int insert(BoardVo board) {
		return noticeDao.insert(board);
	}

	@Override
	public int update(BoardVo board) {
		return noticeDao.update(board);
	}

	@Override
	public int delete(BoardVo boardNo) {
		return noticeDao.delete(boardNo);
	}
	public int getBoardNo() {
		return noticeDao.getBoardNo();
	}
	
}
