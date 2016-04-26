package com.xiaolangn.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.tencent.common.RandomStringGenerator;
import com.tencent.common.Signature;
import com.tencent.common.XMLParser;
import com.xiaolangn.service.IUserService;
import com.xiaolangn.util.CusAccessObjectUtil;
import com.xiaolangn.util.PayCommonUtil;
import com.xiaolangn.util.WXConfigure;
import com.xiaolangn.util.WeixinUtil;

public class PayAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1765784568388L;

	@Resource
	IUserService userService;

	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	Logger logger = Logger.getLogger(PayAction.class);

	public String show() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		return "show";// 指定返回路径
	}

	public String callback() {
		Logger logger = Logger.getLogger(PayAction.class);
		String appid = WXConfigure.appId;
		String secret = WXConfigure.appsecret;
		String code = (String) request.getParameter("code");
		String state = (String) request.getParameter("state");//获取前台传过来的state，这边可以用作商品的编号和用户的ID，如123-456
		String grant_type = "authorization_code";
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ appid + "&secret=" + secret + "&code=" + code
				+ "&grant_type=authorization_code";
		JSONObject js = WeixinUtil.httpRequest(url, "GET", null);
		String openid = (String) js.get("openid");
		logger.info("openid>>>>>>>>>>>>>" + openid);
		String packageStr = getPrepayId(openid,state);
		apply(packageStr);

		
		return "apply";// 指定返回路径
	}

	public synchronized void payback() {

		logger.info("payback>>>>>>>>>>>>>" + "支付回调开始");
		StringBuffer buffer = new StringBuffer();
		// 将返回的输入流转换成字符串
		InputStream inputStream = null;
		try {
			inputStream = request.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(inputStream, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String str = null;
		try {
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
		try {
			
		} finally{
				try {
					bufferedReader.close();
					inputStreamReader.close();
				} catch (Exception e) {				
					e.printStackTrace();
				}
							
		}
		
		logger.info("payback>>>>>>>>>>>>>" + "支付后回调"+buffer);
		logger.info("payback>>>>>>>>>>>>>" + "支付后回调"+str);
		logger.info("payback>>>>>>>>>>>>>" + "支付回调结束");
		
		
		
	//	String buffer = "<xml><appid><![CDATA[wx9ffc728a584dc255]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><device_info><![CDATA[WEB]]></device_info><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1333280901]]></mch_id><nonce_str><![CDATA[79vz8wec2svz5468rxv87qcqg7w1ltt9]]></nonce_str><openid><![CDATA[oJ_lHs0q8Q-2f23AZP4DR89EUiMc]]></openid><out_trade_no><![CDATA[j5plp4hli81461656813225]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[81BCC4D2886BD9DA77EFEC9F3BACEC93]]></sign><time_end><![CDATA[20160426154703]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[4000412001201604265242903893]]></transaction_id></xml>";
		Map map = null;
		try {
			map = XMLParser.getMapFromXML(buffer.toString());
			logger.info("map>>>>>>>>>>" + map.toString());
		} catch (Exception e) {		
			e.printStackTrace();
		}

		String return_code = (String) map.get("return_code"); // 返回的预处理编码
		if(return_code!=null&&return_code.equals("SUCCESS")){//表示支付处理成功
			String appid = (String) map.get("appid");
			String openid = (String) map.get("openid"); 
			String nonce_str = (String) map.get("nonce_str");
			String sign = (String) map.get("sign");
			
			String trade_type = (String) map.get("trade_type");
			String bank_type = (String) map.get("bank_type");
			String total_fee = (String) map.get("total_fee");
			String cash_fee = (String) map.get("cash_fee");//现金支付金额
			String transaction_id = (String) map.get("transaction_id");//微信支付订单号
			String out_trade_no = (String) map.get("out_trade_no");//商户订单号
			String time_end = (String) map.get("time_end");//支付完成时间
			String attach = (String) map.get("attach");//支付完成时间
			
			logger.info("支付通知>>>>>>>>支付成功");
			logger.info("appid"+appid +"attach"+attach);
			
		}else{//表示支付处理失败
			logger.info("支付通知>>>>>>>>支付取消或者失败");
		}
		
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("return_code", "SUCCESS"); 
		parameters.put("return_msg", "OK"); 
		String requestXML = PayCommonUtil.getRequestXml(parameters);// 生成预处理请求xml
		PrintWriter out;
		try {
				out = response.getWriter();
				out.write(requestXML);
			} catch (IOException e) {				
				e.printStackTrace();
		}
	}

	public String getPrepayId(String openid,String state) {

		// 预处理的map集合中key一定要是全部小写英文
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("appid", WXConfigure.appId); // 公众账号ID
		parameters.put("mch_id", WXConfigure.mch_id); // 商户号
		parameters.put("device_info", "WEB"); // 设备号
		parameters.put("nonce_str", WXConfigure.nonceStr); // 随机字符串
		parameters.put("body", "xiaolangtriavl"); // 商品描述
	//	parameters.put("attach", state); // 商品描述
		parameters.put(
				"out_trade_no",
				RandomStringGenerator.getRandomStringByLength(10)
						+ String.valueOf((new Date().getTime())));// 商户订单号
		parameters.put("total_fee", "1"); // 总金额
		
		String ip = CusAccessObjectUtil.getIpAddress(request);
		logger.info(ip+"ip>>>>>>>>>>>>>>>>");
		parameters.put("spbill_create_ip", ip); // 订单生成的机器IP,测试IP
		parameters.put("notify_url", WXConfigure.notify_url); // 通知地址,测试地址
		parameters.put("trade_type", WXConfigure.trade_type); // 交易类型(JSAPI、NATIVE、APP)
		parameters.put("openid", openid);// 用户标识 JSAPI时，此参数必传，根据第一步授权获取openid
		String signStr = "";

		signStr = Signature.getSign(parameters);
		// 进行签名字符串构造
		parameters.put("sign", signStr);

		String requestXML = PayCommonUtil.getRequestXml(parameters);// 生成预处理请求xml

		String result = "";
		try {
			result = WeixinUtil.httpRequest2(
					"https://api.mch.weixin.qq.com/pay/unifiedorder", "POST",
					requestXML);
			logger.info("result>>>>>>>>>>>>>" + result);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Map map = null;
		try {
			map = XMLParser.getMapFromXML(result);
			logger.info("map>>>>>>>>>>" + map.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String packageStr = "prepay_id=" + map.get("prepay_id"); // 返回的预处理编码
		return packageStr;
	}

	public void notifyWX() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("");
	}

	public String apply(String packageStr) {
		logger.info("apply函数>>>>>>>>>>" + packageStr);
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		// String packageStr = getPrepayId();
		// 1
		request.setAttribute("appId", WXConfigure.appId);// 从后台返回参数给request（跟jsp有关）
		// 2
		Long tinmeStamp = new Date().getTime();
		request.setAttribute("timeStamp", tinmeStamp);// 从后台返回参数给request（跟jsp有关）
		// 3
		request.setAttribute("nonceStr", WXConfigure.nonceStr);// 从后台返回参数给request（跟jsp有关）
		request.setAttribute("package", packageStr);// 从后台返回参数给request（跟jsp有关）

		// 4
		request.setAttribute("signType", "MD5");// 从后台返回参数给request（跟jsp有关）
		// 5

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("appId", WXConfigure.appId); // 公众账号ID
		parameters.put("timeStamp", tinmeStamp); // 公众账号ID
		parameters.put("nonceStr", WXConfigure.nonceStr); // 公众账号ID
		parameters.put("package", packageStr); // 公众账号ID>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		parameters.put("signType", "MD5"); // 公众账号ID
		String signStr = "";

		signStr = Signature.getSign(parameters);

		request.setAttribute("paySign", signStr);
		logger.info("apply函数>>>>>>>>>>调用结束");
		return "apply";// 指定返回路径

	}

}
