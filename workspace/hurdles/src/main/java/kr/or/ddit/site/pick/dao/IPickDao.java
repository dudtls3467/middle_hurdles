package kr.or.ddit.site.pick.dao;

import java.util.List;

import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.RestaurantVo;

public interface IPickDao {
	
	public List<RestaurantVo> pickRestaurantList(Pagenation<RestaurantVo> restaurantVo);
	
	public int getTotalPageCount(Pagenation<RestaurantVo> pagenation);
	
	public int insertPick(RestaurantVo restaurant);
	
	public int deletePick(RestaurantVo restaurant);
}
