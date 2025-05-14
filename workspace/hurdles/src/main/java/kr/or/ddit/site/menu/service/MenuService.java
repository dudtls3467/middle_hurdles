package kr.or.ddit.site.menu.service;

import java.util.List;

import kr.or.ddit.site.menu.dao.MenuDao;
import kr.or.ddit.vo.MenuVo;
import kr.or.ddit.vo.ProductVo;
import kr.or.ddit.vo.ReserveProductVo;

public class MenuService implements IMenuService {
	/* Singleton */
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
	public List<MenuVo> menuList(MenuVo param) {
		return menuDao.menuList(param);
	}

	@Override
	public List<ProductVo> productList(ProductVo param) {
		return menuDao.productList(param);
	}

	@Override
	public List<ReserveProductVo> reserveProductList(ReserveProductVo param) {
		return menuDao.reserveProductList(param);
	}

	@Override
	public MenuVo menuDetail(MenuVo param) {
		return menuDao.menuDetail(param);
	}

	@Override
	public ProductVo productDetail(ProductVo param) {
		return menuDao.productDetail(param);
	}

	@Override
	public ReserveProductVo reserveProductDetail(ReserveProductVo param) {
		return menuDao.reserveProductDetail(param);
	}

	@Override
	public int getMenuNo() {
		return menuDao.getMenuNo();
	}

	@Override
	public int menuInsert(MenuVo param) {
		return menuDao.menuInsert(param);
	}

	@Override
	public int menuUpdate(MenuVo param) {
		return menuDao.menuUpdate(param);
	}

	@Override
	public int menuDelete(MenuVo param) {
		return menuDao.menuDelete(param);
	}

	@Override
	public int getProductNo() {
		return menuDao.getProductNo();
	}

	@Override
	public int productInsert(ProductVo param) {
		return menuDao.productInsert(param);
	}

	@Override
	public int productUpdate(ProductVo param) {
		return menuDao.productUpdate(param);
	}

	@Override
	public int productDelete(ProductVo param) {
		return menuDao.productDelete(param);
	}

	@Override
	public int getReserveProductNo() {
		return menuDao.getReserveProductNo();
	}

	@Override
	public int reserveProductInsert(ReserveProductVo param) {
		return menuDao.reserveProductInsert(param);
	}

	@Override
	public int reserveProductUpdate(ReserveProductVo param) {
		return menuDao.reserveProductUpdate(param);
	}

	@Override
	public int reserveProductDelete(ReserveProductVo param) {
		return menuDao.reserveProductDelete(param);
	}
}
