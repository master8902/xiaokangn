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

public class PostDataAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1765784568388L;

	@Resource
	IUserService userService;


	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	
	public void demo() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String textplan3 = request.getParameter("textplan3");
		System.out.println(textplan3);
		//插入保持进数据库
		//User user = userService.getUserById(Integer.valueOf(userid));		
	
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print("success");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	

}
