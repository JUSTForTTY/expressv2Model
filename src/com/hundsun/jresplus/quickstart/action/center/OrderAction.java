package com.hundsun.jresplus.quickstart.action.center;

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

import com.hundsun.jresplus.quickstart.biz.po.Comment;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.jresplus.quickstart.biz.po.Orderinfo;
import com.hundsun.jresplus.quickstart.biz.po.Orderitem;
import com.hundsun.jresplus.quickstart.biz.query.OrderInfoQuery;
import com.hundsun.jresplus.quickstart.biz.service.CommentService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.biz.service.OrderService;
import com.hundsun.jresplus.quickstart.biz.service.OrderinfoService;
import com.hundsun.jresplus.quickstart.biz.service.OrderitemService;
import com.hundsun.jresplus.quickstart.biz.service.UserService;
import com.hundsun.jresplus.quickstart.common.CommonDefine;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumCommentStatus;
import com.hundsun.jresplus.quickstart.enums.EnumOrderInfoStatus;
import com.hundsun.jresplus.quickstart.enums.EnumOrderItemStatus;
import com.hundsun.jresplus.quickstart.enums.EnumPayType;

@Controller
@RequestMapping(value = "/center/order")
public class OrderAction {

    @Autowired
    OrderinfoService orderinfoService;
    @Autowired
    OrderitemService orderitemService;
    @Autowired
    CommentService   commentService;
    @Autowired
    GoodsService     goodsService;
    @Autowired
    UserService      userService;

    @RequestMapping(value = "/list")
    public String orderList(UserAgent user, HttpSession session, HttpServletRequest request,
                            @ModelAttribute("query") OrderInfoQuery query, Model model) {

        query.setUsername(user.getUserName());
        orderinfoService.getPagination(query);
        model.addAttribute("payTypeMap", EnumPayType.toMap());
        model.addAttribute("orderInfoStatusMap", EnumOrderInfoStatus.toMap());
        return "center/order/list";
    } 
    
    
    

    @RequestMapping(value = "/detail")
    public String showView(UserAgent user,@ModelAttribute("query") OrderInfoQuery query, @RequestParam(value = "id") Long id, Model model) {
        List<OrderDetail> OrderDetail = orderinfoService.getDetailByIdUserId(id, user.getId());
        model.addAttribute("orderDetail", OrderDetail);
        query.setUsername(user.getUserName());
        query.setOrderno(id.toString());
        orderinfoService.getPagination(query);
        model.addAttribute("payTypeMap", EnumPayType.toMap());
        model.addAttribute("orderInfoMap", EnumOrderInfoStatus.toMap());
        model.addAttribute("orderItemStatusMap", EnumOrderItemStatus.toMap());
        return "/center/order/detail";
    }

