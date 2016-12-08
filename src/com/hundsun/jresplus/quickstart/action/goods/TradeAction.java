package com.hundsun.jresplus.quickstart.action.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hundsun.jresplus.quickstart.action.BaseAction;
import com.hundsun.jresplus.quickstart.biz.bo.TradeCart;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.po.Orderinfo;
import com.hundsun.jresplus.quickstart.biz.po.Orderitem;
import com.hundsun.jresplus.quickstart.biz.po.PrepayLog;
import com.hundsun.jresplus.quickstart.biz.po.User;
import com.hundsun.jresplus.quickstart.biz.service.CategoryService;
import com.hundsun.jresplus.quickstart.biz.service.GoodsService;
import com.hundsun.jresplus.quickstart.biz.service.OrderinfoService;
import com.hundsun.jresplus.quickstart.biz.service.OrderitemService;
import com.hundsun.jresplus.quickstart.biz.service.PrepayLogService;
import com.hundsun.jresplus.quickstart.biz.service.SequenceService;
import com.hundsun.jresplus.quickstart.biz.service.UserService;
import com.hundsun.jresplus.quickstart.common.CommonDefine;
import com.hundsun.jresplus.quickstart.common.UserAgent;

@Controller
public class TradeAction extends BaseAction {

    @Autowired
    private GoodsService     goodsService;
    @Autowired
    private OrderitemService orderitemService;
    @Autowired
    private OrderinfoService orderinfoService;
    @Autowired
    private CategoryService  categoryService;
    @Autowired
    private SequenceService  sequenceService;
    @Autowired
    private UserService      userService;
    @Autowired
    private PrepayLogService prepaylogService;

