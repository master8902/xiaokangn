package com.xiaolangn.mapper;


import java.util.List;

import com.xiaolangn.bean.Product;

public interface ProductMapper {


   public List<Product> getProductByHot(Integer ishot);

   
}
