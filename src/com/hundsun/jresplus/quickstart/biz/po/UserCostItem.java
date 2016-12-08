package com.hundsun.jresplus.quickstart.biz.po;

import java.io.Serializable;
import java.util.Date;
 


 
public class UserCostItem implements Serializable {
	private static final long serialVersionUID = 1L;

	 
	private String ucid;

 
	private String cmid;

 
	private Integer bid;

 
	private String apid;

	 
	private String lid;

 
	private String name;

	 
	private String flag;

	 
	private Integer status;

	 
	private String createUser;

	 
	private Date createTime;

	 
	private String modifyUser;

	 
	private Date modifyTime;


	public void setUcid(String ucid){
		this.ucid = ucid;
	}
	public String getUcid(){
		return this.ucid;
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
	public void setApid(String apid){
		this.apid = apid;
	}
	public String getApid(){
		return this.apid;
	}
	public void setLid(String lid){
		this.lid = lid;
	}
	public String getLid(){
		return this.lid;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setFlag(String flag){
		this.flag = flag;
	}
	public String getFlag(){
		return this.flag;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return this.status;
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