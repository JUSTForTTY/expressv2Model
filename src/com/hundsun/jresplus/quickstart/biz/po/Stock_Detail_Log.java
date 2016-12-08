package com.hundsun.jresplus.quickstart.biz.po;

import java.util.Date;

public class Stock_Detail_Log extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 636005578720967903L;
private Integer id;//编号

private String importBillID;//进货单号
private Integer goods_id;//商品编号

private String goods_name;//商品名
private String user_name;//用户名
private String miniature;//图
private Integer importPrice;//进货价
private Integer Quantity;//数量
private Integer singlePrice;//单价
private String create_user;//创建人
private Date create_time;//创建时间
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getImportBillID() {
	return importBillID;
}
public void setImportBillID(String importBillID) {
	this.importBillID = importBillID;
}
public Integer getGoods_id() {
	return goods_id;
}
public void setGoods_id(Integer goods_id) {
	this.goods_id = goods_id;
}
public String getGoods_name() {
	return goods_name;
}
public void setGoods_name(String goods_name) {
	this.goods_name = goods_name;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getMiniature() {
	return miniature;
}
public void setMiniature(String miniature) {
	this.miniature = miniature;
}
public Integer getImportPrice() {
	return importPrice;
}
public void setImportPrice(Integer importPrice) {
	this.importPrice = importPrice;
}

public Integer getQuantity() {
	return Quantity;
}
public void setQuantity(Integer quantity) {
	Quantity = quantity;
}
public Integer getSinglePrice() {
	return singlePrice;
}
public void setSinglePrice(Integer singlePrice) {
	this.singlePrice = singlePrice;
}
public String getCreate_user() {
	return create_user;
}
public void setCreate_user(String create_user) {
	this.create_user = create_user;
}
public Date getCreate_time() {
	return create_time;
}
public void setCreate_time(Date create_time) {
	this.create_time = create_time;
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
private String update_user;//更新人
private Date update_time;//更新时间
}
