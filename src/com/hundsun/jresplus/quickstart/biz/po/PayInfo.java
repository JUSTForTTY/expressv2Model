package com.hundsun.jresplus.quickstart.biz.po;

public class PayInfo {
    private Long    requestId;

    private Integer outPayId;

    private Integer amount;

    private Integer payType;

    private String  notify_url;

    private String  return_url;

    private Long    userId;

    //支付
    private String  desc = "网上商品";

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Integer getOutPayId() {
        return outPayId;
    }

    public void setOutPayId(Integer outPayId) {
        this.outPayId = outPayId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
