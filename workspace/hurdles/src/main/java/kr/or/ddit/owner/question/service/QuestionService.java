package kr.or.ddit.owner.question.service;

import java.util.List;

import kr.or.ddit.owner.question.dao.QuestionDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.MemberVo;
import kr.or.ddit.vo.QuestionVo;

public class QuestionService implements IQuestionService {
	private static QuestionService instance;

	private QuestionService() {

	}

	public static QuestionService getInstance() {
		if (instance == null) {
			instance = new QuestionService();
		}

		return instance;
	}

	QuestionDao questionDao = QuestionDao.getInstance();

	@Override
	public int getAllCount(Pagenation<QuestionVo> param) {
		return questionDao.getAllCount(param);
	}

	@Override
	public List<QuestionVo> list(Pagenation<QuestionVo> pagenation) {
		return questionDao.list(pagenation);
	}

	@Override
	public QuestionVo detail(int questionNo) {

		// TODO Auto-generated method stub
		return questionDao.detail(questionNo);


	}

	@Override
	public int insert(QuestionVo question) {
		return 0;
	}

	@Override
	public int update(QuestionVo question) {
		return questionDao.update(question);
	}

	@Override
	public int delete(QuestionVo questionNo) {
		return 0;
	}

}
