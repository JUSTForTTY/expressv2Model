package com.hundsun.jresplus.quickstart.biz.po;

import java.io.Serializable;
import java.util.Date;

 


 
public class ActivityProject implements Serializable {
//���Ŀ��
	private static final long serialVersionUID = 1L;

	 
	private String apid;
 
	private String aid;

	 
	private Integer bid;

	 
	private String name;

	 
	private Double price;

	 
	private Double refprice;

	 
	private String content;

	 
	private Integer projectNum;

	 
	private String status;

	 
	private Date startTime;

	 
	private Date endTime;

	 
	private String createUser;

	 
	private Date createTime;

	 
	private String modifyUser;

	 
	private Date modifyTime;


	public void setApid(String apid){
		this.apid = apid;
	}

	public String getApid(){
		return this.apid;
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

	public void setPrice(Double price){
		this.price = price;
	}

	public Double getPrice(){
		return this.price;
	}

	public void setRefprice(Double refprice){
		this.refprice = refprice;
	}

	public Double getRefprice(){
		return this.refprice;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return this.content;
	}

	public void setProjectNum(Integer projectNum){
		this.projectNum = projectNum;
	}

	public Integer getProjectNum(){
		return this.projectNum;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return this.status;
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

}