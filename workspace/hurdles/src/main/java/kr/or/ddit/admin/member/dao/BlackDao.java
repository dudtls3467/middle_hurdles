package kr.or.ddit.admin.member.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.BoardVo;
import kr.or.ddit.vo.MemberVo;

public class BlackDao extends MybatisDao implements IMemberDao{
	
	/*Singleton*/
	private static BlackDao instance;

	private BlackDao() {

	}

	public static BlackDao getInstance() {

		if (instance == null) {

			instance = new BlackDao();

		}

		return instance;

	}

	@Override
	public List<MemberVo> list(Pagenation<MemberVo> pagenation) {
		return selectList("black.list", pagenation);
	}

	@Override
	public MemberVo detail(MemberVo memberNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getAllCount(Pagenation<MemberVo> param) {
		return selectOne("black.getAllCount", param);
	}




	
	
	

}
