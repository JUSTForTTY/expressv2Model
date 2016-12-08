package com.hundsun.jresplus.quickstart.biz.po;

import java.io.Serializable;
import java.util.Date;

 

 
public class ClubMember extends BaseDomain {
//���ų�Ա��	private static final long serialVersionUID = 1L;

	 
	private String cmid;

	 
	private String cid;

	 
	private String uid;

	 
	private Integer bid;

	 
	private String name;

	 
	private String status;
	
	private String headImage;

	 
	private String nickname;

	 
	private String mobile;

	 
	private String gender;

	 
	private String grade;

	 
	private String flag;

	 
	private String administrator;

	 
	private Date cueTime;

	 
	private String accomplish;

	 
	private String createUser;

	 
	private Date createTime;

	 
	private String modifyUser;

	 
	private Date modifyTime;


	public void setCmid(String cmid){
		this.cmid = cmid;
	}
	public String getCmid(){
		return this.cmid;
	}
	public void setCid(String cid){
		this.cid = cid;
	}
	public String getCid(){
		return this.cid;
	}
	public void setUid(String uid){
		this.uid = uid;
	}
	public String getUid(){
		return this.uid;
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
	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return this.status;
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
	public void setGrade(String grade){
		this.grade = grade;
	}
	public String getGrade(){
		return this.grade;
	}
	public void setFlag(String flag){
		this.flag = flag;
	}
	public String getFlag(){
		return this.flag;
	}
	public void setAdministrator(String administrator){
		this.administrator = administrator;
	}
	public String getAdministrator(){
		return this.administrator;
	}
	public void setCueTime(Date cueTime){
		this.cueTime = cueTime;
	}
	public Date getCueTime(){
		return this.cueTime;
	}
	public void setAccomplish(String accomplish){
		this.accomplish = accomplish;
	}
	public String getAccomplish(){
		return this.accomplish;
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

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	
}