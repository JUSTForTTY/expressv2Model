package com.hundsun.jresplus.quickstart.biz.query;

public class GoodsCollectQuery extends BaseQuery {

    private static final long serialVersionUID = 1833863213184335900L;

    private Long              id;

    private String            userName;

    private String            type;

    private Long              goodsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

}