    /**
     * 加入购物车时商品数量验证
     * @param goodsId
     * @param model
     * @param user
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/checkGoodsNum")
    public String checkGoodsNum(@RequestParam(value = "goodsId") Long goodsId, ModelMap model,
                                UserAgent user, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/xml;charset=UTF-8");
        // 得到商品
        Goods goodsEditModel = goodsService.getById(goodsId);
        // 状态
        String status = goodsEditModel.getStatus();
        Boolean isUndercarriaged = false;
        if ("3".equals(status)) {
            isUndercarriaged = true;
        }
        // 库存
        Long stocknum = goodsEditModel.getStocknum();
        // 订购数
        Long ordernum = goodsEditModel.getOrdernum();
        // 库存-订购数
        Long remainnum = (stocknum == null || ordernum == null) ? 0 : (stocknum - ordernum);
        // 购物车中的数量
        Integer cartnum = 0;
        List<Orderitem> cartlist = new ArrayList<Orderitem>();
        if (user.getTradeCart() != null) {
            TradeCart cart = (TradeCart) user.getTradeCart();
            cartlist = cart.toOrderList();
        }
        for (int i = 0; i < cartlist.size(); i++) {
            Orderitem orderitem = cartlist.get(i);
            if (orderitem.getGoods_id().equals(goodsId)) {
                cartnum = orderitem.getItemnum();
                break;
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append("<goodsNum>");
        sb.append("<remainnum ");
        sb.append("value='");
        sb.append(remainnum.toString());
        sb.append("' />");
        sb.append("<cartnum ");
        sb.append("value='");
        sb.append(cartnum.toString());
        sb.append("' />");
        sb.append("<isUndercarriaged ");
        sb.append("value='");
        sb.append(isUndercarriaged.toString());
        sb.append("' />");
        sb.append("</goodsNum>");
        out.write(sb.toString());
        return null;

    }

    /**
     * 订单商品确认
     * @param goodsId
     * @param unitprice
     * @param itemnum
     * @param type
     * @param model
     * @param user
     * @param tradeCart
     * @param request
     * @return
     */
    @RequestMapping(value = "/b2cShopcart")
    public @ResponseBody String b2cShopcart(@RequestParam(value = "goods_id") Long goodsId,
                                            @RequestParam(value = "unitprice") Double unitprice,
                                            @RequestParam(value = "itemnum") Integer itemnum,
                                            @RequestParam(value = "type", required = false) String type,
                                            ModelMap model, UserAgent user, TradeCart tradeCart,
                                            HttpServletRequest request) {
        if (tradeCart == null) {
            tradeCart = new TradeCart();
        }
        if ("clear".equals(type)) { // 清空购物车
            tradeCart.setGoodskinds(0);
            tradeCart.setItemcount(0);
            tradeCart.setShopcart("");
            user.setTradeCart(tradeCart);
        }

        List cartlist = new ArrayList();
        Integer cartcount = 0;
        if (tradeCart != null && tradeCart.getShopcart() != null) {
            cartlist = tradeCart.toOrderList();
        }
        if (tradeCart != null && tradeCart.getItemcount() != null) {
            cartcount = tradeCart.getItemcount();
        }

        if (goodsId != null && !"".equals(goodsId) && goodsId > 0 && itemnum != null
            && !"".equals(itemnum) && itemnum >= 0 && unitprice != null && !"".equals(unitprice)
            && unitprice >= 0) {
            if ("update".equals(type)) { // 修改购物车中的商品数量
                int i;
                for (i = 0; i < cartlist.size(); i++) {
                    Orderitem orderitem = (Orderitem) cartlist.get(i);
                    if (orderitem.getGoods_id().equals(goodsId)) { // 找到了该商品在购物车原有LIST中的记录
                        cartcount = cartcount + (itemnum - orderitem.getItemnum());
                        if (itemnum > 0) {
                            orderitem.setItemnum(itemnum);
                            orderitem.setItemsum(itemnum * unitprice);
                            cartlist.set(i, orderitem);
                        } else { // 数量为0，表示删除此商品
                            cartlist.remove(i);
                        }

                        break;
                    }
                }
                tradeCart.setOrderList(cartlist);
                tradeCart.setItemcount(cartcount);
                tradeCart.setGoodskinds(cartlist.size());
                user.setTradeCart(tradeCart);
            } else { // 购买
                if (itemnum.equals(0)) { // 点购买按钮，数量为0时不做任何处理
                    return null;
                }

                boolean isnewitem = true;
                for (int i = 0; i < cartlist.size(); i++) {
                    Orderitem orderitem = (Orderitem) cartlist.get(i);
                    if (orderitem.getGoods_id().equals(goodsId)) { // 所选商品在购物车原有LIST中已存在
                        orderitem.setItemnum(orderitem.getItemnum() + itemnum);
                        orderitem.setItemsum(orderitem.getItemsum() + itemnum * unitprice);
                        cartlist.set(i, orderitem);

                        isnewitem = false; // 不需要在原有LIST中增加新的ITEM
                        break;
                    }
                }

                if (isnewitem) { // 新增购物车原有LIST中没有的商品
                    Orderitem newitem = new Orderitem();
                    // newitem.setItemno(cartlist.size()+1);
                    newitem.setGoods_id(goodsId);

                    Goods goods = (Goods) goodsService.getById(newitem.getGoods_id());
                    newitem.setGoods_name(goods.getName());
                    newitem.setPrivatecode(goods.getPrivatecode());
                    newitem.setItemnum(itemnum);
                    newitem.setUnit(goods.getUnit());
                    newitem.setUnitprice(unitprice);
                    newitem.setItemsum(newitem.getItemnum() * newitem.getUnitprice());
                    // add by chengy 20130518 加商品供应商id
                    newitem.setProvider_id(goods.getProviderId());
                    if (goods.getIsoutofstock() != null && goods.getIsoutofstock() == 1) {
                        newitem.setIsoutofstock(true);
                    } else {
                        newitem.setIsoutofstock(false);
                    }

                    cartlist.add(newitem);
                }

                tradeCart.setOrderList(cartlist);
                cartcount = cartcount + itemnum;
                tradeCart.setItemcount(cartcount);
                tradeCart.setGoodskinds(cartlist.size());
                user.setTradeCart(tradeCart);
            }

            return null;
        }

        model.addAttribute("shopcart", cartlist);
        model.addAttribute("itemcount", cartcount);

        List topcats = categoryService.getTopCategorys(getQueryBuilding(user, request));
        model.addAttribute("searchcategorys", topcats);
        model.addAttribute("rec_categorys", topcats);

        return "success";
    }

