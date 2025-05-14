package kr.or.ddit.admin.restaurant.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.admin.restaurant.service.RestaurantService;
import kr.or.ddit.util.ParamResult;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.RestaurantVo;

@WebServlet("/admin/restaurantDelete.do")
public class RestaurantDeleteController extends HttpServlet {
	RestaurantService resService = RestaurantService.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] requiredParams = {"restaurantNo"};
		
		ParamResult paramResult = ParamResult.valid(req, requiredParams);// 필수인자 확인
		
		if (paramResult.getCode() == 1 && !paramResult.getMessage().equals("")) {
			// 에러 메시지를 요청 속성에 추가
			req.setAttribute("errorMessage", paramResult.getMessage());

			// 에러 페이지로 포워드
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}
		
		RestaurantVo param = RequestToVoMapper.mapRequestToVo(req, RestaurantVo.class);
		int result = resService.remove(param);
		
		if (result == 1) {
			resp.sendRedirect(req.getContextPath() + "/admin/restaurantList.do");
			return;
		}

		resp.sendRedirect(req.getContextPath() + "/admin/restrauntDetail.do?restaurantNo=" + param.getRestaurantNo());

	}
}
