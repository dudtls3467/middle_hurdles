package kr.or.ddit.admin.review.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.ReviewReportVo;

public class BlackReviewDao extends MybatisDao implements IReviewDao {
	private static BlackReviewDao instance;

	private BlackReviewDao() {

	}

	public static BlackReviewDao getInstance() {
		if (instance == null) {
			instance = new BlackReviewDao();
		}

		return instance;
	}

	@Override
	public int getAllCount(Pagenation<ReviewReportVo> param) {
//		return selectOne("black");
		return 0;
	}

	@Override
	public List<ReviewReportVo> list(Pagenation<ReviewReportVo> pagenation) {
		return selectList("review.blackReviewList",pagenation);
	}

	@Override
	public ReviewReportVo detail(int reviewNo) {
		return selectOne("review.blackReviewDetail",reviewNo);
	}

	@Override
	public int insert(ReviewReportVo review) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ReviewReportVo review) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ReviewReportVo reviewNo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
