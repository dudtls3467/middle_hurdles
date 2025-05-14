package kr.or.ddit.admin.pay.service;

import java.util.List;

import kr.or.ddit.admin.pay.dao.PayDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.PayVo;
import kr.or.ddit.vo.ReservationVo;

public class PayService implements IPayService {
	private static PayService instance;

	private PayService() {

	}

	public static PayService getInstance() {
		if (instance == null) {
			instance = new PayService();
		}

		return instance;
	}
	PayDao payDao = PayDao.getInstance();

	@Override
	public List<PayVo> list(Pagenation<PayVo> pagenation) {
		
		return payDao.list(pagenation);
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
	
	public int getAllcount(Pagenation<PayVo> pagenation){
		return payDao.getAllCount(pagenation);
	}

}
