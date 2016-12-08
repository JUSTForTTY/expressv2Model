package com.hundsun.jresplus.quickstart.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hundsun.jresplus.quickstart.biz.po.Building;
import com.hundsun.jresplus.quickstart.biz.po.Response;
import com.hundsun.jresplus.quickstart.biz.po.User;
import com.hundsun.jresplus.quickstart.biz.service.BuildingService;
import com.hundsun.jresplus.quickstart.biz.service.CommonService;
import com.hundsun.jresplus.quickstart.biz.service.UserService;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.ErrorCode;
import com.hundsun.jresplus.quickstart.utils.MD5utils;

/**
 * 
 * @author chengy
 *
 */

@Controller
public class RegisterAction {

    @Autowired
    private UserService     userService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private CommonService   commonService;
    @Value("${cms.server.url}")
    private String          cmsUrl;
    

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login/login";
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String dologin(User user, HttpSession session, Model model) {
        User u = userService.selectUserByAccount(user.getUsername());
        if (u == null) {
            model.addAttribute("message", "账户不存在！");
            return "login/login";
        }
        if (!u.getPasswd().equals(MD5utils.MD5Encode(user.getPasswd()))) {
            model.addAttribute("message", "账号或密码不正确！");
            return "login/login";
        }
        if (!u.isNormal()) {
            model.addAttribute("message", "账号未审核通过或被禁用！");
            return "login/login";
        }
        session.setAttribute(UserAgent.AGENT, new UserAgent(u));
        return "redirect:" + cmsUrl;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, Model model) {
        session.setAttribute(UserAgent.AGENT, null);
        return "redirect:" + cmsUrl;
    }

    @RequestMapping(value = "/headbar/logout")
    public String logoutHeadbar(HttpSession session, Model model) {
        session.setAttribute(UserAgent.AGENT, null);
        return "redirect:/front/headbar.htm";
    }

    @RequestMapping(value = "/register2", method = RequestMethod.GET)
    public String register(HttpSession session, Model model) {
        List<Building> list = buildingService.queryAll();
        model.addAttribute("list", list);
        return "login/register2";
    }

    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public String doRegister(User user, HttpSession session, Model model) {
        String username = user.getUsername();
        if (userService.selectUserByAccount(username) != null) {
            return "login/register";
        }
        userService.insert4Register(user);
        return "login/success";
    }

    @RequestMapping("/ajax/unique/username.htm")
    public String checkUserNameUnique(@RequestParam(value = "id", required = false) Long id,
                                      @RequestParam("username") String username, ModelMap model) {

        model.put("content", userService.checkUserNameUnique(id, username));
        return "common/ajax/content";
    }

    @RequestMapping("/ajax/unique/email.htm")
    public String checkEmailUnique(@RequestParam(value = "id", required = false) Long id,
                                   @RequestParam("email") String email, ModelMap model) {

        model.put("content", userService.checkEmailUnique(id, email));
        return "common/ajax/content";
    }

    @RequestMapping("/ajax/unique/mobile.htm")
    public String checkMobileUnique(@RequestParam(value = "id", required = false) Long id,
                                    @RequestParam("mobile") String mobile, ModelMap model) {

        model.put("content", userService.checkMobileUnique(id, mobile));
        return "common/ajax/content";
    }

    @RequestMapping("/ajax/login/status.htm")
    public @ResponseBody String getLoginStatus(UserAgent user) {

        Response ret = new Response();
        if (user == null) {
            ret.setErrCode(ErrorCode.PARAM_ERROR.getCode());
            ret.setBody("未登录");
        } else {
            ret.setErrCode(ErrorCode.SUCCESS.getCode());
            ret.setBody("已登录");
        }
        return "jsonpcallback(" + commonService.toJson(ret) + ")";
    }

}
