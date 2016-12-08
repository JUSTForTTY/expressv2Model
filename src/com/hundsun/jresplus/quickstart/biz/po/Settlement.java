package com.hundsun.jresplus.quickstart.biz.po;

import java.util.ArrayList;
import java.util.List;

/**
 * 结算单
 * @author chengy
 *
 */
public class Settlement {

    /**
     * 总积分
     */
    private Integer        scoreSum   = 0;

    /**
     * 总金额
     */
    private Double         priceSum   = 0D;

    /**
     * 商品数量
     */
    private Integer        itemcount  = 0;

    /**
     * 商品种类数量 
     */
    private Integer        goodskinds = 0;
    
    
    private String         result;

    List<SettlementDetail> detailList = new ArrayList<SettlementDetail>();

    public Integer getScoreSum() {
        return scoreSum;
    }

    public void setScoreSum(Integer scoreSum) {
        this.scoreSum = scoreSum;
    }

    public Double getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(Double priceSum) {
        this.priceSum = priceSum;
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

    public List<SettlementDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<SettlementDetail> detailList) {
        this.detailList = detailList;
    }

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
