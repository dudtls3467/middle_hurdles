package kr.or.ddit.owner.question.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.FileVo;
import kr.or.ddit.vo.MemberVo;
import kr.or.ddit.vo.QuestionVo;

public class QuestionDao extends MybatisDao implements IQuestionDao {
	private static QuestionDao instance;

	private QuestionDao() {

	}

	public static QuestionDao getInstance() {
		if (instance == null) {
			instance = new QuestionDao();
		}

		return instance;
	}

	@Override
	public int getAllCount(Pagenation<QuestionVo> param) {
		return selectOne("question.getAllcount",param);
	}

	@Override
	public List<QuestionVo> list(Pagenation<QuestionVo> pagenation) {
		return selectList("question.ownList", pagenation);
	}

	@Override
	public QuestionVo detail(int questionNo) {

		// TODO Auto-generated method stub
		return selectOne("question.ownDetail", questionNo);



	}

	@Override
	public int insert(QuestionVo question) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(QuestionVo question) {
		// TODO Auto-generated method stub
		return update("question.update", question);
	}

	@Override
	public int delete(QuestionVo questionNo) {
		// TODO Auto-generated method stub
		return 0;
	}


}
