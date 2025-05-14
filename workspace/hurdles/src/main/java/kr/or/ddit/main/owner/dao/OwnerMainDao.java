package kr.or.ddit.main.owner.dao;

import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.MainVo;

public class OwnerMainDao extends MybatisDao {
	
	private static OwnerMainDao instance;

	private OwnerMainDao() {

	}

	public static OwnerMainDao getInstance() {
		if (instance == null) {
			instance = new OwnerMainDao();
		}
		return instance;
	}
	
	public int ownGetTotalPrice(MainVo mainVo) {
		return selectOne("owner.ownGetTotalPrice", mainVo);
	}
	
	public int ownGetCountReservation(MainVo mainVo) {
		return selectOne("owner.ownGetCountReservation", mainVo);
	}
	
	public int ownGetCountOrder(MainVo mainVo) {
		return selectOne("owner.ownGetCountOrder", mainVo);
	}
	
	
	public int ownReviewCount(MainVo mainVo) {
		return selectOne("owner.ownReviewCount", mainVo);
	}
	
	public int ownReviewScore(MainVo mainVo) {
		return selectOne("owner.ownReviewScore", mainVo);
	}
	
	public int ownRestaurant(MainVo mainVo) {
		return selectOne("owner.ownRestaurant",mainVo);
	}
}
