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
import com.xiaolangn.util.SDKTestSendTemplateSMS;

public class RegisterAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1765784898388L;

	@Resource
	IUserService userService;


	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	
	
	public String show() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		
		return "show";//指定返回路径

	}
	
	public void sendSMS() {
		String json = "{\"msg\": \"success\"}";
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String phoneNum = request.getParameter("phoneNum");
		
		User user = userService.getUserByPhone(phoneNum);
		//如果该用户已经注册
		if(user!=null&&user.getPhoneNum()!=null&&!user.getPhoneNum().equals("")&&user.getPhoneNum().equals(phoneNum)){
			json = "{\"msg\": \"您已经注册过了\"}";
		}else{
			if(SDKTestSendTemplateSMS.sendSMS(request, phoneNum)==-1){
				json = "{\"msg\": \"验证码已经发送，请不要重复请求发送，验证码有效期为5分钟\"}";
			}
		}
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
	
}