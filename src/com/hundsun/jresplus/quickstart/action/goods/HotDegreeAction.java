package com.hundsun.jresplus.quickstart.action.goods;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotDegreeAction {
	
	@RequestMapping(value = "/goods/like")
	public String like(HttpServletRequest request,Model model)
	{
		String address = request.getParameter("like_address");
		
		System.out.println(address);
		
		return address;
	}
	/*
	@RequestMapping(value = "/goods/view")
	public String view(HttpServletRequest request,Model model)
	{
		String address = request.getParameter("address");
		
		return address;
	}
	*/
}
