package kr.or.ddit.site.restaurant.service;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.RestaurantVo;

public interface IRestaurantService {
	public List<RestaurantVo> restaurantList(Pagenation<RestaurantVo> pagenation);
	
	public int getTotalPageCount(Pagenation<RestaurantVo> pagenation);
}
