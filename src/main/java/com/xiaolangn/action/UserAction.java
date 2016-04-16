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
import com.xiaolangn.bean.User;
import com.xiaolangn.service.IUserService;

public class UserAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1765784568388L;

	@Resource
	IUserService userService;


	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	
	public void info() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String userid = request.getParameter("userid");
		User user = userService.getUserById(Integer.valueOf(userid));		
		String username = user.getPhoneNum();	
		Gson gson = new Gson();
		String json = gson.toJson(username);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public String info2() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String userid = request.getParameter("userid");
		User user = userService.getUserById(Integer.valueOf(userid));		
		String PhoneNum = user.getPhoneNum();	
		request.setAttribute("PhoneNum", PhoneNum);
		return "userinfo";

	}


}
