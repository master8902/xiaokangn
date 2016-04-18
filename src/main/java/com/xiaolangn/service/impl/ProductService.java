package com.xiaolangn.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaolangn.bean.Product;
import com.xiaolangn.mapper.ProductMapper;
import com.xiaolangn.service.IProductService;

@Service
public class ProductService implements IProductService {

    // private static Logger logger = Logger.getLogger(UserService.class);

    @Resource
    ProductMapper productMapper;

  
    @Override
    public Product getProductByHot(Integer ishot) {
        // TODO Auto-generated method stub
        return productMapper.getProductByHot(ishot);
    }

   


}
