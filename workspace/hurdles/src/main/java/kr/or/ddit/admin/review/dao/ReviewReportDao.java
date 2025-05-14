package kr.or.ddit.admin.review.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.ReviewReportVo;

public class ReviewReportDao extends MybatisDao implements IReviewDao {
	private static ReviewReportDao instance;

	private ReviewReportDao() {

	}

	public static ReviewReportDao getInstance() {
		if (instance == null) {
			instance = new ReviewReportDao();
		}

		return instance;
	}

	@Override
	public int getAllCount(Pagenation<ReviewReportVo> param) {
//		return selectOne("black");
		return selectOne("reviewReport.getAllCount",param);
	}

	@Override
	public List<ReviewReportVo> list(Pagenation<ReviewReportVo> pagenation) {
		return selectList("reviewReport.reviewReportList",pagenation);
	}

	@Override
	public ReviewReportVo detail(int reviewNo) {
		return selectOne("reviewReport.reviewReportDetail",reviewNo);
	}

	@Override
	public int insert(ReviewReportVo review) {
		return 0;
	}

	@Override
	public int update(ReviewReportVo review) {
		return update("reviewReport.update", review);
	}

	@Override
	public int delete(ReviewReportVo reviewNo) {
		// TODO Auto-generated method stub
		return 0;
	}
}
