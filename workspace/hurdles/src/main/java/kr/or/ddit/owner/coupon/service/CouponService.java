package kr.or.ddit.owner.coupon.service;

import kr.or.ddit.owner.coupon.dao.CouponDao;
import kr.or.ddit.vo.CouponVo;

public class CouponService implements ICouponService {
	/*Singleton*/
	private static CouponService instance;

	private CouponService() {

	}

	public static CouponService getInstance() {

		if (instance == null) {

			instance = new CouponService();

		}

		return instance;

	}

	CouponDao couponDao = CouponDao.getInstance();
	
	
	@Override
	public int insert(CouponVo coupon) {
		return couponDao.insert(coupon);
	}

}
