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
import com.xiaolangn.bean.Schedule;
import com.xiaolangn.service.IScheduleService;

public class ScheduleAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1765784568388L;

	@Resource
	IScheduleService scheduleService;


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
	
	public String info2() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String productId = request.getParameter("productId");//productid从前台jsp到后台
		Schedule schedule = scheduleService.getScheduleByProductId(Integer.valueOf(productId));	
		
		Integer day = schedule.getDay();	
		request.setAttribute("day", day);//从后台返回参数给request（跟jsp有关）
		
		String content = schedule.getContent();	
		request.setAttribute("content", content);//从后台返回参数给request（跟jsp有关）
		
		String picture_url = schedule.getPicture_url();	
		request.setAttribute("picture_url", picture_url);//从后台返回参数给request（跟jsp有关）
		
		return "scheduleinfo";//指定返回路径

	}


}
