package kr.or.ddit.owner.review.dao;

import java.util.List;

import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.ReviewReportVo;
import kr.or.ddit.vo.ReviewVo;

public class OwnReviewDao extends MybatisDao {
	private static OwnReviewDao instance;

	private OwnReviewDao() {

	}

	public static OwnReviewDao getInstance() {
		if (instance == null) {
			instance = new OwnReviewDao();
		}
		return instance;
	}

	public List<ReviewVo> reviewList(ReviewVo reviewVo) {
		// TODO Auto-generated method stub
		return selectList("ownReview.ownReviewList", reviewVo);
	}

	public int reviewReport(ReviewReportVo reviewVo) {
		// TODO Auto-generated method stub
		return insert("ownReview.reviewReport",reviewVo);
	}

	public ReviewReportVo ownReviewOne(ReviewReportVo reviewVo) {
		// TODO Auto-generated method stub
		return selectOne("ownReview.ownReviewOne",reviewVo);
	}
}