    @RequestMapping(value = "/receive")
    public String receive(UserAgent user, @RequestParam(value = "itemId") Long itemId, Model model) {
        Long orderInfoId = orderitemService.receive(itemId, user.getId());
        return "redirect:/center/order/detail.htm?id=" + orderInfoId;
    }

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public String commentInit(UserAgent user,@ModelAttribute("query") OrderInfoQuery query, @RequestParam(value = "itemId") Long itemId,
                              Model model) {
        if (user == null || user.getId() == null) {
            return "error";
        }
        OrderDetail orderDetail = orderitemService.getOrderitemById(itemId);
       
        query.setOrderno(orderDetail.getOrderId().toString());
        orderinfoService.getPagination(query);
       
         
//        if (!user.getId().equals(orderItem.getUser_id())) {
//            return "error";
//        }
        model.addAttribute("item", orderDetail);
        Goods goods = goodsService.getById(orderDetail.getGoodsId());
        model.addAttribute("goods", goods);
        return "/center/order/comment";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String comment(UserAgent user, @RequestParam(value = "itemId") Long itemId,
                          @ModelAttribute(value = "comment") Comment comment, Model model,
                          HttpSession session) {
        OrderDetail orderDetail = orderitemService.getOrderitemById(itemId);
//        if (!user.getId().equals(orderDetail.get)) {
//            return "error";
//        }
        
        
        comment.setGoodsId(orderDetail.getGoodsId());
        comment.setUsername(user.getUserName());
        comment.setStatus(EnumCommentStatus.INIT.getCode());
        commentService.insert(comment);
        orderitemService.updateStatusById(itemId, EnumOrderItemStatus.COMMENTED.getCode());
        model.addAttribute("message", "添加评论成功！");
        model.addAttribute("url", "center/order/detail.htm?id=" + orderDetail.getOrderId());
        
        
        //如果支付类型为云库存取货，则不加积分
        
        // 获得积分
        Goods goods = goodsService.getById(orderDetail.getGoodsId());
        Integer scoreAddUnit = goods.getScoreAdd();
        Integer scoreAdd = orderDetail.getGoodsCount() * scoreAddUnit;
        Long scoreNew = user.getScore() + scoreAdd;
        user.setScore(scoreNew);
        session.setAttribute(UserAgent.AGENT, user);
        userService.updateScoreById(user.getId(), -scoreAdd);
        return "center/success";
    }
    
    
    
    @RequestMapping(value = "/oldlist")
    public String oldorderList(UserAgent user, HttpSession session, HttpServletRequest request,
                            @ModelAttribute("query") OrderInfoQuery query, Model model) {

        query.setUsername(user.getUserName());
        orderinfoService.getOldPagination(query);
        model.addAttribute("payTypeMap", EnumPayType.toMap());
        model.addAttribute("orderInfoStatusMap", EnumOrderInfoStatus.toMap());
        return "center/oldorder/list";
    }

    @RequestMapping(value = "/olddetail")
    public String showoldView(UserAgent user, @RequestParam(value = "id") Long id, Model model) {
        Orderinfo orderInfo = orderinfoService.getOldDetailByIdUserId(id, user.getId());
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("payTypeMap", EnumPayType.toMap());
        model.addAttribute("orderItemStatusMap", EnumOrderItemStatus.toMap());
        return "/center/oldorder/detail";
    }

     

    @RequestMapping(value = "/oldcomment", method = RequestMethod.GET)
    public String commentoldInit(UserAgent user, @RequestParam(value = "itemId") Long itemId,
                              Model model) {
        if (user == null || user.getId() == null) {
            return "error";
        }
        Orderitem orderItem = orderitemService.getOldOrderitemById(itemId);
        if (!user.getId().equals(orderItem.getUser_id())) {
            return "error";
        }
        model.addAttribute("item", orderItem);
        Goods goods = goodsService.getById(orderItem.getGoods_id());
        model.addAttribute("goods", goods);
        return "/center/oldorder/comment";
    }

    @RequestMapping(value = "/oldcomment", method = RequestMethod.POST)
    public String oldcomment(UserAgent user, @RequestParam(value = "itemId") Long itemId,
                          @ModelAttribute(value = "comment") Comment comment, Model model,
                          HttpSession session) {
        Orderitem orderItem = orderitemService.getOldOrderitemById(itemId);
        if (!user.getId().equals(orderItem.getUser_id())) {
            return "error";
        }
        comment.setGoodsId(orderItem.getGoods_id());
        comment.setUsername(user.getUserName());
        comment.setStatus(EnumCommentStatus.INIT.getCode());
        commentService.insert(comment);
        orderitemService.updateStatusById(itemId, EnumOrderItemStatus.COMMENTED.getCode());
        model.addAttribute("message", "添加评论成功！");
        model.addAttribute("url", "center/order/detail.htm?id=" + orderItem.getOrderinfo_id());
        // 获得积分
        Goods goods = goodsService.getById(orderItem.getGoods_id());
        Integer scoreAddUnit = goods.getScoreAdd();
        Integer scoreAdd = orderItem.getItemnum() * scoreAddUnit;
        Long scoreNew = user.getScore() + scoreAdd;
        user.setScore(scoreNew);
        session.setAttribute(UserAgent.AGENT, user);
        userService.updateScoreById(user.getId(), -scoreAdd);
        return "center/success";
    }
}
