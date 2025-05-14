package kr.or.ddit.admin.review.dao;

import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.ReviewReportVo;


public class ReviewDeleteDao extends MybatisDao {
	private static ReviewDeleteDao instance;

	private ReviewDeleteDao() {

	}

	public static ReviewDeleteDao getInstance() {
		if (instance == null) {
			instance = new ReviewDeleteDao();
		}
		return instance;
	}

	public int reviewDelete(ReviewReportVo reviewReportVo) {
		// TODO Auto-generated method stub
		return delete("reviewReport.reviewDelete", reviewReportVo);
	}
}
