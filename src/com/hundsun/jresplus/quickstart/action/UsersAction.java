package com.hundsun.jresplus.quickstart.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hundsun.jresplus.quickstart.biz.po.Users;
import com.hundsun.jresplus.quickstart.biz.service.UsersService;


@Controller
@RequestMapping("/users")
public class UsersAction {

	@Autowired
	private UsersService userService;
	
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public void addUserShow(HttpServletRequest request){

		System.out.println("this is add users method !!");
	
//		userService.addUser(user);
		
	}
	
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(HttpServletRequest request,@ModelAttribute Users user){

		System.out.println("this is add users method !!");
	
		userService.addUser(user);
		
		return "users/success";
	}
	
}
