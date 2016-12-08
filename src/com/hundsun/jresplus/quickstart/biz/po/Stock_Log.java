package com.hundsun.jresplus.quickstart.biz.po;

import java.util.Date;

public class Stock_Log extends BaseDomain{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -5329360915629656369L;
	
	//日志表
private Integer id;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
private String importBillID;//进货单号

private String user_name;//用户账号
private Integer goodkinds;//种类
private Integer totalPrice;//总价
private Integer status;
private Date create_time;//创建时间
private String create_user;//创建人
private String update_user;//更新人
private Date  update_time;//更新时间

public String getImportBillID() {
	return importBillID;
}
public void setImportBillID(String importBillID) {
	this.importBillID = importBillID;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public Integer getGoodkinds() {
	return goodkinds;
}
public void setGoodkinds(Integer goodkinds) {
	this.goodkinds = goodkinds;
}
public Integer getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(Integer totalPrice) {
	this.totalPrice = totalPrice;
}
public Date getCreate_time() {
	return create_time;
}
public void setCreate_time(Date create_time) {
	this.create_time = create_time;
}
public String getCreate_user() {
	return create_user;
}
public void setCreate_user(String create_user) {
	this.create_user = create_user;
}
public String getUpdate_user() {
	return update_user;
}
public void setUpdate_user(String update_user) {
	this.update_user = update_user;
}
public Date getUpdate_time() {
	return update_time;
}
public void setUpdate_time(Date update_time) {
	this.update_time = update_time;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
}
