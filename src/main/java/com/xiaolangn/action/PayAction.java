package com.xiaolangn.action;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.tencent.common.HttpsRequest;
import com.tencent.common.RandomStringGenerator;
import com.tencent.common.Signature;
import com.xiaolangn.bean.SignBean;
import com.xiaolangn.service.IUserService;
import com.xiaolangn.util.AccessToken;
import com.xiaolangn.util.TokenThread;
import com.xiaolangn.util.WXConfigure;

public class PayAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1765784568388L;

	@Resource
	IUserService userService;
	static int randomint = 1;

	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	
	
	
	public String apply() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");				
		//1
        request.setAttribute("appId", WXConfigure.appId);//从后台返回参数给request（跟jsp有关）
        //2
        Long tinmeStamp = new Date().getTime();
        request.setAttribute("timeStamp", tinmeStamp);//从后台返回参数给request（跟jsp有关）
        //3
     //   String nonceStr = RandomStringGenerator.getRandomStringByLength(32);
        request.setAttribute("nonceStr", WXConfigure.nonceStr  );//从后台返回参数给request（跟jsp有关）
		request.setAttribute("package", "prepay_id="+randomint);//从后台返回参数给request（跟jsp有关）
		randomint++;
		//4
		request.setAttribute("signType", "MD5");//从后台返回参数给request（跟jsp有关）
		//5
		SignBean si = new SignBean();
		si.setJsapi_ticket(TokenThread.jsApi.getJs_api());
		si.setNoncestr(WXConfigure.nonceStr);
		si.setTimestamp(tinmeStamp.toString());
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		si.setUrl(basePath+request.getServletPath());
		String sign = "";
		try {
			sign = Signature.getSign(si);
		} catch (IllegalAccessException e) {		
			e.printStackTrace();
		}
		request.setAttribute("paySign", sign);//从后台返回参数给request（跟jsp有关）
		return "apply";//指定返回路径

	}


}
