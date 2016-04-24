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
import com.xiaolangn.bean.Schedule;
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
	
	public String info() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		
		

		//request.setAttribute("dingdan", picture_url);//从后台返回参数给request（跟jsp有关）
		return "dingdan";
	}
	
/**
 * 新增订单
 * 	
 */
	public void newAddOrder() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
        Order order = new Order();
        order.setId(1);
        order.setIdentificationType("身份证");
        order.setNationality("中国");
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

