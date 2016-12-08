package com.hundsun.jresplus.quickstart.biz.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubOrder extends BaseDomain {

    private static final long serialVersionUID = 3307012611713169347L;

    private Long              id;

    private Long              orderId;

    private Long              memberId;

    private String            memberName;

    private Long              subtotalPrice;

    private Long              subtotalScore;

    private Integer           goodsTypeCount;

    private Integer           goodsCount;

    private Integer            status;

    private Date              gmtCreate;

    private Date              gmtModify;

    private List<OrderDetail> detailList       = new ArrayList<OrderDetail>();

    public List<OrderDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<OrderDetail> detailList) {
        this.detailList = detailList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Long getSubtotalPrice() {
        return subtotalPrice;
    }

    public void setSubtotalPrice(Long subtotalPrice) {
        this.subtotalPrice = subtotalPrice;
    }

    public Long getSubtotalScore() {
        return subtotalScore;
    }

    public void setSubtotalScore(Long subtotalScore) {
        this.subtotalScore = subtotalScore;
    }

    public Integer getGoodsTypeCount() {
        return goodsTypeCount;
    }

    public void setGoodsTypeCount(Integer goodsTypeCount) {
        this.goodsTypeCount = goodsTypeCount;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

}
