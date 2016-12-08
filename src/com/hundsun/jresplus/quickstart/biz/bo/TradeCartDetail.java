package com.hundsun.jresplus.quickstart.biz.bo;

import com.hundsun.jresplus.quickstart.biz.po.Goods;

public class TradeCartDetail extends Goods {

    /**
     * 
     */
    private static final long serialVersionUID = 6546648400018431251L;

    /**
     * 商品id
     */
    private Long              goodsId;

    /**
     * 数量
     */
    private Integer           goodsNum;

    /**
     * 单价
     */
    private Double            priceUnit;

    /**
     * 总价
     */
    private Double            priceSum;

    public TradeCartDetail() {
        super();
    }

    public TradeCartDetail(Long goodsId, Integer goodsNum, Double priceUnit) {
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
        this.priceUnit = priceUnit;
    }

    public TradeCartDetail(Goods goods, Integer goodsNum) {
        this.goodsId = goods.getId();
        this.goodsNum = goodsNum;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(Double priceUnit) {
        this.priceUnit = priceUnit;
    }

    public Double getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(Double priceSum) {
        this.priceSum = priceSum;
    }

}
