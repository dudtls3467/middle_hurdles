package kr.or.ddit.owner.menu.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.site.menu.service.MenuService;
import kr.or.ddit.util.FileUpload;
import kr.or.ddit.util.ParamResult;
import kr.or.ddit.util.RequestToVoMapper;
import kr.or.ddit.vo.FileVo;
import kr.or.ddit.vo.ProductVo;

@WebServlet("/owner/productInsert.do")
@MultipartConfig
public class ProductInsertController extends HttpServlet {
	MenuService menuService = MenuService.getInstance();
	FileService fileService = FileService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] requiredParams = { "restaurantNo" };

		ParamResult paramResult = ParamResult.valid(req, requiredParams);// 필수인자 확인

		if (paramResult.getCode() == 1 && !paramResult.getMessage().equals("")) {
			// 에러 메시지를 요청 속성에 추가
			req.setAttribute("errorMessage", paramResult.getMessage());

			// 에러 페이지로 포워드
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}

		String restaurantNo = req.getParameter("restaurantNo");
		String restaurantName = req.getParameter("restaurantName");

		req.setAttribute("restaurantNo", restaurantNo);
		req.setAttribute("restaurantName", restaurantName);

		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/owner/menu/productInsert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] requiredParams = { "restaurantNo", "productName", "productPrice" };

		ParamResult paramResult = ParamResult.valid(req, requiredParams);// 필수인자 확인

		if (paramResult.getCode() == 1 && !paramResult.getMessage().equals("")) {
			// 에러 메시지를 요청 속성에 추가
			req.setAttribute("errorMessage", paramResult.getMessage());

			// 에러 페이지로 포워드
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}

		String restaurantName = req.getParameter("restaurantName");
		String encodedRestaurantName = URLEncoder.encode(restaurantName, "UTF-8");
		
		ProductVo insertMenu = RequestToVoMapper.mapRequestToVo(req, ProductVo.class);
		int menuNo = menuService.getProductNo();
		insertMenu.setProductNo(menuNo);

		// 파일 업로드
		List<FileVo> fileList = FileUpload.fileListWrite(req, "menu");

		if (fileList.size() > 0) {
			fileService.addFiles(fileList);
			insertMenu.setFileNo(fileList.get(0).getFileNo());
		}

		// 메뉴 추가
		int result = menuService.productInsert(insertMenu);

		resp.sendRedirect(req.getContextPath() + "/owner/productDetail.do?productNo=" + insertMenu.getProductNo()
				+ "&restaurantName=" + encodedRestaurantName);
	}
}
