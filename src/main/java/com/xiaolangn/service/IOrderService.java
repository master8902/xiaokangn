package com.xiaolangn.service;


import com.xiaolangn.bean.Order;
import com.xiaolangn.bean.Product;

public interface IOrderService {
	
	/**
	 * 新增订单
	 * @param order
	 * @return
	 */
	public int newAddOrder(Order order);
	
	/**
	 * 根据订单ID查询订单须知
	 * @param 订单id
	 */
	public Order queryOrderById(Integer id);
	
	
	public Product selectProByOrderId(Integer id);
	
	/**
	 * 修改订单
	 * @param order
	 */
	public Integer modifyOrder(Order order);
	
	
	//根据用户的id，查询最新一条的订单
	public Order selectOrderByUserId(Integer id);
}
