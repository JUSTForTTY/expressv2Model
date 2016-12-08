package com.hundsun.jresplus.quickstart.common.resolver;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.common.security.UserAccessDeniedException;

/**
 * 用户权限异常处理类
 * @author zhangsen
 * 
 */
public class UserAccessDeniedExceptionResolver extends SimpleMappingExceptionResolver {

    private String           webEncoding;

    private String           errorPage;

    private String          warnPage;

    private String           userLoginPath;

    private String           userDeniedPage;

    private String           userLoginReturnParameterName;

    public void setWebEncoding(String webEncoding) {
        this.webEncoding = webEncoding;
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }


    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {
    	//默认为系统内部程序其他错误
    	String errorMessage = "系统内部程序错误,错误代码ES007！";
        if (ex instanceof UserAccessDeniedException) {
            return resolveSettlerAccessDeniedException(request);
        }
        ModelMap model = new ModelMap();
        model.addAttribute("message", errorMessage);
        return new ModelAndView(this.errorPage,model);
    }

    private ModelAndView resolveSettlerAccessDeniedException(HttpServletRequest request) {
    	HttpSession session = request.getSession();
        UserAgent agent = (UserAgent) session.getAttribute(UserAgent.AGENT);
        if (agent == null) {// 没登录，定向到登录界面
            String returnUrl = getReturnUrl(request);
            if(returnUrl.length()<1000){
                return new ModelAndView("redirect:" + userLoginPath, userLoginReturnParameterName,
                    returnUrl);
            }else{
                request.setAttribute(userLoginReturnParameterName, request.getRequestURL().toString());
                return new ModelAndView("forward:" + userLoginPath);
            }
        }
        return new ModelAndView(this.userDeniedPage);
    }

    private String getReturnUrl(HttpServletRequest request) {
        StringBuffer sb = request.getRequestURL();
        appendRequestParameters(sb, request);
        try {
            return URLEncoder.encode(sb.toString(), this.webEncoding);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private void appendRequestParameters(StringBuffer sb, HttpServletRequest request) {
        Enumeration en = request.getParameterNames();
        if (!en.hasMoreElements()) {
            return;
        }
        sb.append('?');
        while (en.hasMoreElements()) {
            String name = (String) en.nextElement();
            String[] values = request.getParameterValues(name);
            if (values == null || values.length == 0) {
                continue;
            }
            for (String v : values) {
                try {
                    v = URLEncoder.encode(v, this.webEncoding);
                } catch (UnsupportedEncodingException ignore) {
                }
                sb.append(name).append('=').append(v).append('&');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    public String getWarnPage() {
        return warnPage;
    }

    public void setWarnPage(String warnPage) {
        this.warnPage = warnPage;
    }

	public void setUserLoginPath(String userLoginPath) {
		this.userLoginPath = userLoginPath;
	}

	public void setUserDeniedPage(String userDeniedPage) {
		this.userDeniedPage = userDeniedPage;
	}

	public void setUserLoginReturnParameterName(String userLoginReturnParameterName) {
		this.userLoginReturnParameterName = userLoginReturnParameterName;
	}

}
