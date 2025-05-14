package kr.or.ddit.admin.menu.service;

import java.util.List;

import kr.or.ddit.admin.menu.dao.MenuDao;
import kr.or.ddit.vo.MenuVo;

public class MenuService implements IMenuService {
	/*Singleton*/
	private static MenuService instance;
	private MenuDao menuDao = MenuDao.getInstance();

	private MenuService() {
	}

	public static MenuService getInstance() {
		if (instance == null) {
			instance = new MenuService();
		}

		return instance;
	}

	@Override
	public List<MenuVo> list(int no) {
		return menuDao.list(no);
	}

	@Override
	public int insert(MenuVo param) {
		int menuNo = getMenuNo();
		param.setMenuNo(menuNo);
		
		// 파일 추가
		
		return menuDao.insert(param);
	}

	@Override
	public int update(MenuVo param) {
		return menuDao.update(param);
	}

	@Override
	public int getMenuNo() {
		return menuDao.getMenuNo();
	}

	@Override
	public int delete(MenuVo param) {
		return menuDao.delete(param);
	}

	
}
