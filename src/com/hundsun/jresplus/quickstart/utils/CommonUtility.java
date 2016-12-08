package com.hundsun.jresplus.quickstart.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hundsun.jresplus.quickstart.biz.po.Users;

public class CommonUtility {
	public static Users getUser(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		return (Users)session.getAttribute("USER");
	}
	
	public static void setUser(HttpServletRequest request, Users user){
		
		HttpSession session = request.getSession();
		
		session.setAttribute("USER", user);
	}
	
}
