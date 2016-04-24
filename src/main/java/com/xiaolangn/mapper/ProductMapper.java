package com.xiaolangn.mapper;


import java.util.List;

import com.xiaolangn.bean.Product;

public interface ProductMapper {

/**
 * 查询近期热门产品
 * @param ishot
 * @return
 */
   public List<Product> getProductByHot(Integer ishot);

/**
 * 查询短途/远征产品
 * @param type
 * @return
 */
   public List<Product> getProductByType(String type);

/**
 * 根据名称模糊搜索产品
 * @param chineseName
 * @return
 */
   public List<Product> getProductByName(String chineseName);
   
   
   public  Product getProductById(Integer id);
   
   public  Product getProductNotice(Integer id);
   
}
