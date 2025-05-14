package kr.or.ddit.admin.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.util.mybatis.MybatisUtil;
import kr.or.ddit.vo.CouponVo;
import kr.or.ddit.vo.FileVo;
import kr.or.ddit.vo.GradeVo;
import kr.or.ddit.vo.MemberVo;
import kr.or.ddit.vo.MileageVo;

public class MemberDao extends MybatisDao implements IMemberDao {
	private static MemberDao instance;

	private MemberDao() {

	}

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}

		
		return instance;
	}

	//회원 전체 조회
	@Override
	public List<MemberVo> list(Pagenation<MemberVo> pagenation) {
		
		return selectList("member.list");
	}

	@Override
	public MemberVo detail(MemberVo memberNo) {
		
		return selectOne("member.detail", memberNo);
	}
	
	public int getAllCount (Pagenation<MemberVo> pagenation) {
		return selectOne("member.getAllCount",pagenation );
	}
	
	//마일리지 조회
	public MemberVo mileageSelect (MemberVo point) {
		return selectOne("member.mileageSelect",point);
	}
	
	public List<FileVo> getFileList(MemberVo File){
		
		return selectList("member.getFileList", File);
		
	}
	//마일리지 상세내역 조회
	
	public List<MileageVo> MileageList (MileageVo memberNo) {
	
		return selectList("member.MileageList",memberNo);
	}
	//마일리지 수정
	
	public int MileageInsert (MileageVo memberNo) {
		return insert("member.mileageInsert",memberNo);
	}
	
	//등급수정
	public int memberGradeUpdate(GradeVo memberNo) {
//		SqlSession session = null;
//		try {
//			 session = MybatisUtil.getInstance(true);
//			session.update("member.memberGradeUpdate2",memberNo);
//		} catch (Exception e) {
//			// 로그를 남기거나, 더 구체적인 예외를 던질 수 있습니다.
//			throw new RuntimeException("SQL 실행 중 오류 발생: " + e);
//		} 
//		session.close();
//		
		
		return update("member.memberGradeUpdate2",memberNo);
	}
	
	public List<CouponVo>memberCoupon(CouponVo memberNo){
		return selectList("member.adminMemberCoupon", memberNo);
	}
	
}
