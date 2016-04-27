package com.xiaolangn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;







import com.xiaolangn.bean.Order;
import com.xiaolangn.bean.Product;
import com.xiaolangn.mapper.OrderMapper;
import com.xiaolangn.service.IOrderService;

@Service
public class OrderService implements IOrderService {

    // private static Logger logger = Logger.getLogger(UserService.class);

    @Resource
    OrderMapper orderMapper;

  
    @Override
    public int newAddOrder(Order order) {
        // TODO Auto-generated method stub
        return orderMapper.newAddOrder(order);
    }
    
    @Override
	public Order queryOrderById(Integer id){
    	
    	return orderMapper.queryOrderById(id);
    }
    
    @Override
	public Integer modifyOrder(Order order){
    	
    	return orderMapper.modifyOrder(order);
    }

	@Override
	public Product selectProByOrderId(Integer id) {
		// TODO Auto-generated method stub
		return orderMapper.selectProByOrderId(id);
	}
    
}
