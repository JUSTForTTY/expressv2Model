package com.hundsun.jresplus.quickstart.biz.po;

import java.util.Date;

public class GoodsCollect extends BaseDomain {
    private static final long serialVersionUID = -5106410532896604689L;
    private Long              id;
    private String            type;
    private Long              goodsId;
    private String            userName;
    private Date              createTime;

    private String            goodsName;

    public GoodsCollect() {
        super();
    }

    public GoodsCollect(String userName2, Long goodsId2, String type2) {
        super();
        this.userName = userName2;
        this.goodsId = goodsId2;
        this.type = type2;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

}
