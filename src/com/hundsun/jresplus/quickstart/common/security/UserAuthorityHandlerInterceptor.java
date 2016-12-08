package com.hundsun.jresplus.quickstart.common.security;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.context.request.ServletWebRequest;

import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.PermissionEnum;
import com.hundsun.jresplus.web.adapter.AnnotationMethodHandlerInterceptorAdapter;

/**
 * 管理端权限拦截控制器，根据 @UserAccess annotation來標記這個類的方法需要權限控制，
 * 
 * @author zhangsen
 * 
 */
public class UserAuthorityHandlerInterceptor extends AnnotationMethodHandlerInterceptorAdapter {

	private static final Integer placeholder = Integer.valueOf(0);

	private static Log _log = LogFactory.getLog(UserAuthorityHandlerInterceptor.class);
	
	@Override
	public void preInvoke(Method handlerMethod, Object handler, ServletWebRequest webRequest) {
		HttpServletRequest request = webRequest.getRequest();
		if(request == null) {
			return;
		}
        HttpSession session = request.getSession();
        UserAgent agent = null;
        if (session != null) {
        	agent = (UserAgent) session.getAttribute(UserAgent.AGENT);
        }else{
        	_log.warn("session is null ...");
        }
		if (!pass(agent, handlerMethod, handler)) {
			throw new UserAccessDeniedException();
		}
	}

	private Map<Method, PermissionEnum[]> caches = new ConcurrentHashMap<Method, PermissionEnum[]>();

	private Map<Method, Integer> noControlCaches = new ConcurrentHashMap<Method, Integer>();// 没有配置UserAccess的method

	private boolean pass(UserAgent user, Method handlerMethod,Object handler) {
		PermissionEnum[] funs = null;
		funs = this.caches.get(handlerMethod);
		if (funs == null) {
			if (noControlCaches.containsKey(handlerMethod)) {
				// 没有UserAccess 配置，允许任意访问
				return true;
			}
			UserAccess access = AnnotationUtils.getAnnotation(handlerMethod,UserAccess.class);
			if (access == null) {
				// 没有配置UserAccess
				noControlCaches.put(handlerMethod, placeholder);
				return true;
			}
			funs = access.value();
			this.caches.put(handlerMethod, funs);
		}
		if (funs.length == 0) {
			// 如果配置了缺省的UserAccess,表示只要登录就能访问
			return user != null;
		}
		// 配置了UserAccess
		if (user != null) {
			for (PermissionEnum em : funs) {
				if (user.havePermission(em)) {
					return true;
				}
			}
		}
		return false;
	}
}
