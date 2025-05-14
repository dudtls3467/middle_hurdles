package kr.or.ddit.admin.review.service;

import java.util.List;

import kr.or.ddit.admin.review.dao.ReviewReportDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.ReviewReportVo;

public class ReviewReportService implements IReviewService{
	/*Singleton*/
	private static ReviewReportService instance;

	private ReviewReportService() {

	}

	public static ReviewReportService getInstance() {

		if (instance == null) {

			instance = new ReviewReportService();  

		}

		return instance;

	}

	ReviewReportDao reviewReportDao = ReviewReportDao.getInstance();
	
	@Override
	public int getAllCount(Pagenation<ReviewReportVo> param) {
		return reviewReportDao.getAllCount(param);
	}

	@Override
	public List<ReviewReportVo> list(Pagenation<ReviewReportVo> pagenation) {
		
		return reviewReportDao.list(pagenation);
	}

	@Override
	public ReviewReportVo detail(int reviewNo) {
		return reviewReportDao.detail(reviewNo);
	}

	@Override
	public int insert(ReviewReportVo review) {
		return reviewReportDao.insert(review);
	}

	@Override
	public int update(ReviewReportVo review) {
		return reviewReportDao.update(review);
	}

	@Override
	public int delete(ReviewReportVo reviewNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
