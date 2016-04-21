package com.xiaolangn.mapper;



import com.xiaolangn.bean.Order;

public interface OrderMapper {


	/**
	 * 添加订单信息
	 * @param order 订单实例
	 * @return 
	 */
   public Order newAddOrder(Order order);

}
