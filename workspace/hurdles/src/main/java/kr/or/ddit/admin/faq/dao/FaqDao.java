package kr.or.ddit.admin.faq.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.BoardVo;

public class FaqDao extends MybatisDao implements IFaqDao{
	
	/*Singleton*/
	private static FaqDao instance;

	private FaqDao() {

	}

	public static FaqDao getInstance() {

		if (instance == null) {

			instance = new FaqDao();

		}

		return instance;

	}

	
	@Override
	public int getAllCount(Pagenation<BoardVo> param) {
		return selectOne("faq.getAllCount",param);
		
	}

	@Override
	public List<BoardVo> list(Pagenation<BoardVo> param) {
		return selectList("faq.list", param);
	}

	@Override
	public BoardVo detail(int boardNo) {
		return selectOne("faq.detail",boardNo);
	}

	@Override
	public int insert(BoardVo board) {
		
		System.out.println(board);
		
		return insert("faq.insert",board);
	}

	@Override
	public int update(BoardVo board) {
		return update("faq.update", board);
	}
	
	@Override
	public int delete(BoardVo boardNo) {
		return delete("faq.delete", boardNo);
	}

	public int getBoardNo() {
		return selectOne("board.getBoardNo");
	}

	

}
