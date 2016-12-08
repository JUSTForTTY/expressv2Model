package com.hundsun.jresplus.quickstart.biz.po;



import java.io.Serializable;
import java.util.Date;
 

 

 
public class Activity implements Serializable {
//���
	private static final long serialVersionUID = 1L;

	 
	private String aid;

	 
	private String cid;

	 
	private String bid;

	 
	private String name;

	 
	private String subtitle;

	 
	private String logo;

	 
	private String officialUrl;

	 
	private String areaId;

	 
	private String provinceId;

	 
	private String cityId;

	 
	private String site;

	 
	private String address;

	 
	private String lat;

	 
	private String lng;

	 
	private String type;

	 
	private Integer day;

	 
	private Date registerStart;

	 
	private Date registerEnd;

	 
	private Date startTime;

	 
	private Date endTime;

	 
	private String status;

	 
	private String briefintro;

	 
	private String actDetail;

	 
	private String actDetailUrl;

	 
	private Integer stick;

	 
	private Integer followSum;

	 
	private String createUser;

	 
	private Date createTime;

	 
	private String modifyUser;

	 
	private Date modifyTime;

	private Integer clickNum;

	 
	private Integer agreeNum;

	 
	private Integer disagreeNum;

	 
	private Date agreeNumTime;

	 
	private Integer isDelete;

	 
	private String age;

	 
	private String mobileContent;


	public void setAid(String aid){
		this.aid = aid;
	}

	public String getAid(){
		return this.aid;
	}

	public void setCid(String cid){
		this.cid = cid;
	}

	public String getCid(){
		return this.cid;
	}

	public void setBid(String bid){
		this.bid = bid;
	}

	public String getBid(){
		return this.bid;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setSubtitle(String subtitle){
		this.subtitle = subtitle;
	}

	public String getSubtitle(){
		return this.subtitle;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return this.logo;
	}

	public void setOfficialUrl(String officialUrl){
		this.officialUrl = officialUrl;
	}

	public String getOfficialUrl(){
		return this.officialUrl;
	}

	public void setAreaId(String areaId){
		this.areaId = areaId;
	}

	public String getAreaId(){
		return this.areaId;
	}

	public void setProvinceId(String provinceId){
		this.provinceId = provinceId;
	}

	public String getProvinceId(){
		return this.provinceId;
	}

	public void setCityId(String cityId){
		this.cityId = cityId;
	}

	public String getCityId(){
		return this.cityId;
	}

	public void setSite(String site){
		this.site = site;
	}

	public String getSite(){
		return this.site;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return this.address;
	}

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return this.lat;
	}

	public void setLng(String lng){
		this.lng = lng;
	}

	public String getLng(){
		return this.lng;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return this.type;
	}

	public void setDay(Integer day){
		this.day = day;
	}

	public Integer getDay(){
		return this.day;
	}

	public void setRegisterStart(Date registerStart){
		this.registerStart = registerStart;
	}

	public Date getRegisterStart(){
		return this.registerStart;
	}

	public void setRegisterEnd(Date registerEnd){
		this.registerEnd = registerEnd;
	}

	public Date getRegisterEnd(){
		return this.registerEnd;
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

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return this.status;
	}

	public void setBriefintro(String briefintro){
		this.briefintro = briefintro;
	}

	public String getBriefintro(){
		return this.briefintro;
	}

	public void setActDetail(String actDetail){
		this.actDetail = actDetail;
	}

	public String getActDetail(){
		return this.actDetail;
	}

	public void setActDetailUrl(String actDetailUrl){
		this.actDetailUrl = actDetailUrl;
	}

	public String getActDetailUrl(){
		return this.actDetailUrl;
	}

	public void setStick(Integer stick){
		this.stick = stick;
	}

	public Integer getStick(){
		return this.stick;
	}

	public void setFollowSum(Integer followSum){
		this.followSum = followSum;
	}

	public Integer getFollowSum(){
		return this.followSum;
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

	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}

	public Integer getIsDelete(){
		return this.isDelete;
	}

	public void setAge(String age){
		this.age = age;
	}

	public String getAge(){
		return this.age;
	}

	public void setMobileContent(String mobileContent){
		this.mobileContent = mobileContent;
	}

	public String getMobileContent(){
		return this.mobileContent;
	}

}