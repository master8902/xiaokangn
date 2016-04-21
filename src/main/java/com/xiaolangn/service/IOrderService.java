package com.xiaolangn.service;


import com.xiaolangn.bean.Order;

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
	
	/**
	 * 修改订单
	 * @param order
	 */
	public void modifyOrder(Order order);
}
