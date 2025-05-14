package kr.or.ddit.admin.member.service;

import java.util.List;

import kr.or.ddit.admin.board.dao.NoticeDao;
import kr.or.ddit.admin.member.dao.BlackDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.BoardVo;
import kr.or.ddit.vo.MemberVo;

public class BlackService implements IMemberService{
	
	private BlackDao blackDao = BlackDao.getInstance();
	
	private static BlackService instance;

	private BlackService() {

	}

	public static BlackService getInstance() {

		if (instance == null) {

			instance = new BlackService();

		}

		return instance;

	}

	@Override
	public List<MemberVo> list(Pagenation<MemberVo> pagenation) {
		return blackDao.list(pagenation);
	}

	@Override
	public MemberVo detail(MemberVo memberNo) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
