package kr.or.ddit.admin.member.service;


import kr.or.ddit.admin.member.dao.MemberDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.CouponVo;
import kr.or.ddit.vo.FileVo;
import kr.or.ddit.vo.GradeVo;
import kr.or.ddit.vo.MemberVo;
import kr.or.ddit.vo.MileageVo;

import java.util.List;

import kr.or.ddit.vo.MemberVo;

public class MemberService implements IMemberService {
	private static MemberService instance;

	private MemberService() {

	}

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}

		return instance;
	}

MemberDao memberDao = MemberDao.getInstance();


	@Override
	public List<MemberVo> list(Pagenation<MemberVo> pagenation) {
	
		return memberDao.list(pagenation);
	}

	@Override
	public MemberVo detail(MemberVo memberNo) {
	
		return memberDao.detail(memberNo);
	}
	
	public int getAllCount (Pagenation<MemberVo> pagenation) {
		return memberDao.getAllCount(pagenation);
	}
	//마일리지 조회
	public MemberVo mileageSelect (MemberVo point) {
		return memberDao.mileageSelect(point);
	}
	
	public List<FileVo> getFileList(MemberVo File){
		
		return memberDao.getFileList(File);
		
	}
	//마일리지 상세 내역 조회
	public List<MileageVo> MileageList (MileageVo memberNo) {
		
		return memberDao.MileageList(memberNo);
	
	}
	//마일리지 수정
	public int MileageInsert (MileageVo memberNo) {
		
		return memberDao.MileageInsert(memberNo);
	}
	//등급수정
	
	public int memberGradeUpdate(GradeVo memberNo) {
		return memberDao.memberGradeUpdate(memberNo);
	}
	
	public List<CouponVo>memberCoupon(CouponVo memberNo){
		return memberDao.memberCoupon(memberNo);
	}

}
