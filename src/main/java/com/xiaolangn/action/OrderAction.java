package com.xiaolangn.action;

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
import com.xiaolangn.bean.Order;
import com.xiaolangn.service.IOrderService;
import com.xiaolangn.service.impl.OrderService;

public class OrderAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1765784568388L;

	@Resource
	IOrderService orderService;


	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	
//	public void info() {
//		response.setContentType("text/html;charset=UTF-8");
//		response.setCharacterEncoding("utf-8");		
//		String userid = request.getParameter("userid");
//		User user = userService.getUserById(Integer.valueOf(userid));		
//		String username = user.getPhoneNum();	
//		Gson gson = new Gson();
//		String json = gson.toJson(username);
//		PrintWriter out;
//		try {
//			out = response.getWriter();
//			out.print(json);
//			out.flush();
//			out.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
	
/**
 * 新增订单
 * 	
 */
	public void newAddOrder() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");	
//		String projectId = request.getParameter("projectId");
		String identificationType = request.getParameter("identificationType");
		String CredentialsCode = request.getParameter("CredentialsCode");
		String nickname = request.getParameter("nickname");
		String guoji = request.getParameter("guoji");
		String phoneNum = request.getParameter("phoneNum");
		String jiner = request.getParameter("jiner");
		String lianxi = request.getParameter("lianxi");
        Order order = new Order();
//        order.setId(1);
//        order.setIdentificationType("身份证");
//        order.setNationality("中国");
        order.setIdentificationType(identificationType);
        order.setIdentificationNumber(CredentialsCode);
        order.setRealName(nickname);
        order.setNationality(guoji);
        order.setPhoneNum(phoneNum);
        order.setOrderPrice(Integer.valueOf(jiner));
        order.setContacts(lianxi);
		orderService.newAddOrder(order);	
	}

/**
 * 根据订单id查询订单须知
 */
    public void queryOrderById(){
    	Integer id = 1;
    	Order order = orderService.queryOrderById(id);
    	System.out.println(order.getOrderNotice());
    }
    
/**
 * 修改订单信息 --是否支付
 * 订单id 必填
 */
    public void modifyOrder(){
    	Order order =  new Order();
    	order.setId(1);
    	order.setIsPay(1);
    	orderService.modifyOrder(order);
    	
    }

}

