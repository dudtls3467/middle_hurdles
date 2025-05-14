package kr.or.ddit.admin.member.service;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.BoardVo;
import kr.or.ddit.vo.MemberVo;

public interface IMemberService {
	
//조회
public List<MemberVo> list (Pagenation<MemberVo> pagenation);
		
//상세조회
public MemberVo detail (MemberVo memberNo);


}
