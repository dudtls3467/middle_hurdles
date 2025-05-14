package kr.or.ddit.admin.review.service;

import kr.or.ddit.admin.review.dao.ReviewDeleteDao;
import kr.or.ddit.vo.ReviewReportVo;

public class ReviewDeleteService {
	private static ReviewDeleteService instance;

	private ReviewDeleteService() {

	}

	public static ReviewDeleteService getInstance() {
		if (instance == null) {
			instance = new ReviewDeleteService();
		}
		return instance;
	}
	ReviewDeleteDao reviewDeleteDao = ReviewDeleteDao.getInstance();
	
	public int reviewDelete(ReviewReportVo reviewReportVo) {
		return reviewDeleteDao.reviewDelete(reviewReportVo);
	}
}
