package kr.or.ddit.site.restaurant.service;

import java.util.List;

import kr.or.ddit.site.restaurant.dao.RestaurantDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.RestaurantVo;
import kr.or.ddit.vo.ReviewVo;

public class RestaurantService implements IRestaurantService {
	private static RestaurantService instance;

	private RestaurantService() {

	}

	public static RestaurantService getInstance() {
		if (instance == null) {
			instance = new RestaurantService();
		}

		return instance;
	}

	RestaurantDao restaurantDao = RestaurantDao.getInstance();

	@Override
	public List<RestaurantVo> restaurantList(Pagenation<RestaurantVo> pagenation) {
		return restaurantDao.restaurantList(pagenation);
	}

	public int getTotalPageCount(Pagenation<RestaurantVo> pagenation) {
		return restaurantDao.getTotalPageCount(pagenation);
	}
}
