package kr.or.ddit.admin.menu.dao;

import java.util.List;

import kr.or.ddit.vo.MenuVo;

public interface IMenuDao {
	// 식당 no 가져오기
		public int getMenuNo();
		
	// 식당 메뉴 목록 가져오기 
	public List<MenuVo> list(int no);
	
	// 메뉴 추가
	public int insert(MenuVo param);
	
	// 메뉴 수정
	public int update(MenuVo param);
	
	// 메뉴 삭제
	public int delete(MenuVo param);
}
