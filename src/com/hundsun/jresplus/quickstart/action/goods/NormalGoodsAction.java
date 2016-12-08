package com.hundsun.jresplus.quickstart.action.goods;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.jresplus.quickstart.biz.po.Category;
import com.hundsun.jresplus.quickstart.biz.po.GoodsCollect;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.query.CommentQuery;
import com.hundsun.jresplus.quickstart.biz.query.NormalGoodsQuery;
import com.hundsun.jresplus.quickstart.biz.service.CategoryService;
import com.hundsun.jresplus.quickstart.biz.service.CommentService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.biz.service.LikeService;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;

@Controller
public class NormalGoodsAction {

    private String          val;

    @Autowired
    private GoodsService    goodsService;

    @Autowired
    private CommentService  commentService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LikeService     likeService;

    @RequestMapping(value = "/goods/normal/list")
    public String showCurrentPoll(@ModelAttribute("query") NormalGoodsQuery query, Model model,
                                  UserAgent user) {
        query.addType(EnumGoodsType.NORMAL.getCode());
        query.addType(EnumGoodsType.SALE.getCode());
        query.setPageSize(12);
        Long categoryId = query.getCategoryId();
        String name = query.getName();
        // 如果有name字段填写就清空类目
        if (StringUtil.isNotBlank(name)) {
            categoryId = null;
            query.setCategoryId(categoryId);
        }
        Long buildingId = 0L;
        if (user != null) {
            buildingId = user.getBuildingId();
        }
        query.setBuildingId(buildingId);
        goodsService.getPagination(query, model);
        List<Category> categoryList = categoryService.getListByBuildingId(buildingId);
        model.addAttribute("categoryList", categoryList);
        Category categoryCurrent = categoryService
            .getCategoryByIdWithParent(categoryId == null ? 0L : categoryId);
        model.addAttribute("categoryCurrent", categoryCurrent);
        return "/goods/normal/list";
    }

    @RequestMapping(value = "/goods/normal/detail")
    public String showView(@RequestParam(value = "id") Long id,
                           @ModelAttribute("query") CommentQuery query,
                           @ModelAttribute("goodsQuery") NormalGoodsQuery goodsQuery, Model model) {

        query.setGoodsId(id);
        commentService.getPagination(query, model);

        Goods goods = goodsService.getById(id);
        // view num +1
        likeService.addViewNum(goods);
        // +1 finish

        model.addAttribute("goods", goods);

        return "/goods/normal/detail";
    }
    
    
    @RequestMapping(value = "/goods/normal/detailStock")
    public String showView2(@RequestParam(value = "id") Long id,
                           @ModelAttribute("query") CommentQuery query,
                           @ModelAttribute("goodsQuery") NormalGoodsQuery goodsQuery, Model model) {

        query.setGoodsId(id);
        commentService.getPagination(query, model);

        Goods goods = goodsService.getById(id);
        // view num +1
        likeService.addViewNum(goods);
        // +1 finish

        model.addAttribute("goods", goods);

        return "/goods/normal/detailStock";
    }

    @RequestMapping(value = "/goods/normal/create", method = RequestMethod.POST)
    public String create(HttpServletRequest request, @ModelAttribute Goods goods,
                         @RequestParam(value = "goodsid") Long goodsid,

                         @ModelAttribute("query") CommentQuery query, Model model) {
        System.out.println("---------------------------ajax");
        System.out.println(goodsid);
        System.out.println("this is add comment method !!");

        // SimpleDateFormat df = new
        // SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();

        // goods.setId(goodsid);
        //Long flag = goodsService.getCollect(goods.getId(),goodsid);
        GoodsCollect collection = (GoodsCollect) goodsService.getCollectionById(goodsid);
        if (collection == null) {
            val = "fail";
        } else {
            goodsService.create(goodsid);
            val = "success";
        }
        model.addAttribute("val", val);

        return "/goods/normal/result";
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
    
    @RequestMapping(value = "/goods/normal/iframeList")
    public String getIframeList(@ModelAttribute("query") NormalGoodsQuery query, Model model,
                                  UserAgent user) {
        query.addType(EnumGoodsType.NORMAL.getCode());
        query.addType(EnumGoodsType.SALE.getCode());
        query.setPageSize(4);
        Long categoryId = query.getCategoryId();
        String name = query.getName();
        // 如果有name字段填写就清空类目
        if (StringUtil.isNotBlank(name)) {
            categoryId = null;
            query.setCategoryId(categoryId);
        }
        Long buildingId = 0L;
        if (user != null) {
            buildingId = user.getBuildingId();
        }
        query.setBuildingId(buildingId);
        goodsService.getPagination(query, model);
        List<Category> categoryList = categoryService.getListByBuildingId(buildingId);
        model.addAttribute("categoryList", categoryList);
        Category categoryCurrent = categoryService
            .getCategoryByIdWithParent(categoryId == null ? 0L : categoryId);
        model.addAttribute("categoryCurrent", categoryCurrent);
        return "/goods/sale/iframeList";
    }
    
}
