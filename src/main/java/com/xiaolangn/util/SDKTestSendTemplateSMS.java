package com.xiaolangn.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

public class SDKTestSendTemplateSMS {
	private static int DEADTIME = 5;//单位分钟
	private static String ACCOUNT_SID = "aaf98f8952f7367a015317f3136c3e19";
	private static String AUTH_TOKEN = "a09e23600e1841c28307d6a7fee78cea";
	private static String AppId = "aaf98f8952f7367a015317f394ba3e20";
	private static String restAPIUrl = "sandboxapp.cloopen.com";//*沙盒环境（用于应用开发调试）：restAPI.init("sandboxapp.cloopen.com", "8883");*
																//*生产环境（用户应用上线使用）：restAPI.init("app.cloopen.com", "8883");       *
	private static String modelId = "1";//短信模版的id
	private static String restAPIPort = "8883";
	
	
	/**
	 * @param args
	 */
	public static int sendSMS(HttpServletRequest request,String phoneNum) {
		HashMap<String, Object> result = null;
		
		//首先检查session是否有手机号，验证码及发送验证码的时间
		String phoneNum1 = (String) request.getSession().getAttribute("phoneNum");//往session设置设计号
		String phoneCode1 = (String) request.getSession().getAttribute("phoneCode");//设置手机的验证码
		String phoneDate1 = (String) request.getSession().getAttribute("phoneData");//设置新建验证码的时间
		
		if(phoneNum1!=null&&phoneCode1!=null&&phoneDate1!=null){//如果session里面有session，检测下时间，如果没过期就什么也不做，过期了就清空
			Date cur = new Date();
			Date date = new Date(phoneDate1);
			long interval = (cur.getTime() - date.getTime())/1000;
			if(interval-DEADTIME*60>0){//如果超过5分钟，验证码就失效了，需要清空
				request.getSession().removeAttribute("phoneNum");
				request.getSession().removeAttribute("phoneCode");
				request.getSession().removeAttribute("phoneData");
			}
			else
				return -1;
		}
		
		
		
		//初始化SDK
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
		
		//******************************注释*********************************************
		//*初始化服务器地址和端口                                                       *
		//*沙盒环境（用于应用开发调试）：restAPI.init("sandboxapp.cloopen.com", "8883");*
		//*生产环境（用户应用上线使用）：restAPI.init("app.cloopen.com", "8883");       *
		//*******************************************************************************
		restAPI.init(restAPIUrl, restAPIPort);
		
		//******************************注释*********************************************
		//*初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN     *
		//*ACOUNT SID和AUTH TOKEN在登陆官网后，在“应用-管理控制台”中查看开发者主账号获取*
		//*参数顺序：第一个参数是ACOUNT SID，第二个参数是AUTH TOKEN。                   *
		//*******************************************************************************
		restAPI.setAccount(ACCOUNT_SID, AUTH_TOKEN);
		
		
		//******************************注释*********************************************
		//*初始化应用ID                                                                 *
		//*测试开发可使用“测试Demo”的APP ID，正式上线需要使用自己创建的应用的App ID     *
		//*应用ID的获取：登陆官网，在“应用-应用列表”，点击应用名称，看应用详情获取APP ID*
		//*******************************************************************************
		restAPI.setAppId(AppId);
		
		
		//******************************注释****************************************************************
		//*调用发送模板短信的接口发送短信                                                                  *
		//*参数顺序说明：                                                                                  *
		//*第一个参数:是要发送的手机号码，可以用逗号分隔，一次最多支持100个手机号                          *
		//*第二个参数:是模板ID，在平台上创建的短信模板的ID值；测试的时候可以使用系统的默认模板，id为1。    *
		//*系统默认模板的内容为“【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入”*
		//*第三个参数是要替换的内容数组。																														       *
		//**************************************************************************************************
		
		//**************************************举例说明***********************************************************************
		//*假设您用测试Demo的APP ID，则需使用默认模板ID 1，发送手机号是13800000000，传入参数为6532和5，则调用方式为           *
		//*result = restAPI.sendTemplateSMS("13800000000","1" ,new String[]{"6532","5"});																		  *
		//*则13800000000手机号收到的短信内容是：【云通讯】您使用的是云通讯短信模板，您的验证码是6532，请于5分钟内正确输入     *
		//*********************************************************************************************************************
		
		String code = "6532";
		result = restAPI.sendTemplateSMS(phoneNum,modelId ,new String[]{code,String.valueOf(DEADTIME)});
		
		System.out.println("SDKTestGetSubAccounts result=" + result);
		if("000000".equals(result.get("statusCode"))){
			
			request.getSession().setAttribute("phoneNum", phoneNum);//往session设置设计号
			request.getSession().setAttribute("phoneCode", code);//设置手机的验证码
			request.getSession().setAttribute("phoneData", new Date().toString());//设置新建验证码的时间
			
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
		}else{
			//错误的情况下，先清空原来的数据
			request.getSession().removeAttribute("phoneNum");
			request.getSession().removeAttribute("phoneCode");
			request.getSession().removeAttribute("phoneData");
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}
		
		return 1;
	}

}
