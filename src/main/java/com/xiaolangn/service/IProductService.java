package com.xiaolangn.service;


import java.util.List;

import com.xiaolangn.bean.Product;

public interface IProductService {
	public  List<Product> getProductByHot(Integer ishot);
	
	public  List<Product> getProductByType(String type);
	
	public List<Product> getProductByName(String chineseName);
}
