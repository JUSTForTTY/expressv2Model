package com.hundsun.jresplus.quickstart.action.contain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hundsun.jresplus.quickstart.common.UserAgent;

@Controller
public class HeadBar {
    @RequestMapping("/contain/headbar")
    public void headBar(UserAgent user, ModelMap model) throws Exception {
        if (user != null) {
            model.addAttribute("username", user.getUserName());
        }
    }
}
