package com.xiaolangn.service;


import java.util.List;

import com.xiaolangn.bean.Product;

public interface IProductService {
	public  List<Product> getProductByHot(Integer ishot);
}
