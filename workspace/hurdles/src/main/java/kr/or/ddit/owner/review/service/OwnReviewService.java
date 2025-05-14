package kr.or.ddit.owner.review.service;

import java.util.List;

import kr.or.ddit.owner.review.dao.OwnReviewDao;
import kr.or.ddit.vo.ReviewReportVo;
import kr.or.ddit.vo.ReviewVo;

public class OwnReviewService {

	private static OwnReviewService instance;

	private OwnReviewService() {

	}

	public static OwnReviewService getInstance() {
		if (instance == null) {
			instance = new OwnReviewService();
		}
		return instance;
	}

	OwnReviewDao ownReviewDao = OwnReviewDao.getInstance();
	public List<ReviewVo> reviewList(ReviewVo reviewVo) {
		// TODO Auto-generated method stub
		return ownReviewDao.reviewList(reviewVo);
	}
	
	public int reviewReport(ReviewReportVo reviewVo) {
		return ownReviewDao.reviewReport(reviewVo);
	}
	
	public ReviewReportVo ownReviewOne(ReviewReportVo reviewVo) {
		return ownReviewDao.ownReviewOne(reviewVo);
	}
}
