package com.hundsun.jresplus.quickstart.biz.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author chengy
 *
 */
public class Orderinfo extends BaseDomain {
    /**
     * 
     */
    private static final long serialVersionUID = 1822714918820049843L;
    private Long              id;
    private String            orderno;
    private Date              ordertime;
    private Integer           itemcount;
    private Double            goodssum;
    private Double            servicesum;
    private Double            othersum;                                     //用户订单优惠减免费用，有权限的后台用户手工录入。totalsum=goodssum+servicesm-othersum
    private Double            totalsum;
    private Integer           score;
    private String            receivername;
    private String            receivertel;
    private String            receivermobile;
    private String            receiveremail;
    private String            receiveraddr;
    private String            receiverzip;
    private Long              user_id;
    private String            username;
    private String            userremark;
    private Integer           delivertype_id;
    private String            deliverremark;
    private Integer           paymenttype_id;
    private Date              paymenttime;
    private String            paymentremark;
    private Integer           requireinvoice;
    private String            invoicetitle;
    private Integer           status;

    private List<Orderitem>   orderItems       = new ArrayList<Orderitem>();
    private String            msg;
    private Integer           splitorder;
    private Integer           outgoodsnum;
    private Double            outgoodssum;
    private boolean           isoutofstock;

    public boolean isIsoutofstock() {
        return isoutofstock;
    }

    public void setIsoutofstock(boolean isoutofstock) {
        this.isoutofstock = isoutofstock;
    }

    public Double getOutgoodssum() {
        return outgoodssum;
    }

    public void setOutgoodssum(Double outgoodssum) {
        this.outgoodssum = outgoodssum;
    }

    public Integer getOutgoodsnum() {
        return outgoodsnum;
    }

    public void setOutgoodsnum(Integer outgoodsnum) {
        this.outgoodsnum = outgoodsnum;
    }

    public Integer getSplitorder() {
        return splitorder;
    }

    public void setSplitorder(Integer splitorder) {
        this.splitorder = splitorder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderno() {
        return this.orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;

    }

    public Date getOrdertime() {
        return this.ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;

    }

    public Integer getItemcount() {
        return this.itemcount;
    }

    public void setItemcount(Integer itemcount) {
        this.itemcount = itemcount;

    }

    public Double getGoodssum() {
        return this.goodssum;
    }

    public void setGoodssum(Double goodssum) {
        this.goodssum = goodssum;

    }

    public Double getServicesum() {
        return this.servicesum;
    }

    public void setServicesum(Double servicesum) {
        this.servicesum = servicesum;

    }

    public Double getOthersum() {
        return this.othersum;
    }

    public void setOthersum(Double othersum) {
        this.othersum = othersum;

    }

    public Double getTotalsum() {
        return this.totalsum;
    }

    public void setTotalsum(Double totalsum) {
        this.totalsum = totalsum;

    }

    public Integer getScore() {
        return this.score;
    }

    public void setScore(Integer score) {
        this.score = score;

    }

    public String getReceivername() {
        return this.receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername;

    }

    public String getReceivertel() {
        return this.receivertel;
    }

    public void setReceivertel(String receivertel) {
        this.receivertel = receivertel;

    }

    public String getReceivermobile() {
        return this.receivermobile;
    }

    public void setReceivermobile(String receivermobile) {
        this.receivermobile = receivermobile;

    }

    public String getReceiveremail() {
        return this.receiveremail;
    }

    public void setReceiveremail(String receiveremail) {
        this.receiveremail = receiveremail;

    }

    public String getReceiveraddr() {
        return this.receiveraddr;
    }

    public void setReceiveraddr(String receiveraddr) {
        this.receiveraddr = receiveraddr;

    }

    public String getReceiverzip() {
        return this.receiverzip;
    }

    public void setReceiverzip(String receiverzip) {
        this.receiverzip = receiverzip;

    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;

    }

    public Integer getDelivertype_id() {
        return this.delivertype_id;
    }

    public void setDelivertype_id(Integer delivertype_id) {
        this.delivertype_id = delivertype_id;

    }

    public String getDeliverremark() {
        return this.deliverremark;
    }

    public void setDeliverremark(String deliverremark) {
        this.deliverremark = deliverremark;

    }

    public Integer getPaymenttype_id() {
        return this.paymenttype_id;
    }

    public void setPaymenttype_id(Integer paymenttype_id) {
        this.paymenttype_id = paymenttype_id;

    }

    public Date getPaymenttime() {
        return this.paymenttime;
    }

    public void setPaymenttime(Date paymenttime) {
        this.paymenttime = paymenttime;

    }

    public String getPaymentremark() {
        return this.paymentremark;
    }

    public void setPaymentremark(String paymentremark) {
        this.paymentremark = paymentremark;

    }

    public Integer getRequireinvoice() {
        return this.requireinvoice;
    }

    public void setRequireinvoice(Integer requireinvoice) {
        this.requireinvoice = requireinvoice;

    }

    public String getInvoicetitle() {
        return this.invoicetitle;
    }

    public void setInvoicetitle(String invoicetitle) {
        this.invoicetitle = invoicetitle;

    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;

    }

    public String getUserremark() {
        return userremark;
    }

    public void setUserremark(String userremark) {
        this.userremark = userremark;
    }

    public List<Orderitem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Orderitem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
