package com.xiaolangn.util;


/**
 * 接口访问凭证
 * 
 * @author liufeng
 * @date 2013-08-08
 */
public class JsAPI {
	// 获取到的凭证
	private String js_api;
	// 凭证有效时间，单位：秒
	private int expiresIn;

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getJs_api() {
		return js_api;
	}

	public void setJs_api(String js_api) {
		this.js_api = js_api;
	}
}