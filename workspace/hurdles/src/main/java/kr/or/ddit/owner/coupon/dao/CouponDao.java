package kr.or.ddit.owner.coupon.dao;

import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.CouponVo;

public class CouponDao extends MybatisDao implements ICounponDao {
	private static CouponDao instance;

	private CouponDao() {

	}

	public static CouponDao getInstance() {
		if (instance == null) {
			instance = new CouponDao();
		}

		return instance;
	}

	@Override
	public int insert(CouponVo coupon) {
		return update("coupon.insert",coupon);
	}
}
