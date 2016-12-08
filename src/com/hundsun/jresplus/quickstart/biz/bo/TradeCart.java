package com.hundsun.jresplus.quickstart.biz.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.jresplus.quickstart.biz.po.BaseDomain;
import com.hundsun.jresplus.quickstart.biz.po.Orderinfo;
import com.hundsun.jresplus.quickstart.biz.po.Orderitem;

public class TradeCart extends BaseDomain {

    /**
     * UID
     */
    private static final long  serialVersionUID = -8106919894998860797L;

    /**
     * 购物车
     * 每个商品：<商品id>:<单价>:<数量>
     * 多个商品之间逗号“,”分隔
     */
    private String             shopcart;

    /**
     * 商品数量
     */
    private Integer            itemcount        = 0;

    /**
     * 商品种类数量 
     */
    private Integer            goodskinds       = 0;

    /**
     * 结算信息
     */
    private Orderinfo          orderInfo;

    /**
     * 商品明细<商品id,商品数量>
     */
    private Map<Long, Integer> cartDetail       = new TreeMap<Long, Integer>();

    public TradeCart() {
        super();
    }

    public TradeCart(Map<Long, Integer> cartDetail) {
        this.cartDetail = cartDetail;
    }

    public void add2Cart(Long goodsId, Integer goodsNumAdd) {
        if (cartDetail.containsKey(goodsId)) {
            Integer goodsNumNew = cartDetail.get(goodsId) + goodsNumAdd;
            cartDetail.put(goodsId, goodsNumNew);
        } else {
            cartDetail.put(goodsId, goodsNumAdd);
            goodskinds++;
        }
        itemcount += goodsNumAdd;
    }

    public void deleteByGoodsId(Long goodsId) {
        if (this.cartDetail.containsKey(goodsId)) {
            Integer currentNum = cartDetail.get(goodsId);
            this.cartDetail.remove(goodsId);
            goodskinds--;
            itemcount -= currentNum;
        }
    }

    public void deleteByGoodsId(Long goodsId, Integer goodsNumDelete) {
        if (this.cartDetail.containsKey(goodsId)) {
            Integer currentNum = cartDetail.get(goodsId);
            if (goodsNumDelete >= currentNum) {
                this.cartDetail.remove(goodsId);
                goodskinds--;
                itemcount -= currentNum;
            } else {
                this.cartDetail.put(goodsId, currentNum - goodsNumDelete);
                itemcount -= goodsNumDelete;
            }
        }
    }

    public void clearCart() {
        this.orderInfo = null;
        this.cartDetail = new TreeMap<Long, Integer>();
        this.itemcount = 0;
        this.goodskinds = 0;
    }

    public Map<Long, Integer> getCartDetail() {
        return cartDetail;
    }

    public void setCartDetail(Map<Long, Integer> cartDetail) {
        this.cartDetail = cartDetail;
    }

    public String getShopcart() {
        return shopcart;
    }

    public void setShopcart(String shopcart) {
        this.shopcart = shopcart;
    }

    public Integer getItemcount() {
        return itemcount;
    }

    public void setItemcount(Integer itemcount) {
        this.itemcount = itemcount;
    }

    public Integer getGoodskinds() {
        return goodskinds;
    }

    public void setGoodskinds(Integer goodskinds) {
        this.goodskinds = goodskinds;
    }

    public Orderinfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Orderinfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<Orderitem> toOrderList() {
        List<Orderitem> orderList = new ArrayList<Orderitem>();
        if (StringUtil.isNotBlank(shopcart)) {
            String[] orderStrArray = shopcart.split(",");
            for (String orderStr : orderStrArray) {
                String[] orderSlide = orderStr.split(":");
                Orderitem order = new Orderitem();
                order.setGoods_id(Long.parseLong(orderSlide[0]));
                order
                    .setUnitprice(Double.valueOf(orderSlide[1] == null || "".equals(orderSlide[1]) ? "0"
                        : orderSlide[1]));
                order.setItemnum(Integer.valueOf(orderSlide[2]));
                order.setItemsum(Double.valueOf(orderSlide[3]));
                orderList.add(order);
            }
        }
        return orderList;
    }

    public void setOrderList(List<Orderitem> orderList) {
        StringBuilder orderStrBuilder = new StringBuilder();
        String orderStr = "";
        if (orderList != null && !orderList.isEmpty()) {
            for (Orderitem order : orderList) {
                orderStrBuilder.append(order.getGoods_id());
                orderStrBuilder.append(":");
                orderStrBuilder.append(order.getUnitprice());
                orderStrBuilder.append(":");
                orderStrBuilder.append(order.getItemnum());
                orderStrBuilder.append(":");
                orderStrBuilder.append(order.getItemsum());
                orderStrBuilder.append(",");
            }
            orderStr = orderStrBuilder.substring(0, orderStrBuilder.length() - 1);
        }
        if (orderStr.length() > 0) {
            this.shopcart = orderStr;
        }
    }
}
