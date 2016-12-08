package com.hundsun.jresplus.quickstart.biz.po;

import java.io.Serializable;
import java.util.Date;

 

 
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	 
	private String lid;
 
	private String cmid;

	 
	private Integer bid;

	 
	private Double payment;

 
	private Double amount;
	
	 
	private Integer status;

	 
	private String payType;

	 
	private String payFlag;

	 
	private String createUser;

	 
	private Date createTime;

	 
	private String modifyUser;

 
	private Date modifyTime;


	public void setLid(String lid){
		this.lid = lid;
	}
	public String getLid(){
		return this.lid;
	}
	public void setCmid(String cmid){
		this.cmid = cmid;
	}
	public String getCmid(){
		return this.cmid;
	}
	public void setBid(Integer bid){
		this.bid = bid;
	}
	public Integer getBid(){
		return this.bid;
	}
	public void setPayment(Double payment){
		this.payment = payment;
	}
	public Double getPayment(){
		return this.payment;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return this.status;
	}
	public void setPayType(String payType){
		this.payType = payType;
	}
	public String getPayType(){
		return this.payType;
	}
	public void setPayFlag(String payFlag){
		this.payFlag = payFlag;
	}
	public String getPayFlag(){
		return this.payFlag;
	}
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	public String getCreateUser(){
		return this.createUser;
	}
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	public Date getCreateTime(){
		return this.createTime;
	}
	public void setModifyUser(String modifyUser){
		this.modifyUser = modifyUser;
	}
	public String getModifyUser(){
		return this.modifyUser;
	}
	public void setModifyTime(Date modifyTime){
		this.modifyTime = modifyTime;
	}
	public Date getModifyTime(){
		return this.modifyTime;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}