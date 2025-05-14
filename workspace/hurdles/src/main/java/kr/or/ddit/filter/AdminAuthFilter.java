package kr.or.ddit.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.or.ddit.vo.MemberVo;

@WebFilter("/admin/*")
public class AdminAuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
		throws IOException, ServletException {
		
		// HttpServletRequest로 캐스팅 - 관리자가 아닌경우는 못들어오게 설정
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpresp = (HttpServletResponse) resp;
        
        // 세션 가져오기 (세션이 없으면 null 반환)
        HttpSession session = httpRequest.getSession(false);
        
        if (session != null) {
        	MemberVo member = (MemberVo) session.getAttribute("member");
        	if (member != null) { 
        		int memberRole = member.getMemberRole();
        	
	        	if (memberRole == 0) {
	        		// 관리자 경우
	        		chain.doFilter(req, resp);
	        		return;
	        	} else {
	        		// 로그인이 되어있는 관리자가 아닌 경우는 메인 화면으로 이동
	        		httpresp.sendRedirect(httpRequest.getContextPath() + "/site/main.do");
	        		return;
	        	}
        	}
        }
        
        httpresp.sendRedirect(httpRequest.getContextPath() + "/auth/login.do");
	}
}
