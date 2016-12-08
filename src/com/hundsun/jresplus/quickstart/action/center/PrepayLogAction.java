package com.hundsun.jresplus.quickstart.action.center;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hundsun.jresplus.quickstart.biz.query.PrepayLogQuery;
import com.hundsun.jresplus.quickstart.biz.service.PrepayLogService;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumPrepayType;

@Controller
@RequestMapping(value = "/center/fund")
public class PrepayLogAction {

    @Autowired
    private PrepayLogService prepayLogService;

    @RequestMapping(value = "/prepayLogList")
    public String orderList(UserAgent user, @ModelAttribute("query") PrepayLogQuery query,
                            Model model) {

        query.setUserId(user.getId());
        prepayLogService.getPagination(query);
        model.addAttribute("prepayTypeMap", EnumPrepayType.toMap());
        model.addAttribute("prepayTypeList", EnumPrepayType.toList());
        return "center/fund/prepayLogList";
    }
}
