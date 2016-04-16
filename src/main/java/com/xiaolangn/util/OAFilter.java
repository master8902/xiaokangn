package com.xiaolangn.util;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiaolangn.action.UserContext;
import com.xiaolangn.service.IUserService;

public class OAFilter implements Filter {

	/**
	 * 
	 */
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	

	IUserService userService;
	
	private Set<String> filterModules = new HashSet<String>();

	public OAFilter() {
		filterModules.add("/project");
		filterModules.add("/product");
		filterModules.add("/fee");
		filterModules.add("/requirement");
		filterModules.add("/productcategory");
	}
	
	@Override
	public void doFilter(ServletRequest request0, ServletResponse response1,
			FilterChain chain ) throws IOException, ServletException {
		/*
		
		HttpServletRequest request = (HttpServletRequest)request0;
		HttpServletResponse response =(HttpServletResponse)response1;
		HttpSession session = request.getSession(false);
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		String url = request.getServletPath();
		if(session == null){
			if(url!=null && !"".equals(url) && (!"/login.jsp".equals(url) && !"/user/login_login.do".equals(url) && !"/user/login_exec.do".equals(url))){
				response.sendRedirect(basePath+"login.jsp");
				return;
			}else if(url == null || "".equals(url)){
				response.sendRedirect(basePath+"login.jsp");
				return;
			}
		}else{
			UserContext context = new UserContext(session);

			if (!context.isLogedin()){
				if(url!=null && !"".equals(url) && (!"/login.jsp".equals(url) && !"/user/login_login.do".equals(url) && !"/user/login_exec.do".equals(url))){
					response.sendRedirect(basePath+"login.jsp");
					return;
				}
			} else {
				int idx = url.indexOf("/", 1);
				if (idx > -1) {
					String namespace = url.substring(0, idx);
					
				}
			}
		}
		*/
		chain.doFilter(request0,response1);
		return;
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}
