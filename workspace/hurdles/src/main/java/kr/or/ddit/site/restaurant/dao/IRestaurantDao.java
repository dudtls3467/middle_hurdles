package kr.or.ddit.site.restaurant.dao;

import java.util.List;
	// 식당 상세정보
	
	// 
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.RestaurantVo;

public interface IRestaurantDao {
	public List<RestaurantVo> restaurantList(Pagenation<RestaurantVo> pagenation);
	
	public int getTotalPageCount(Pagenation<RestaurantVo> pagenation);
}
