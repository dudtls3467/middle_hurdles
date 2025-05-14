package kr.or.ddit.admin.pay.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.PayVo;
import kr.or.ddit.vo.ReservationVo;

public class PayDao extends MybatisDao implements IPayDao {
	private static PayDao instance;

	private PayDao() {

	}

	public static PayDao getInstance() {
		if (instance == null) {
			instance = new PayDao();
		}

		return instance;
	}

	@Override
	public List<PayVo> list(Pagenation<PayVo> pagenation) {
		
		return selectList("pay.adminPayList", pagenation);
	}

	@Override
	public PayVo detail(PayVo payNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(PayVo payNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getAllCount(Pagenation<PayVo> pagenation) {
		return selectOne("pay.getAllCount", pagenation);
	}
}
