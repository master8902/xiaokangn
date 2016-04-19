package com.xiaolangn.service.impl;

import java.util.List;

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
    public List<Product> getProductByHot(Integer ishot) {
        // TODO Auto-generated method stub
        return productMapper.getProductByHot(ishot);
    }
    
    @Override
    public List<Product> getProductByType(String type) {
        // TODO Auto-generated method stub
        return productMapper.getProductByType(type);
    }

   


}
