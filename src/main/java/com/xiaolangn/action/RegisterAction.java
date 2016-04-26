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

import org.apache.log4j.Logger;
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
	Logger logger = Logger.getLogger(RegisterAction.class); 
	
	public String show() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String productId = request.getParameter("productId");//productid从前台jsp到后台
		request.setAttribute("productId", productId);//从后台返回参数给request（跟jsp有关）
		return "show";//指定返回路径

	}
	
	public void insert() {
		String json = "{\"msg\": \"success\"}";
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		
		String phoneNum = request.getParameter("Phone");
		String passWord = request.getParameter("repassword");
		String btnSendCode = request.getParameter("SmsCheckCode");
		String productId = request.getParameter("productId");//productid从前台jsp到后台
		request.setAttribute("productId", productId);//从后台返回参数给request（跟jsp有关）
	//	String Phone = (String) request.getParameter("phoneNum");
	//	Integer userId =  userService.getUserByPhone(phoneNum).getId();
		
		//首先检查session是否有手机号，验证码及发送验证码的时间
				String phoneNum1 = (String) request.getSession().getAttribute("phoneNum");//往session设置设计号
				String phoneCode1 = (String) request.getSession().getAttribute("phoneCode");//设置手机的验证码
				String phoneDate1 = (String) request.getSession().getAttribute("phoneData");//设置新建验证码的时间
				if(phoneNum1!=null&&phoneNum1.equals(phoneNum)){
					if(phoneNum1==null||phoneCode1==null||phoneDate1==null){//如果session里面有session，检测下时间，如果没过期就什么也不做，过期了就清空
						return;					
					}else{
						Date cur = new Date();
						Date date = new Date(phoneDate1);
						long interval = (cur.getTime() - date.getTime())/1000;
						if(interval-SDKTestSendTemplateSMS.DEADTIME*60>0){//如果超过5分钟，验证码就失效了，需要清空
							return;
						}				
					}
				if(!phoneNum.equals(phoneNum1)||!btnSendCode.equals(phoneCode1)){
					return;
				}
				}
				
		
		
		if(phoneNum==null||phoneNum.trim().equals("")){
			json = "{\"msg\": \"手机号码不能为空\"}";
		}
		if(passWord==null||passWord.trim().equals("")){
			json = "{\"msg\": \"密码不能为空\"}";
		}
		
		User user = new User();
		user.setCreatetime(new Date());
		user.setPhoneNum(phoneNum);
		user.setPassword(passWord);
		
		try{
			int userid = userService.insert(user);
			if(userid!=-1){
				userid = user.getId();
				request.setAttribute("userId", userid);//从后台返回参数给request（跟jsp有关）
				request.getSession().setAttribute("userId",userid );
				json = "{\"msg\": \"success\"}";
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
		 logger.info("开始发送验证码》》》》》》》》》》》》》》》》》》");  
		String json = "{\"msg\": \"success\"}";
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String phoneNum = request.getParameter("phoneNum");
		//String passWord = request.getParameter("passWord");
		
		if(phoneNum==null||phoneNum.trim().equals("")){
			json = "{\"msg\": \"手机号码不能为空\"}";
		}else{
		
		User user = userService.getUserByPhone(phoneNum);
		//如果该用户已经注册
		if(user!=null&&user.getPhoneNum()!=null&&!user.getPhoneNum().equals("")&&user.getPhoneNum().equals(phoneNum)){
			json = "{\"msg\": \"您已经注册过了\"}";
		}else{
			 logger.info("准备发送验证码》》》》》》》》》》》》》》》》》》");  
			int re = SDKTestSendTemplateSMS.sendSMS(request, phoneNum);
			logger.info("发送验证码》》》》》》》》》》》》》》》》》》返回"+re);  
			if(re==-1){
				json = "{\"msg\": \"验证码已经发送，请不要重复请求发送，验证码有效期为"+SDKTestSendTemplateSMS.DEADTIME+"分钟\"}";
			}else if(re==-2){
				json = "{\"msg\": \"验证码发送失败，可能是超过每天发送的上限\"}";
			}
		}
		}
		String productId = request.getParameter("productId");//productid从前台jsp到后台
		request.setAttribute("productId", productId);//从后台返回参数给request（跟jsp有关）
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
