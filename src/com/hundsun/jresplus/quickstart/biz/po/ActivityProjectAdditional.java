package com.hundsun.jresplus.quickstart.biz.po;

import java.io.Serializable;
import java.util.Date;

 


 
public class ActivityProjectAdditional implements Serializable {
//�������Ŀ��
	private static final long serialVersionUID = 1L;

	 
	private String apaid;

	 
	private String aid;

	 
	private Integer bid;

	 
	private String name;

	 
	private String price;

	 
	private String content;

	 
	private Date startTime;

	 
	private Date endTime;

	 
	private String createUser;

	 
	private Date createTime;

	 
	private String modifyUser;

	 
	private Date modifyTime;

	 
	private Integer isDelete;


	public void setApaid(String apaid){
		this.apaid = apaid;
	}

	public String getApaid(){
		return this.apaid;
	}

	public void setAid(String aid){
		this.aid = aid;
	}

	public String getAid(){
		return this.aid;
	}

	public void setBid(Integer bid){
		this.bid = bid;
	}

	public Integer getBid(){
		return this.bid;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return this.price;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return this.content;
	}

	public void setStartTime(Date startTime){
		this.startTime = startTime;
	}

	public Date getStartTime(){
		return this.startTime;
	}

	public void setEndTime(Date endTime){
		this.endTime = endTime;
	}

	public Date getEndTime(){
		return this.endTime;
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

	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}

	public Integer getIsDelete(){
		return this.isDelete;
	}

}