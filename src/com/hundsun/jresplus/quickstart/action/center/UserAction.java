package com.hundsun.jresplus.quickstart.action.center;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hundsun.jresplus.quickstart.biz.bo.Result;
import com.hundsun.jresplus.quickstart.biz.po.Building;
import com.hundsun.jresplus.quickstart.biz.po.User;
import com.hundsun.jresplus.quickstart.biz.service.BuildingService;
import com.hundsun.jresplus.quickstart.biz.service.UserService;
import com.hundsun.jresplus.quickstart.common.UserAgent;

/**
 * 用户
 * @author chengy 
 * @editor frb
 * @version $Id: UserAction.java,v 0.1 2015年6月2日 下午8:56:27 chengy Exp $
 */
@Controller
@RequestMapping(value = "/center/user")
public class UserAction {

    @Autowired
    UserService     userService;
    @Autowired
    BuildingService buildingService;

    /**
     * 资料修改
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editInit(UserAgent user, Model model) {
        User userInfo = userService.getUserByID(user.getId());
        model.addAttribute("userInfo", userInfo);
        return "center/user/edit";
    }

    /**
     * 资料修改
     * @param user
     * @param userInfo
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(UserAgent user, @ModelAttribute("userInfo") User userInfo, Model model) {
        if (user.getId().equals(userInfo.getId())) {
            userService.update4Edit(userInfo);
            model.addAttribute("message", "保存成功！");
            User userInfoNew = userService.getUserByID(user.getId());
            model.addAttribute("userInfo", userInfoNew);
        }
        return "center/user/edit";
    }
    
    /**
     * 上传图片
     * 
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String Upload(UserAgent user,
    		@RequestParam(value = "image") MultipartFile image,
    		HttpServletRequest request,
    		@ModelAttribute("userInfo") User userInfo, 
    		Model model) throws IOException {
    		
    	// 图片上传
    	String path = request.getRealPath("upload");
    	System.out.println(path);
    	String filePath = FileUpload.uploadFile(image, request, path);
    	System.out.println("filePath："+filePath);
    	userInfo.setContactor(filePath);
        if (user.getId().equals(userInfo.getId())) {
            userService.updateEdit(userInfo);
    	model.addAttribute("imageMessage", "上传成功！");
        User userInfoNew = userService.getUserByID(user.getId());
        model.addAttribute("userInfo", userInfoNew);
        }
    	return "center/user/edit";
    }


    /**
     * 密码修改
     * @param user
     * @param pwdOld
     * @param pwdNew
     * @param pwdConfirm
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/passwordEdit", method = RequestMethod.POST)
    public String passwordEdit(UserAgent user, @RequestParam("pwdOld") String pwdOld,
                               @RequestParam("pwdNew") String pwdNew,
                               @RequestParam("pwdConfirm") String pwdConfirm, Model model,
                               HttpSession session) {
        Result result = userService.passwordEdit(user, pwdOld, pwdNew, pwdConfirm);
        if (!result.isSuccess()) {
            model.addAttribute("message", result.getMessage());
            model.addAttribute("url", "center/user/detail.htm");
            return "center/error";
        } else {
            model.addAttribute("message", "修改成功，请用新密码重新登录");
            model.addAttribute("url", "login/login.htm");
            session.setAttribute(UserAgent.AGENT, null);
            return "center/success";
        }
    }

    /**
     * 详情
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail")
    public String detail(UserAgent user, Model model) {
        if (user != null) {
            User userInfo = userService.getUserByID(user.getId());
            List<Building> list = buildingService.queryAll();
            model.addAttribute("buildingList", list);
            model.addAttribute("userInfo", userInfo);
            return "center/user/detail";
        } else {
            model.addAttribute("message", "请先登录！");
            return "error";
        }
    }

}
