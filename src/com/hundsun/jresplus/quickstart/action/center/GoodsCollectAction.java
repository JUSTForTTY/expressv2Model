package com.hundsun.jresplus.quickstart.action.center;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hundsun.jresplus.quickstart.biz.bo.Result;
import com.hundsun.jresplus.quickstart.biz.query.GoodsCollectQuery;
import com.hundsun.jresplus.quickstart.biz.service.CommonService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsCollectService;
import com.hundsun.jresplus.quickstart.common.UserAgent;

/**
 * 收藏
 * @author chengy
 * @version $Id: GoodsCollectAction.java,v 0.1 2015年5月27日 上午7:02:20 chengy Exp $
 */
@Controller
@RequestMapping(value = "/center/collect")
public class GoodsCollectAction {

    @Autowired
    private GoodsCollectService goodsCollectService;

    @Autowired
    private CommonService       commonService;

    /**
     * 添加
     * @param user
     * @param goodsId
     * @param type
     * @return
     */
    @RequestMapping(value = "/add")
    public @ResponseBody String addCollect(UserAgent user, @RequestParam("goodsId") Long goodsId,
                                           @RequestParam("type") String type) {
        Result result = goodsCollectService.addCollect(user, goodsId, type);
        return commonService.toJson(result);
    }

    /**
     * 删除
     * @param user
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    public String deleteCollect(UserAgent user, @RequestParam("id") Long id, Model model) {
        Result result = goodsCollectService.deleteCollect(user, id);
        if (!result.isSuccess()) {
            model.addAttribute("message", result.getMessage());
            model.addAttribute("url", "center/collect/list.htm");
            return "center/error";
        } else {
            model.addAttribute("url", "center/collect/list.htm");
            return "center/success";
        }
    }

    /**
     * 列表
     * @param user
     * @param query
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String orderList(UserAgent user, @ModelAttribute("query") GoodsCollectQuery query,
                            Model model) {
        query.setUserName(user.getUserName());
        query.setType("normal");
        goodsCollectService.getPagination(query);
        return "center/collect/list";
    }
    @RequestMapping(value = "/providerList")
    public String orderList2(UserAgent user, @ModelAttribute("query") GoodsCollectQuery query,
                            Model model) {
        query.setUserName(user.getUserName());
        query.setType("provider");
        goodsCollectService.getPagination(query);
        return "center/collect/providerList";
    }
}
