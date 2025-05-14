package kr.or.ddit.site.mileage.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.MileageVo;

public class MileageDao extends MybatisDao implements IMileageDao {
	
	private static MileageDao instance;

	private MileageDao() {

	}

	public static MileageDao getInstance() {
		if (instance == null) {
			instance = new MileageDao();
		}

		return instance;
	}

	@Override
	public int getAllCount(Pagenation<MileageVo> param) {
		return selectOne("mileage.getAllCount",param);
	}

	@Override
	public List<MileageVo> list(Pagenation<MileageVo> pagenation) {
		return selectList("mileage.list", pagenation);
	}

	@Override
	public MileageVo detail(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MileageVo board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MileageVo board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MileageVo boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MileageVo> getMileage(MileageVo mileage) {
		return selectList("mileage.getMileage", mileage);
	}
}
