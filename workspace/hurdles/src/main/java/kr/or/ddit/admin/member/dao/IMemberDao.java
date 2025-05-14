package kr.or.ddit.admin.member.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.BoardVo;
import kr.or.ddit.vo.MemberVo;

public interface IMemberDao {

//조회
public List<MemberVo> list (Pagenation<MemberVo> pagenation);
	
//상세조회
public MemberVo detail (MemberVo memberNo);

//수정

	
}
