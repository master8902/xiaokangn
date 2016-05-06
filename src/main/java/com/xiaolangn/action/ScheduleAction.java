package com.xiaolangn.action;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.xiaolangn.bean.Schedule;
import com.xiaolangn.service.IProductService;
import com.xiaolangn.service.IScheduleService;

public class ScheduleAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1765784568388L;

	@Resource
	IScheduleService scheduleService;
	@Resource
	IProductService productService;

	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	
	public String showdetail(){
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String productId = request.getParameter("productId");//productid从前台jsp到后台
		String scheduleId = request.getParameter("scheduleId");
		
		List<Schedule> schedule = scheduleService.getScheduleByProductId(Integer.valueOf(productId));	
		
		request.setAttribute("schedule", schedule);
		request.setAttribute("productId", productId);//从后台返回参数给request（跟jsp有关）
		Product product  = productService.getProductById(Integer.valueOf(productId));		
		request.setAttribute("product", product);//从后台返回参数给request（跟jsp有关）
		
		return "xingcheng";//指定返回路径
	}
	
	public String info2() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String productId = request.getParameter("productId");//productid从前台jsp到后台
		List<Schedule> schedule = scheduleService.getScheduleByProductId(Integer.valueOf(productId));	
		
		request.setAttribute("schedule", schedule);
		
		
		request.setAttribute("productId", productId);//从后台返回参数给request（跟jsp有关）
		Product product  = productService.getProductById(Integer.valueOf(productId));
		
		request.setAttribute("product", product);//从后台返回参数给request（跟jsp有关）
		
		return "scheduleinfo";//指定返回路径

	}


}
