package com.hundsun.jresplus.quickstart.common.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.velocity.tools.view.context.ViewContext;

import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.PermissionEnum;

/**
 * 
 * @author zhangsen
 * 
 */
public class UserAccessVMTool {

	private UserAgent agent;

	public void init(Object obj) {
		if (!(obj instanceof ViewContext)) {
			throw new IllegalArgumentException("Tool can only be initialized with a ViewContext");
		}
		ViewContext viewContext = (ViewContext) obj;
		HttpServletRequest request = viewContext.getRequest();
		 HttpSession session = request.getSession();
		if (session == null) {
			throw new IllegalStateException("session can not be null");
		}
		agent = (UserAgent) session.getAttribute(UserAgent.AGENT);
		if (agent == null) {
			throw new IllegalStateException("UserAgent not find in session");
		}
	}

	public boolean has(String funcationName) {
		PermissionEnum en = PermissionEnum.valueOf(funcationName);
		if (en == null) {
			throw new IllegalArgumentException("unknow function name:"+ funcationName);
		}
		return this.agent.havePermission(en);
	}

}
