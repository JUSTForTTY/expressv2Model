package com.hundsun.jresplus.quickstart.biz.query;



import java.util.Date;

public class StockQuery extends BaseQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7875693398404071263L;
private Integer id;//编号
private Integer goods_id;//商品id
private String goods_name;//商品名
private String price;//价格
private String miniature;//图
private String quantity;//数量
private Date create_time;//创建时间
private String create_user;//创建人
private Date update_user;//更新人
private Date update_time;//更新时间
private String username;

private String  startDate;
private String  endDate;
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
 
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public String getStartDate() {
	
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
 

}
