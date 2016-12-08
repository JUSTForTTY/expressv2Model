package com.hundsun.jresplus.quickstart.biz.po;

import java.util.Date;

import com.hundsun.jresplus.quickstart.biz.query.BaseQuery;

public class Fast extends BaseQuery{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int id ;//快捷服务id
private String name;//服务定义
private String picture;//图片地址
private String url;//链接地址
private int sort;//顺序号
private String is_display;
public int getSort() {
	return sort;
}
public void setSort(int sort) {
	this.sort = sort;
}
public String getIs_display() {
	return is_display;
}
public void setIs_display(String is_display) {
	this.is_display = is_display;
}
private int building_id;//楼宇号
private String create_user;//创建人
private Date create_time;//创建时间
private  String modify_user;//更新人
private Date modify_time;//更新时间
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPicture() {
	return picture;
}
public void setPicture(String picture) {
	this.picture = picture;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}



public int getBuilding_id() {
	return building_id;
}
public void setBuilding_id(int building_id) {
	this.building_id = building_id;
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
public String getModify_user() {
	return modify_user;
}
public void setModify_user(String modify_user) {
	this.modify_user = modify_user;
}
public Date getModify_time() {
	return modify_time;
}
public void setModify_time(Date modify_time) {
	this.modify_time = modify_time;
}
}
