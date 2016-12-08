package com.hundsun.jresplus.quickstart.biz.po;

import java.util.Date;

public class Stock_Inventory extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7875693398404071263L;
private Integer id;//编号
private Integer goods_id;//商品id
private String goods_name;//商品名
private String user_name;
private String price;//价格
private String miniature;//图
private String member_id;
private String member_name;
private Integer quantity;//数量
private String building_id;
private Date create_time;//创建时间
private String create_user;//创建人
private Date update_user;//更新人
private Date update_time;//更新时间
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
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
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getMiniature() {
	return miniature;
}
public void setMiniature(String miniature) {
	this.miniature = miniature;
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
public Date getUpdate_user() {
	return update_user;
}
public void setUpdate_user(Date update_user) {
	this.update_user = update_user;
}
public Date getUpdate_time() {
	return update_time;
}
public void setUpdate_time(Date update_time) {
	this.update_time = update_time;
}
public String getBuilding_id() {
	return building_id;
}
public void setBuilding_id(String building_id) {
	this.building_id = building_id;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getMember_id() {
	return member_id;
}
public void setMember_id(String member_id) {
	this.member_id = member_id;
}
public String getMember_name() {
	return member_name;
}
public void setMember_name(String member_name) {
	this.member_name = member_name;
}

}
