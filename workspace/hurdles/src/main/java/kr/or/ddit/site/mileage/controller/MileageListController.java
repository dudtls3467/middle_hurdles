package kr.or.ddit.site.mileage.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.site.mileage.service.MileageService;
import kr.or.ddit.util.Pagenation;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.MileageVo;

@WebServlet("/site/mileageList.do")
public class MileageListController extends HttpServlet{
	
	MileageService mileageService = MileageService.getInstance();
		
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pagenation<MileageVo> pagenation = (Pagenation<MileageVo>) RequestToVoMapper.mapRequestToVo(req, Pagenation.class);
	    		String memberNo = req.getParameter("memberNo");

		MileageVo mileagevo = RequestToVoMapper.mapRequestToVo(req, MileageVo.class);
		pagenation.setPageMap(Map.of("memberNo",memberNo));
		pagenation.setSearchVo(mileagevo);
		
		int totalCount = mileageService.getAllCount(pagenation);
		pagenation.setTotalRecordCount(totalCount);

		List<MileageVo> mileageList = mileageService.list(pagenation);

		int sum = 0;
		// 허성진 수정
//		for (int i=0; i<mileageList.size(); i++ ){
//			
//			MileageVo mileage = mileageList.get(mileageList.size()-1-i);
//			
//			sum += mileage.getUsedMileage();
//			
//			mileage.setUsedMileage(sum);
//		}
		
		
		
		req.setAttribute("paginationInfo", pagenation);
		req.setAttribute("mileageList", mileageList);
		
		
		
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/site/mileage/mileageList.jsp").forward(req, resp);
		
		
	}
}
