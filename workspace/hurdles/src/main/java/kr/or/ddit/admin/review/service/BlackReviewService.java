package kr.or.ddit.admin.review.service;

import java.util.List;

import kr.or.ddit.admin.review.dao.BlackReviewDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.ReviewReportVo;

public class BlackReviewService implements IReviewService {
	private static BlackReviewService instance;

	private BlackReviewService() {

	}

	public static BlackReviewService getInstance() {
		if (instance == null) {
			instance = new BlackReviewService();
		}

		return instance;
	}
	
	private BlackReviewDao blackReviewDao = BlackReviewDao.getInstance();
	
	@Override
	public int getAllCount(Pagenation<ReviewReportVo> param) {
		// TODO Auto-generated method stub
//		return BlackReviewDao.getAllCount(param);
		return blackReviewDao.getAllCount(param);
	}

	@Override
	public List<ReviewReportVo> list(Pagenation<ReviewReportVo> pagenation) {
		return blackReviewDao.list(pagenation);
	}

	@Override
	public ReviewReportVo detail(int reviewNo) {
		return blackReviewDao.detail(reviewNo);
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
