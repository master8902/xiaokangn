package com.xiaolangn.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.xiaolangn.bean.Product;
import com.xiaolangn.service.IProductService;

public class ProductAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1765784568388L;

	@Resource
	IProductService productService;


	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	
	/**
	 * 查询近期热门产品
	 * @return
	 */
		public String index() {
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("utf-8");		
			String ishot = request.getParameter("ishot");//ishot从前台jsp到后台
			List<Product> product = productService.getProductByHot(Integer.valueOf(ishot));	
			request.setAttribute("productHot", product);					
			response.setCharacterEncoding("utf-8");	
			String type = request.getParameter("type");
			List<Product> productzhoubian = null;
			if(type.equals("zhoubian")){
				 productzhoubian = productService.getProductByType("周边");	
			}else if(type.equals("yuanzheng")){
				 productzhoubian = productService.getProductByType("远征");	
			 }else if(type.equals("duantu")){
				 productzhoubian = productService.getProductByType("短途");
			 }else{
				 productzhoubian = productService.getProductByType("周边");	
			 }
			request.setAttribute("productzhoubian", productzhoubian);
			request.setAttribute("type", type);
			return "productinfo";//指定返回路径

		}
		
		/**
		 * 查询近期热门产品
		 * @return
		 */
			public String search() {
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("utf-8");		
				String ishot = request.getParameter("ishot");//ishot从前台jsp到后台
				List<Product> product = productService.getProductByHot(Integer.valueOf(ishot));	
				request.setAttribute("productHot", product);					
				response.setCharacterEncoding("utf-8");	
				String search = "";
				try {
					search = URLDecoder.decode(request.getParameter("search"), "utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<Product> productzhoubian = productService.getProductByName(search);
				request.setAttribute("productzhoubian", productzhoubian);
				request.setAttribute("type", "zhoubian");
				return "productinfo";//指定返回路径

			}

/**
 * 查询近期热门产品
 * @return
 */
	public String info2() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String ishot = request.getParameter("ishot");//ishot从前台jsp到后台
		List<Product> product = productService.getProductByHot(Integer.valueOf(ishot));	
		request.setAttribute("product", product);
		return "productinfo";//指定返回路径

	}
	
/**
 * 	周边/短途/远征查询产品   //默认周边
 * @return
 */
	public String typeInfo() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
//		String type = request.getParameter("type");//type从前台jsp到后台
		String type = "远征";
		List<Product> product = productService.getProductByType(type);	
		request.setAttribute("productByType", product);

		
		return "productinfo";//指定返回路径

	}

/**
 * 	模糊字段查询产品
 * @return
 */
	public void queryProductByName() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");		
		String chineseName = "日本";
		List<Product> product = productService.getProductByName(chineseName);	
        System.out.println(product.size());
	}	

}

