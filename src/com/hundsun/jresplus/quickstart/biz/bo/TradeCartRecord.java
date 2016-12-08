package com.hundsun.jresplus.quickstart.biz.bo;

import com.hundsun.jresplus.quickstart.biz.po.Goods;

public class TradeCartRecord {

    private Goods   goods;

    private Integer goodsNum;

    public TradeCartRecord(Goods goods, Integer goodsNum) {
        super();
        this.goods = goods;
        this.goodsNum = goodsNum;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
}
