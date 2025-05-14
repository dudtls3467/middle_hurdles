package kr.or.ddit.site.mileage.service;

import java.util.List;

import kr.or.ddit.site.mileage.dao.MileageDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.MileageVo;

public class MileageService implements IMileageService {
	private static MileageService instance;

	private MileageService() {

	}

	public static MileageService getInstance() {
		if (instance == null) {
			instance = new MileageService();
		}

		return instance;
	}
	
	MileageDao mileageDao = MileageDao.getInstance();

	@Override
	public int getAllCount(Pagenation<MileageVo> param) {
		// TODO Auto-generated method stub
		return mileageDao.getAllCount(param);
	}

	@Override
	public List<MileageVo> list(Pagenation<MileageVo> pagenation) {
		return mileageDao.list(pagenation);
	}

	@Override
	public MileageVo detail(int mileageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MileageVo mileage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MileageVo mileage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MileageVo mileageNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MileageVo> getMileage(MileageVo mileage) {
		return mileageDao.getMileage(mileage);
	}
}