    /**
     * 订单提交
     * @param orderinfoEditModel
     * @param model
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/myOrderinfoSave")
    public String myOrderinfoSave(@ModelAttribute("order") Orderinfo orderinfoEditModel,
                                  ModelMap model, UserAgent user, HttpServletRequest request) {
        TradeCart tradeCart = user.getTradeCart();
        List<Orderitem> cartlist = tradeCart.toOrderList();

        try {
            // add by chengy 检查当前订单是否库存不足
            StringBuffer message = new StringBuffer();
            for (Orderitem orderItem : cartlist) {
                isInShortSupply(orderItem, message);
            }
            if (message.length() > 0) {
                orderinfoEditModel.setMsg(message.toString());
                return "error";
            }

            Date now = new Date();
            orderinfoEditModel.setOrdertime(now);

            Format format = new SimpleDateFormat("yyyyMMdd");
            String ordno = format.format(now);
            Integer seqno = sequenceService.genValidSeqno("orderinfo");
            ordno = ordno + String.format("%06d", seqno);
            orderinfoEditModel.setOrderno(ordno);

            orderinfoEditModel.setUser_id(user.getId());
            orderinfoEditModel.setUsername(user.getUserName());
            if (orderinfoEditModel.getSplitorder() == CommonDefine.ORDERINFO_SPLITORDER_YES) { // 拆分订单
                orderinfoEditModel.setItemcount(cartlist.size()
                                                - orderinfoEditModel.getOutgoodsnum());
                orderinfoEditModel.setGoodssum(orderinfoEditModel.getGoodssum()
                                               - orderinfoEditModel.getOutgoodssum());
                orderinfoEditModel.setTotalsum(orderinfoEditModel.getTotalsum()
                                               - orderinfoEditModel.getOutgoodssum());
            } else {
                orderinfoEditModel.setItemcount(cartlist.size());
            }

            if (orderinfoEditModel.getSplitorder() == CommonDefine.ORDERINFO_SPLITORDER_NO) { // 用户选择不拆分的缺货订单状态设置
                orderinfoEditModel.setStatus(CommonDefine.ORDERINFO_STATUS_PARTOUT); // 部分缺货订单
            } else { // 无缺货订单或用户选择拆分的主订单状态设置,此两类都是正常订单
                switch (orderinfoEditModel.getPaymenttype_id()) {
                    case CommonDefine.ORDERPAYTYPE_COD: // 货到付款
                        orderinfoEditModel.setStatus(CommonDefine.ORDERINFO_STATUS_NOPAY_SENDING);
                        break;
                    case CommonDefine.ORDERPAYTYPE_PREPAY: // 预存款支付
                        User userResult = userService.getUserByID(orderinfoEditModel.getUser_id());
                        if (userResult.getPrepay() < orderinfoEditModel.getTotalsum()) { // 预存款金额小于订单总额
                            orderinfoEditModel.setPaymenttype_id(CommonDefine.ORDERPAYTYPE_COD); // 转为货到付款
                            orderinfoEditModel
                                .setStatus(CommonDefine.ORDERINFO_STATUS_NOPAY_SENDING);
                        } else {
                            userService.updatePrepayById(userResult.getId(),
                                -orderinfoEditModel.getTotalsum()); // 扣除预存款
                            orderinfoEditModel.setPaymenttime(now); // 设置支付时间
                            orderinfoEditModel
                                .setStatus(CommonDefine.ORDERINFO_STATUS_PAYED_SENDING);
                        }
                        break;
                    case CommonDefine.ORDERPAYTYPE_MONTHPAY: // 月结
                        orderinfoEditModel.setStatus(CommonDefine.ORDERINFO_STATUS_NOPAY_SENDING);
                        break;
                    default:
                        orderinfoEditModel.setStatus(CommonDefine.ORDERINFO_STATUS_NEW);
                }
            }
            orderinfoEditModel.setUsername(user.getUserName());
            orderinfoEditModel.setUser_id(user.getId());
            Long ordid = orderinfoService.addOrderinfo(orderinfoEditModel); // 添加新订单
            // 预存款支付的订单，添加预存款交易记录
            if (orderinfoEditModel.getPaymenttype_id() == CommonDefine.ORDERPAYTYPE_PREPAY) {
                PrepayLog prepaylog = new PrepayLog();
                prepaylog.setUser_id(orderinfoEditModel.getUser_id());
                prepaylog.setPaysum(-orderinfoEditModel.getTotalsum());
                prepaylog.setPaytype(CommonDefine.PREPAYLOG_TYPE_PAYMENT);
                prepaylog.setCreator(orderinfoEditModel.getUser_id());
                prepaylog.setCreatetime(now);
                prepaylog.setPaytime(now);
                prepaylog.setOrderinfo_id(ordid);
                prepaylogService.addPrepayLog(prepaylog);
            }

            Long ordid2 = 0L;
            // 拆分订单的缺货订单（副订单）处理
            if (orderinfoEditModel.getSplitorder() == CommonDefine.ORDERINFO_SPLITORDER_YES) {
                orderinfoEditModel.setOrderno(orderinfoEditModel.getOrderno() + "-1");
                orderinfoEditModel.setItemcount(orderinfoEditModel.getOutgoodsnum());
                orderinfoEditModel.setGoodssum(orderinfoEditModel.getOutgoodssum());
                orderinfoEditModel.setTotalsum(orderinfoEditModel.getOutgoodssum());
                orderinfoEditModel.setStatus(CommonDefine.ORDERINFO_STATUS_ALLOUT); // 完全缺货订单，即缺货订单拆分后的副订单
                ordid2 = orderinfoService.addOrderinfo(orderinfoEditModel);
            }

            // 添加订单明细资料
            for (int i = 0; i < cartlist.size(); i++) {
                Orderitem item = (Orderitem) cartlist.get(i);
                Goods goods = (Goods) goodsService.getById(item.getGoods_id());
                item.setGoods_name(goods.getName());
                item.setPrivatecode(goods.getPrivatecode());
                item.setUnit(goods.getUnit());
                item.setUser_id(orderinfoEditModel.getUser_id());
                if (orderinfoEditModel.getSplitorder() == CommonDefine.ORDERINFO_SPLITORDER_YES
                    && item.getIsoutofstock()) { // 拆分订单且为缺货项时该项应加入副订单
                    item.setOrderinfo_id(ordid2);
                } else {
                    item.setOrderinfo_id(ordid);
                }
                if (item.getIsoutofstock()) { // 缺货商品itemno置为0
                    item.setItemno(CommonDefine.ORDERITEM_ITEMNO_NONE);
                } else { // 现货商品itemno置为1
                    item.setItemno(CommonDefine.ORDERITEM_ITEMNO_HAVE);
                }

                orderitemService.addOrderitem(item);
                // 更新商品订购量
                goodsService.increaseSpecificNumById(item.getGoods_id(), "ordernum",
                    item.getItemnum());/*
                                       // 发送邮件至后台工作人员
                                       doEmailMsgTask(orderinfoEditModel);*/
            }

            // 删除Cookie中的购物车信息
            TradeCart tradeCartNew = new TradeCart();
            user.setTradeCart(tradeCartNew);

            orderinfoEditModel.setId(ordid); // 重新置回主订单ID，否则成功页面查看订单链接的是副订单
            if (orderinfoEditModel.getPaymenttype_id().equals(CommonDefine.ORDERPAYTYPE_PAYONLINE)) { // 网上支付需要跳转到支付页面
                return "success";
            }

            return "success";
        } catch (DataAccessException dae) {
            orderinfoEditModel.setMsg("DataAccessException:" + dae);
        } catch (Exception e) {
            orderinfoEditModel.setMsg("Exception:" + e);
        }

        return "error";
    }

    @RequestMapping(value = "/checkDuplicateOrder")
    @SuppressWarnings("unchecked")
    public @ResponseBody String checkDuplicateOrder(ModelMap model, UserAgent user,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) throws Exception {
        Long userId = user.getId();
        if (userId == null) {
            return "error";
        }
        TradeCart tradeCart = user.getTradeCart();
        PrintWriter out = response.getWriter();
        response.setContentType("text/xml;charset=UTF-8");
        // 得到当前用户今天所有的订单
        Map<String, Object> params = new HashMap();
        params.put("user_id", userId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(new Date());
        params.put("start_ordertime", today);
        List<Orderinfo> orderinfos = orderinfoService.searchOrderinfo(params, true);
        // 得到当前订单信息
        List<Orderitem> cartlist = tradeCart.toOrderList();
        // 检查原有重复订单数量
        Integer count = 0;
        if (cartlist != null && !cartlist.isEmpty()) {
            for (Orderinfo orderinfo : orderinfos) {
                if (isEqualOrderinfo(orderinfo, cartlist)) {
                    count++;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append("<duplicateOrder>");
        sb.append("<count ");
        sb.append("value='");
        sb.append(count.toString());
        sb.append("' />");
        sb.append("</duplicateOrder>");
        out.write(sb.toString());
        return "";
    }

    private void isInShortSupply(Orderitem orderItem, StringBuffer message) {
        Long goodsId = orderItem.getGoods_id();
        // 得到商品
        Goods goodsEditModel = goodsService.getById(goodsId);
        // 状态
        String status = goodsEditModel.getStatus();
        if ("3".equals(status)) {
            message.append("商品" + goodsEditModel.getName() + "已下架，请刪除该商品后再继续提交订单。</br>");

        }
        // 库存
        Long stocknum = goodsEditModel.getStocknum();
        // 订购数
        Long ordernum = goodsEditModel.getOrdernum();
        // 库存-订购数
        Long remainnum = (stocknum == null || ordernum == null) ? 0 : (stocknum - ordernum);
        // 购物车中的数量
        Integer cartnum = orderItem.getItemnum();
        if (remainnum.intValue() < cartnum.intValue()) {
            message.append("商品" + goodsEditModel.getName() + "当前库存仅剩" + remainnum
                           + "件，请减少订购数量后再继续提交订单。</br>");
        }
    }

    /**
     * 检查订单是否重复.
     * 
     * @param orderinfo
     *            原有订单
     * @param orderinfoEditModels
     *            当前购物车的订单
     * @return 是否重复
     */
    @SuppressWarnings("unchecked")
    private boolean isEqualOrderinfo(Orderinfo orderinfo, List<Orderitem> orderinfoEditModels) {
        int size = orderinfo.getItemcount();
        int sizeModel = orderinfoEditModels.size();
        if (size != sizeModel) {
            return false;
        }
        List<Orderitem> orderItems = orderinfo.getOrderItems();
        ComparatorOrderinfo comparator = new ComparatorOrderinfo();
        Collections.sort(orderinfoEditModels, comparator);
        for (int i = 0; i < orderItems.size(); i++) {
            if (!isEqualOrderitem(orderItems.get(i), orderinfoEditModels.get(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean isEqualOrderitem(Orderitem orderitem, Orderitem orderitemEditModel) {
        Long goodsId = orderitem.getGoods_id();
        Long goodsId2 = orderitemEditModel.getGoods_id();
        Integer itemNum = orderitem.getItemnum();
        Integer itemNum2 = orderitemEditModel.getItemnum();
        if (goodsId.equals(goodsId2) && itemNum.equals(itemNum2)) {
            return true;
        } else {
            return false;
        }
    }

    public class ComparatorOrderinfo implements Comparator {

        public int compare(Object arg0, Object arg1) {
            Orderitem model = (Orderitem) arg0;
            Orderitem model2 = (Orderitem) arg1;
            return model.getGoods_id().compareTo(model2.getGoods_id());
        }

    }
}
