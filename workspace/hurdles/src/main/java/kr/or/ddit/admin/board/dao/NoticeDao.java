package kr.or.ddit.admin.board.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.BoardVo;

public class NoticeDao extends MybatisDao implements ImplBoardDao{
	private static NoticeDao instance;

	private NoticeDao() {

	}

	public static NoticeDao getInstance() {

		if (instance == null) {

			instance = new NoticeDao();

		}

		return instance;

	}

	@Override
	public int getAllCount(Pagenation<BoardVo> param) {
		return selectOne("faq.getAllCount", param);
	}
	
	@Override
	public List<BoardVo> list(Pagenation<BoardVo> pagenation) {
		return selectList("notice.list", pagenation);
	}

	@Override
	public BoardVo detail(int boardNo) {
		return selectOne("notice.detail",boardNo);
	}

	@Override
	public int insert(BoardVo board) {
		return insert("notice.insert",board);
	}

	@Override
	public int update(BoardVo board) {
		return update("notice.update", board);
	}
	
	@Override
	public int delete(BoardVo boardNo) {
		return delete("faq.delete",boardNo);
	}
	
	public int getBoardNo() {
		return selectOne("board.getBoardNo");
	}
	
}
