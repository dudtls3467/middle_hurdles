package kr.or.ddit.admin.board.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.BoardVo;


public class BoardDao extends MybatisDao implements ImplBoardDao {
	private static BoardDao instance;

	private BoardDao() {

	}

	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}

		return instance;
	}
	
	public int getTotalPageCount(Pagenation<BoardVo> pagenation) {
		return selectOne("board.selectListTotalCount", pagenation);
	}

	@Override
	public List<BoardVo> list(Pagenation<BoardVo> pagenation) {
		return selectList("board.list", pagenation);
	}

	@Override
	public BoardVo detail(int boardNo) {
		return selectOne("board.detail", boardNo);
	}

	@Override
	public int insert(BoardVo board) {
		return update("board.insert", board);
	}

	@Override
	public int update(BoardVo board) {
		return update("board.update", board);
	}


	public int getBoardNo() {
		return selectOne("board.getBoardNo");
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
