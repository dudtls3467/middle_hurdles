package kr.or.ddit.admin.board.service;

import java.util.List;

import kr.or.ddit.admin.board.dao.BoardDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.BoardVo;


public class BoardService implements implBoardService {
	private BoardDao boardDao = BoardDao.getInstance();
	private static BoardService instance;

	private BoardService() {

	}

	public static BoardService getInstance() {
		if (instance == null) {
			instance = new BoardService();
		}

		return instance;
	}

	public int getTotalPageCount(Pagenation<BoardVo> pagenation) {
		return boardDao.getTotalPageCount(pagenation);
	}

	@Override
	public List<BoardVo> list(Pagenation<BoardVo> pagenation) {
		return boardDao.list(pagenation);
	}

	@Override
	public BoardVo detail(int boardNo) {
		return boardDao.detail(boardNo);
	}

	@Override
	public int insert(BoardVo board) {
		return boardDao.insert(board);
	}

	@Override
	public int update(BoardVo board) {
		return boardDao.update(board);
	}


	public int getBoardNo() {
		return boardDao.getBoardNo();
	}

	@Override
	public int getAllCount(Pagenation<BoardVo> param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardVo boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
