package com.xiaolangn.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.xiaolangn.bean.Order;
import com.xiaolangn.bean.Product;
import com.xiaolangn.service.IOrderService;
import com.xiaolangn.service.IProductService;
import com.xiaolangn.service.IUserService;

public class OrderAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1765784568388L;

	@Resource
	IOrderService orderService;
	@Resource
	IProductService productService;
	@Resource
	IUserService userService;
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	
	public String info() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String productId = request.getParameter("productId");//productid从前台jsp到后台		
		request.setAttribute("productId", productId);//从后台返回参数给request（跟jsp有关）
		String Phone = (String) request.getParameter("Phone");
		Integer userId =  userService.getUserByPhone(Phone).getId();
		request.setAttribute("userId", String.valueOf(userId));//从后台返回参数给request（跟jsp有关）
		Product product  = productService.getProductById(Integer.valueOf(productId));		
		request.setAttribute("product", product);//从后台返回参数给request（跟jsp有关）
		return "dingdan";
	}
	
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
		String productId = request.getParameter("productId");
		String userId = request.getParameter("userId");
		
		
        Order order = new Order();
//        order.setId(1);
//        order.setIdentificationType("身份证");
//        order.setNationality("中国");
        order.setIdentificationType(identificationType);
        order.setIdentificationNumber(CredentialsCode);
        order.setRealName(nickname);
        order.setNationality(guoji);
        order.setPhoneNum(phoneNum);
        order.setOrderPrice(Double.valueOf(jiner));
        order.setContacts(lianxi);
        order.setProductid(Integer.valueOf(productId));
        order.setUserId(Integer.valueOf(userId));
		Integer id = orderService.newAddOrder(order);	
		Integer insertid = order.getId();
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(insertid);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

/**
 * 根据订单id查询订单须知
 */
    public void queryOrderById(){
    	String productId = request.getParameter("productId");
    	Product order = productService.getProductNotice(Integer.valueOf(productId));
    	String notice  = order.getNotice();
    	PrintWriter out;
		try {
			out = response.getWriter();
			out.print(notice);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

