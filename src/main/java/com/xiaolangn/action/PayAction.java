package com.xiaolangn.action;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.jdom.JDOMException;

import com.tencent.common.HttpsRequest;
import com.tencent.common.Signature;
import com.xiaolangn.bean.SignBean;
import com.xiaolangn.service.IUserService;
import com.xiaolangn.util.CusAccessObjectUtil;
import com.xiaolangn.util.PayCommonUtil;
import com.xiaolangn.util.TokenThread;
import com.xiaolangn.util.WXConfigure;
import com.xiaolangn.util.WeixinUtil;
import com.xiaolangn.util.XMLUtil;

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
	
	public String getPrepayId(){		
		//预处理的map集合中key一定要是全部小写英文
		  Map<String,Object> parameters = new HashMap<String,Object> ();
	       parameters.put("appid", WXConfigure.appId); // 公众账号ID
	       parameters.put("mch_id", WXConfigure.mch_id); // 商户号
	       parameters.put("nonce_str", WXConfigure.nonceStr); // 随机字符串
	       parameters.put("device_info", WXConfigure.device_info); // 设备号	          
	       parameters.put("body", "bussinesdesc"); // 商品描述
	       //parameters.put("sign", ); // 签名	   
	       parameters.put("out_trade_no", "111111");// 商户订单号
	       parameters.put("total_fee", "1"); // 总金额
	       String  ip = CusAccessObjectUtil.getIpAddress(request);
	       parameters.put("spbill_create_ip", "192.168.20.11"); // 订单生成的机器IP,测试IP
	       parameters.put("notify_url", WXConfigure.notify_url); // 通知地址,测试地址    
	       parameters.put("trade_type", WXConfigure.trade_type); // 交易类型(JSAPI、NATIVE、APP)
	       parameters.put("openid", "");// 用户标识 JSAPI时，此参数必传，根据第一步授权获取openid
	       String signStr="";

			signStr = Signature.getSign(parameters);
			//进行签名字符串构造	   
	       parameters.put("sign", signStr); 
	       
	       String requestXML = PayCommonUtil.getRequestXml(parameters);//生成预处理请求xml
	      
	       String result ="";
		try {
		 result = WeixinUtil.httpRequest2("https://api.mch.weixin.qq.com/pay/unifiedorder","POST",  requestXML);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	       Map map = null;
		try {
			map = XMLUtil.doXMLParse(requestXML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	      
	       String packageStr = "prepay_id=" +  map.get("prepay_id"); //返回的预处理编码
	       return packageStr;
	}
	
	public void notifyWX() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		System.out.println("");
	}
	public String apply() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");	
		String packageStr = getPrepayId();
		//1
        request.setAttribute("appId", WXConfigure.appId);//从后台返回参数给request（跟jsp有关）
        //2
        Long tinmeStamp = new Date().getTime();
        request.setAttribute("timeStamp", tinmeStamp);//从后台返回参数给request（跟jsp有关）
        //3
     //   String nonceStr = RandomStringGenerator.getRandomStringByLength(32);
        request.setAttribute("nonceStr", WXConfigure.nonceStr  );//从后台返回参数给request（跟jsp有关）
		request.setAttribute("package", packageStr);//从后台返回参数给request（跟jsp有关）
		randomint++;
		//4
		request.setAttribute("signType", "MD5");//从后台返回参数给request（跟jsp有关）
		//5
		SignBean si = new SignBean();
		si.setJsapi_ticket(TokenThread.jsApi.getJs_api());
		si.setNoncestr(WXConfigure.nonceStr);
		si.setTimestamp(tinmeStamp.toString());
	
		  Map<String,Object> parameters = new HashMap<String,Object> ();
	       parameters.put("appid", WXConfigure.appId); // 公众账号ID
	       parameters.put("timeStamp", tinmeStamp); // 公众账号ID
	       parameters.put("nonceStr", WXConfigure.nonceStr); // 公众账号ID
	       parameters.put("package", packageStr); // 公众账号ID
	       parameters.put("signType", "MD5"); // 公众账号ID
		 String signStr="";
		
		signStr = Signature.getSign(parameters);

		request.setAttribute("sign", signStr);

		return "apply";//指定返回路径

	}


}
