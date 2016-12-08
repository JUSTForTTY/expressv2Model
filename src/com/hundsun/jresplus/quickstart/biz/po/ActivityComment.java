package com.hundsun.jresplus.quickstart.biz.po;

import java.io.Serializable;
import java.util.Date;

 

 
public class ActivityComment implements Serializable {
//����۱�
	private static final long serialVersionUID = 1L;

	 
	private String acid;

	 
	private Integer bid;

	 
	private String aid;

	 
	private String amid;

	 
	private String cmid;

	 
	private String parentId;

	 
	private String content;

	 
	private String reply;

	 
	private Integer stick;

	 
	private Integer status;

	 
	private Integer thumb;

	 
	private String miniature;

	 
	private String image1;

	 
	private String image2;

	 
	private String image3;

	 
	private String image4;

	 
	private String image5;

	 
	private String imageId;

	 
	private String nickname;

	 
	private String createUser;

	 
	private Date createTime;

	 
	private String modifyUser;

	 
	private Date modifyTime;

	 
	private Integer clickNum;

	 
	private Integer agreeNum;

	 
	private Integer disagreeNum;

	 
	private Date agreeNumTime;


	public void setAcid(String acid){
		this.acid = acid;
	}

	public String getAcid(){
		return this.acid;
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

	public void setAmid(String amid){
		this.amid = amid;
	}

	public String getAmid(){
		return this.amid;
	}

	public void setCmid(String cmid){
		this.cmid = cmid;
	}

	public String getCmid(){
		return this.cmid;
	}

	public void setParentId(String parentId){
		this.parentId = parentId;
	}

	public String getParentId(){
		return this.parentId;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return this.content;
	}

	public void setReply(String reply){
		this.reply = reply;
	}

	public String getReply(){
		return this.reply;
	}

	public void setStick(Integer stick){
		this.stick = stick;
	}

	public Integer getStick(){
		return this.stick;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setThumb(Integer thumb){
		this.thumb = thumb;
	}

	public Integer getThumb(){
		return this.thumb;
	}

	public void setMiniature(String miniature){
		this.miniature = miniature;
	}

	public String getMiniature(){
		return this.miniature;
	}

	public void setImage1(String image1){
		this.image1 = image1;
	}

	public String getImage1(){
		return this.image1;
	}

	public void setImage2(String image2){
		this.image2 = image2;
	}

	public String getImage2(){
		return this.image2;
	}

	public void setImage3(String image3){
		this.image3 = image3;
	}

	public String getImage3(){
		return this.image3;
	}

	public void setImage4(String image4){
		this.image4 = image4;
	}

	public String getImage4(){
		return this.image4;
	}

	public void setImage5(String image5){
		this.image5 = image5;
	}

	public String getImage5(){
		return this.image5;
	}

	public void setImageId(String imageId){
		this.imageId = imageId;
	}

	public String getImageId(){
		return this.imageId;
	}

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public String getNickname(){
		return this.nickname;
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

	public void setClickNum(Integer clickNum){
		this.clickNum = clickNum;
	}

	public Integer getClickNum(){
		return this.clickNum;
	}

	public void setAgreeNum(Integer agreeNum){
		this.agreeNum = agreeNum;
	}

	public Integer getAgreeNum(){
		return this.agreeNum;
	}

	public void setDisagreeNum(Integer disagreeNum){
		this.disagreeNum = disagreeNum;
	}

	public Integer getDisagreeNum(){
		return this.disagreeNum;
	}

	public void setAgreeNumTime(Date agreeNumTime){
		this.agreeNumTime = agreeNumTime;
	}

	public Date getAgreeNumTime(){
		return this.agreeNumTime;
	}

}