package kr.or.ddit.site.restaurant.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.mybatis.MybatisDao;
import kr.or.ddit.vo.RestaurantVo;
import kr.or.ddit.vo.ReviewVo;

public class RestaurantDao extends MybatisDao implements IRestaurantDao {
	private static RestaurantDao instance;

	private RestaurantDao() {

	}

	public static RestaurantDao getInstance() {
		if (instance == null) {
			instance = new RestaurantDao();
		}

		return instance;
	}

	@Override
	public List<RestaurantVo> restaurantList(Pagenation<RestaurantVo> pagenation) {
		return selectList("restaurant.list", pagenation);
	}

	public int getTotalPageCount(Pagenation<RestaurantVo> pagenation) {
		return selectOne("restaurant.getAllCount", pagenation);
	}

}
