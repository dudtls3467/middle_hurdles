package kr.or.ddit.main.admin.dao;

import java.util.List;

import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.MainVo;

public class AdminMainDao extends MybatisDao {
	private static AdminMainDao instance;

	private AdminMainDao() {

	}

	public static AdminMainDao getInstance() {
		if (instance == null) {
			instance = new AdminMainDao();
		}
		return instance;
	}
	
	public int payTotalPrice(MainVo mainVo) {
		return selectOne("main.payTotalPrice", mainVo);
	}
	
	public int reservationCnt(MainVo mainVo) {
		return selectOne("main.reservationCnt", mainVo);
	}
	
	public int memberCnt(MainVo mainVo) {
		return selectOne("main.memberCnt",mainVo);
	}
	
	public int reviewCnt(MainVo mainVo) {
		return selectOne("main.reviewCnt", mainVo);
	}
	
	public List<MainVo> localRestaurantCnt(MainVo mainVo){
		return selectList("main.localRestaurantCnt",mainVo);
	}

	public int ordersCnt(MainVo mainVo) {
		// TODO Auto-generated method stub
		return selectOne("main.orderCnt",mainVo);
	}

	public List<MainVo> eachPrice(MainVo mainVo) {
		// TODO Auto-generated method stub
		return selectList("main.eachPrice",mainVo);
	}
	
}
