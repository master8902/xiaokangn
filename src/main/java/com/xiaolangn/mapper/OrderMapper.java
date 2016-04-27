package com.xiaolangn.mapper;



import com.xiaolangn.bean.Order;
import com.xiaolangn.bean.Product;

public interface OrderMapper {


	/**
	 * 添加订单信息
	 * @param order 订单实例
	 * @return 
	 */
   public int newAddOrder(Order order);
   
   /**
    * 根据订单id查询订单须知
    */
   public Order queryOrderById(Integer id);
   
   /**
    * 修改订单信息
    */
   public Integer modifyOrder(Order order);
   
 //根据订单id，查询订单信息
 	public Product selectProByOrderId(Integer id);
}
