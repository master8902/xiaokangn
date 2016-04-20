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
	
	public void insert() {
		String json = "{\"msg\": \"success\"}";
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String phoneNum = request.getParameter("phoneNum");
		String passWord = request.getParameter("passWord");
		
		if(phoneNum==null||phoneNum.trim().equals("")){
			json = "{\"msg\": \"手机号码不能为空\"}";
		}
		if(passWord==null||passWord.trim().equals("")){
			json = "{\"msg\": \"密码不能为空\"}";
		}
		
		User user = new User();
		user.setCreatetime(new Date().toString());
		user.setPhoneNum(phoneNum);
		user.setPassword(passWord);
		try{
			int result = userService.insert(user);
			if(result!=-1){
				json = "{\"msg\": \"注册成功\"}";
			}else{
				json = "{\"msg\": \"注册失败\"}";
			}
			
		}catch(Exception e){
			json = "{\"msg\": \"注册失败\"}";
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
	
	public void sendSMS() {
		String json = "{\"msg\": \"success\"}";
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String phoneNum = request.getParameter("phoneNum");
		//String passWord = request.getParameter("passWord");
		
		if(phoneNum==null||phoneNum.trim().equals("")){
			json = "{\"msg\": \"手机号码不能为空\"}";
		}
		
		User user = userService.getUserByPhone(phoneNum);
		//如果该用户已经注册
		if(user!=null&&user.getPhoneNum()!=null&&!user.getPhoneNum().equals("")&&user.getPhoneNum().equals(phoneNum)){
			json = "{\"msg\": \"您已经注册过了\"}";
		}else{
			int re = SDKTestSendTemplateSMS.sendSMS(request, phoneNum);
			if(re==-1){
				json = "{\"msg\": \"验证码已经发送，请不要重复请求发送，验证码有效期为5分钟\"}";
			}else if(re==-2){
				json = "{\"msg\": \"验证码发送失败\"}";
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
