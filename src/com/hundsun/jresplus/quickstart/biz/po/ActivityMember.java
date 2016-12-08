package com.hundsun.jresplus.quickstart.biz.po;

import java.io.Serializable;
import java.util.Date;
 


 
public class ActivityMember implements Serializable {
//���Ա��
	private static final long serialVersionUID = 1L;

	 
	private String amid;

	 
	private Integer bid;

	 
	private String aid;

	 
	private String cmid;

	 
	private String name;

 
	private String nickname;

	 
	private String mobile;

	 
	private String gender;

	 
	private String administrator;

	 
	private String operator;

	 
	private String createUser;

	 
	private Date createTime;

	 
	private String modifyUser;

	 
	private Date modifyTime;


	public void setAmid(String amid){
		this.amid = amid;
	}

	public String getAmid(){
		return this.amid;
	}

	public void setBid(Integer bid){
		this.bid = bid;
	}

	public Integer getBid(){
		return this.bid;
	}

	public void setAid(String aid){
		this.aid = aid;
	}

	public String getAid(){
		return this.aid;
	}

	public void setCmid(String cmid){
		this.cmid = cmid;
	}

	public String getCmid(){
		return this.cmid;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public String getNickname(){
		return this.nickname;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return this.mobile;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return this.gender;
	}

	public void setAdministrator(String administrator){
		this.administrator = administrator;
	}

	public String getAdministrator(){
		return this.administrator;
	}

	public void setOperator(String operator){
		this.operator = operator;
	}

	public String getOperator(){
		return this.operator;
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