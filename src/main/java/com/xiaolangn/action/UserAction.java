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
	
	public String showlogin() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		return "showlogin";//指定返回路径

	}
	
	public String info2() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String userid = request.getParameter("userid");//userid从前台jsp到后台
		User user = userService.getUserById(Integer.valueOf(userid));		
		String phoneNum = user.getPhoneNum();	
		request.setAttribute("phoneNum", phoneNum);//从后台返回参数给request（跟jsp有关）
		return "userinfo";//指定返回路径

	}

	public void login() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String phoneNum = request.getParameter("phoneNum");
		String password = request.getParameter("password");
//		System.out.println(textplan3);
		//根据手机号查询密码
		User user = userService.getUserByPhone(phoneNum);		
		
		PrintWriter out;
		try {
			out = response.getWriter();
			if(user==null)
				out.print("error");
			//比对密码
			else if(user.getPassword().equals(password))
			{
				out.print("success");
			}
			else 
			{
				out.print("error");
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
