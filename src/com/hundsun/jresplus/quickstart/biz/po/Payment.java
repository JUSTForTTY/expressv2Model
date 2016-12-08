package com.hundsun.jresplus.quickstart.biz.po;

import java.math.BigDecimal;

import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;

public class Payment {
    //目前只有现金+积分的支付方式，因此用枚举的方式来记录
    //现金
    private Double cash;
    //积分
    private int    score;
    //现金券
    private int    coupon;

    public Payment() {
        this.cash = (double) 0;
        this.score = 0;
        this.coupon = 0;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }

    //calculate
    public void calculate(Goods goods, int num) {
        Double price = goods.getPrice();
        if (price == null || price < 0.0D) {
            price = 0.0D;
        }
        if (goods.getType().equals(EnumGoodsType.NORMAL.getCode())||goods.getType().equals(EnumGoodsType.SALE.getCode())) {
            this.cash += new BigDecimal(price.toString()).multiply(
                new BigDecimal(String.valueOf(num))).doubleValue();
        } else if (goods.getType().equals(EnumGoodsType.INTEGRAL.getCode())) {
            this.score += new BigDecimal(price.toString()).multiply(
                new BigDecimal(String.valueOf(num))).intValue();
        }
    }
    

    //calculate
    public void calculateNoLogin(Goods goods, int num) {
        Double price = goods.getRefprice();
        if (price == null || price < 0.0D) {
            price = 0.0D;
        }
        if (goods.getType().equals(EnumGoodsType.NORMAL.getCode())||goods.getType().equals(EnumGoodsType.SALE.getCode())) {
            this.cash += new BigDecimal(price.toString()).multiply(
                new BigDecimal(String.valueOf(num))).doubleValue();
        } else if (goods.getType().equals(EnumGoodsType.INTEGRAL.getCode())) {
            this.score += new BigDecimal(price.toString()).multiply(
                new BigDecimal(String.valueOf(num))).intValue();
        }
    }
}
