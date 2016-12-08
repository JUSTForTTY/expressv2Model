package com.hundsun.jresplus.quickstart.biz.po;

import java.util.Date;

import com.hundsun.jresplus.quickstart.enums.EnumOrderItemStatus;

/**
 * 
 * @author chengy
 *
 */
public class Orderitem extends BaseDomain {
    /**
     * UID
     */
    private static final long serialVersionUID = 2993470916100065030L;
    private Long              id;
    private Long              orderinfo_id;
    private Integer           itemno;                                 // 此字段的初衷是记录明细项的序号，无实际意义，现改作是否缺货商品的标识项：0-缺货；1-有现货
    private Long              goods_id;
    private String            goods_name;
    private String            privatecode;
    private Double            unitprice;
    private Integer           itemnum;
    private String            unit;
    private Double            itemsum;
    private Long              user_id;
    private boolean           isoutofstock;
    private String            goods_state;

    /**
     * 供应商id
     */
    private Long              provider_id;

    public String getGoods_state() {
        return goods_state;
    }

    public void setGoods_state(String goods_state) {
        this.goods_state = goods_state;
    }

    /**
     * 供应商企业名称
     */
    private String provider_companytitle;

    /**
     * 供应日期
     */
    private Date   supplydate;

    private Long   commentId;            // 评论id

    private String status;               // 订单状态

    public boolean isDeliverying() {
        return EnumOrderItemStatus.DELIVERYING.getCode().equals(this.status);
    }

    public boolean isReceived() {
        return EnumOrderItemStatus.RECEIVED.getCode().equals(this.status);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderinfo_id() {
        return orderinfo_id;
    }

    public void setOrderinfo_id(Long orderinfo_id) {
        this.orderinfo_id = orderinfo_id;
    }

    public Integer getItemno() {
        return this.itemno;
    }

    public void setItemno(Integer itemno) {
        this.itemno = itemno;

    }

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public Double getUnitprice() {
        return this.unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;

    }

    public Integer getItemnum() {
        return this.itemnum;
    }

    public void setItemnum(Integer itemnum) {
        this.itemnum = itemnum;

    }

    public Double getItemsum() {
        return this.itemsum;
    }

    public void setItemsum(Double itemsum) {
        this.itemsum = itemsum;

    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getPrivatecode() {
        return privatecode;
    }

    public void setPrivatecode(String privatecode) {
        this.privatecode = privatecode;
    }

    public Long getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(Long provider_id) {
        this.provider_id = provider_id;
    }

    public String getProvider_companytitle() {
        return provider_companytitle;
    }

    public void setProvider_companytitle(String provider_companytitle) {
        this.provider_companytitle = provider_companytitle;
    }

    public Date getSupplydate() {
        return supplydate;
    }

    public void setSupplydate(Date supplydate) {
        this.supplydate = supplydate;
    }

    public boolean getIsoutofstock() {
        return isoutofstock;
    }

    public void setIsoutofstock(boolean isoutofstock) {
        this.isoutofstock = isoutofstock;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
