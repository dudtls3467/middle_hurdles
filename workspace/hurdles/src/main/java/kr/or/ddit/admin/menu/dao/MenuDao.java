package kr.or.ddit.admin.menu.dao;

import java.util.List;

import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.MenuVo;

public class MenuDao extends MybatisDao implements IMenuDao {
	/* Singleton */
	private static MenuDao instance;

	private MenuDao() {
	}

	public static MenuDao getInstance() {
		if (instance == null) {
			instance = new MenuDao();
		}
 
		return instance;
	}

	@Override
	public List<MenuVo> list(int no) {
		return selectList("menu.list", no);
	}

	@Override
	public int insert(MenuVo param) {
		return insert("menu.menuInsert", param);
	}

	@Override
	public int update(MenuVo param) {
		return update("menu.menuUpdate", param);
	}

	@Override
	public int getMenuNo() {
		return selectOne("menu.getMenuNo");
	}

	@Override
	public int delete(MenuVo param) {
		return delete("menu.menuDelete", param);
	}

}
