package com.hundsun.jresplus.quickstart.biz.po;

import java.io.Serializable;
import java.util.Date;

 


 
public class Club extends BaseDomain {
//���ű�	private static final long serialVersionUID = 1L;

	 
	private String cid;

	 
	private Integer bid;

	 
	private String name;

	 
	private String logo;

	 
	private String brief;

	 
	private String type;

	 
	private Integer clubMemberSum;

	 
	private String feeCircle;

	 
	private Date feeStartDate;

	 
	private String city;

	 
	private String administrator;

	 
	private String slogan;

	 
	private String operator;

	 
	private String mobile;

	 
	private Integer createId;

	 
	private String status;

	 
	private String createUser;

	 
	private Date createTime;

	 
	private String modifyUser;

	 
	private Date modifyTime;
 
	private Integer isDelete;


	public void setCid(String cid){
		this.cid = cid;
	}
	public String getCid(){
		return this.cid;
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
	public void setLogo(String logo){
		this.logo = logo;
	}
	public String getLogo(){
		return this.logo;
	}
	public void setBrief(String brief){
		this.brief = brief;
	}
	public String getBrief(){
		return this.brief;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return this.type;
	}
	public void setClubMemberSum(Integer clubMemberSum){
		this.clubMemberSum = clubMemberSum;
	}
	public Integer getClubMemberSum(){
		return this.clubMemberSum;
	}
	public void setFeeCircle(String feeCircle){
		this.feeCircle = feeCircle;
	}
	public String getFeeCircle(){
		return this.feeCircle;
	}
	public void setFeeStartDate(Date feeStartDate){
		this.feeStartDate = feeStartDate;
	}
	public Date getFeeStartDate(){
		return this.feeStartDate;
	}
	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return this.city;
	}
	public void setAdministrator(String administrator){
		this.administrator = administrator;
	}
	public String getAdministrator(){
		return this.administrator;
	}
	public void setSlogan(String slogan){
		this.slogan = slogan;
	}
	public String getSlogan(){
		return this.slogan;
	}
	public void setOperator(String operator){
		this.operator = operator;
	}
	public String getOperator(){
		return this.operator;
	}
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	public String getMobile(){
		return this.mobile;
	}
	public void setCreateId(Integer createId){
		this.createId = createId;
	}
	public Integer getCreateId(){
		return this.createId;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
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
	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}
	public Integer getIsDelete(){
		return this.isDelete;
	}
}