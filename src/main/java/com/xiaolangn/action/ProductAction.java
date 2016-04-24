package com.xiaolangn.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Profile;

import com.google.gson.Gson;
import com.xiaolangn.bean.Product;
import com.xiaolangn.service.IProductService;

public class ProductAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1765784568388L;

	@Resource
	IProductService productService;


	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	
//	public void info() {
//		response.setContentType("text/html;charset=UTF-8");
//		response.setCharacterEncoding("utf-8");		
//		String userid = request.getParameter("userid");
//		User user = userService.getUserById(Integer.valueOf(userid));		
//		String username = user.getPhoneNum();	
//		Gson gson = new Gson();
//		String json = gson.toJson(username);
//		PrintWriter out;
//		try {
//			out = response.getWriter();
//			out.print(json);
//			out.flush();
//			out.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}

/**
 * 查询近期热门产品
 * @return
 */
	public String info2() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String ishot = request.getParameter("ishot");//ishot从前台jsp到后台
		List<Product> product = productService.getProductByHot(Integer.valueOf(ishot));	
		request.setAttribute("product", product);
//		String title = product.getTitle();	
//		request.setAttribute("title", title);//从后台返回参数给request（跟jsp有关）
//		
//		Date startDate = product.getStartDate();
//		String startDateString = startDate.toLocaleString();
//		request.setAttribute("startDateString", startDateString);//从后台返回参数给request（跟jsp有关）
//		System.out.println("############################"+startDateString);
//		
//		Date endDate = product.getEndDate();	
//		String endDateString = endDate.toLocaleString();
//		request.setAttribute("endDateString", endDateString);//从后台返回参数给request（跟jsp有关）
//		
//		String picture_url = product.getPicture_url();	
//		request.setAttribute("picture_url", picture_url);//从后台返回参数给request（跟jsp有关）
		
		return "productinfo";//指定返回路径

	}
	
/**
 * 	短途/远征查询产品
 * @return
 */
	public String typeInfo() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
//		String type = request.getParameter("type");//type从前台jsp到后台
		String type = "远征";
		List<Product> product = productService.getProductByType(type);	
		request.setAttribute("productByType", product);

		
		return "productinfo";//指定返回路径

	}

/**
 * 	模糊字段查询产品
 * @return
 */
	public void queryProductByName() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String chineseName = "日本";
		List<Product> product = productService.getProductByName(chineseName);	
        System.out.println(product.size());
	}	

}

