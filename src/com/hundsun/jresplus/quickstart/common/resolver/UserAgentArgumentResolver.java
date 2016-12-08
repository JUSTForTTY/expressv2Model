package com.hundsun.jresplus.quickstart.common.resolver;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;

import com.hundsun.jresplus.quickstart.common.UserAgent;

/**
 *
 * @author zhangsen
 *
 */
public class UserAgentArgumentResolver implements WebArgumentResolver {

	private Log _log = LogFactory.getLog(this.getClass());
	
	public Object resolveArgument(MethodParameter methodParameter,
			NativeWebRequest webRequest) throws Exception {
		if (methodParameter.getParameterType().equals(UserAgent.class)) {
			_log.debug("setting customize ArgumentResolver[UserAgentArgumentResolver]...");
			HttpSession session = ((ServletWebRequest) webRequest).getRequest().getSession();
            if (session != null) {
                return session.getAttribute(UserAgent.AGENT);
            }
		}
		return UNRESOLVED;
	}
}
