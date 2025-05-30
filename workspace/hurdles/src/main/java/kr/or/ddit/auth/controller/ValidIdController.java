package kr.or.ddit.auth.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.auth.service.AuthService;
import kr.or.ddit.util.JsonUtil;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.MemberVo;

@WebServlet("/auth/validId.do")
@MultipartConfig
public class ValidIdController extends HttpServlet {
	AuthService authService = AuthService.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo member = RequestToVoMapper.mapRequestToVo(req, MemberVo.class);
		Map<String, Object> map = new HashMap<String, Object>();

		if (member.getMemberId() == null || member.getMemberId().equals("")) {
			map.put("item", "fail");

			resp.setContentType("application/json");
			resp.getWriter().write(JsonUtil.toJson(map));
			return;
		}

		MemberVo validId = authService.validId(member);

		map.put("item", validId == null ? "success" : "fail");

		resp.setContentType("application/json");
		resp.getWriter().write(JsonUtil.toJson(map));
	}
}
