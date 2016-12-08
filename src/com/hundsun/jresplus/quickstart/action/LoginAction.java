/**
 * 
 */
package com.hundsun.jresplus.quickstart.action;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hundsun.jresplus.quickstart.biz.po.Users;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.common.security.UserAccess;

/**
 * @author zhangsen
 *
 */

@Controller
public class LoginAction {

/*	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "users/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String dologin(Users users,HttpSession session,Model model){
		session.setAttribute(UserAgent.AGENT, new UserAgent(users));
		return "forward:goods/index.htm";
	}
	
	@UserAccess
	@RequestMapping(value="/loginTest",method=RequestMethod.GET)
	public String testLogin(UserAgent users, Model model){
		model.addAttribute("users", users);
		return "users/test";
	}*/
	
}
