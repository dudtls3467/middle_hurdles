package kr.or.ddit.owner.restaurant.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.owner.restaurant.dao.RestaurantDao;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.vo.FileVo;
import kr.or.ddit.vo.LocalVo;
import kr.or.ddit.vo.RestaurantCodeVo;
import kr.or.ddit.vo.RestaurantVo;
import kr.or.ddit.vo.ReviewVo;

public class RestaurantService implements IRestaurantService {
	/*Singleton*/
	private static RestaurantService instance;
	
	RestaurantDao resDao = RestaurantDao.getInstance();
	
	private RestaurantService() {

	}

	public static RestaurantService getInstance() {

		if (instance == null) {

			instance = new RestaurantService();

		}

		return instance;

	}

	


	@Override
	public List<RestaurantVo> list(Pagenation<RestaurantVo> param) {
		return resDao.list(param);
	}

	@Override
	public RestaurantVo detail(RestaurantVo param) {
		return resDao.detail(param);
	}

	@Override
	public int insert(RestaurantVo param) {
		return resDao.insert(param);
	}

	@Override
	public int update(RestaurantVo param) {
		return resDao.update(param);
	}

	@Override
	public int remove(RestaurantVo param) {
		return resDao.remove(param);
	}

	@Override
	public int getAllCount(Pagenation<RestaurantVo> param) {
		return resDao.getAllCount(param);
	}

	@Override
	public int getNo() {
		return resDao.getNo();
	}

	public void restaurantFileInsert(List<FileVo> fileList, int resNo) {
		List<Map<String, Object>> param = new ArrayList<Map<String, Object>>();
		for (FileVo file : fileList) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("restaurant_no", resNo);
			map.put("file_no", file.getFileNo());
			param.add(map);
		}

		resDao.restaurantFileInsert(param);
	}

	@Override
	public List<RestaurantCodeVo> getRestaurantCodeList() {
		return resDao.getRestaurantCodeList();
	}

	@Override
	public List<LocalVo> getLocalList() {
		return resDao.getLocalVo();
	}

	@Override
	public List<FileVo> getFileList(RestaurantVo param) {
		return resDao.getFileList(param);
	}

	@Override
	public void restrauntFileDelete(int[] removeFileIdList) {
		resDao.restrauntFileDelete(removeFileIdList);
	}
	
	

	public List<ReviewVo> reviewList(Map<String, Object> param) {
		return resDao.reviewList(param);
	}
}
