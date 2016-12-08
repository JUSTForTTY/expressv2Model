package com.hundsun.jresplus.quickstart.biz.po;

import java.util.*;

/**
 * 预存款记录
 * @author chengy
 * @version $Id: Prepaylog.java,v 0.1 2015年5月31日 下午8:41:39 chengy Exp $
 */
public class PrepayLog extends BaseDomain {
    /**
     * 
     */
    private static final long serialVersionUID = -2426455221945999801L;
    private Long              id;
    private Long              user_id;
    private Long              orderinfo_id;
    private Double            paysum;
    private String            paytype;
    private Date              paytime;
    private String            remark;
    private Long              creator;
    private String            creatorName;
    private Date              createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getOrderinfo_id() {
        return orderinfo_id;
    }

    public void setOrderinfo_id(Long orderinfo_id) {
        this.orderinfo_id = orderinfo_id;
    }

    public Double getPaysum() {
        return paysum;
    }

    public void setPaysum(Double paysum) {
        this.paysum = paysum;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public void copyVal(PrepayLog source) {
        this.setId(source.getId());
        this.setUser_id(source.getUser_id());
        this.setOrderinfo_id(source.getOrderinfo_id());
        this.setPaysum(source.getPaysum());
        this.setPaytype(source.getPaytype());
        this.setPaytime(source.getPaytime());
        this.setRemark(source.getRemark());
        this.setCreator(source.getCreator());
        this.setCreatetime(source.getCreatetime());
    }

}
