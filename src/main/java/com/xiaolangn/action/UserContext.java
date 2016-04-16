/**
 * 
 */
package com.xiaolangn.action;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class UserContext {
	
	protected HttpSession session;
	
	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public UserContext(HttpSession session) {
		this.session = session;
	}
	
	public UserContext(){}

	public boolean isLogedin() {
		Object user_id = session.getAttribute("user_id");
		return !(user_id == null || "".equals(user_id));
	}
	
	public Integer getLoginUserId() {
		Object userId = session.getAttribute("user_id");
		if (userId == null || "".equals(userId)) {
			return null;
		}
		
		return (Integer)userId;
	}
}
