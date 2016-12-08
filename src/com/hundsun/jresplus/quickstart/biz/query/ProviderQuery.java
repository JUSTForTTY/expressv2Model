package com.hundsun.jresplus.quickstart.biz.query;

import java.util.Date;

public class ProviderQuery extends BaseQuery {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7850798688119110122L;
	private Integer id;

	 
	private String name;

	 
	private String title;

	 
	private String address;

	 
	private String longitude;

	 
	private String latitude;

	 
	private String memberurl;

	 
	private String detailintro;

	 
	private String miniature;

	 
	private String image1;

	 
	private String type;

	 
	private String status;

	 
	private Date createTime;

	 
	private Date updateTime;

	 
	private String createUser;

	 
	private String updateUser;

	 
	private String image4;

	 
	private String image5;

	 
	private String size;

	 
	private String weight;

	 
	private String model;

	 
	private String spec;

	 
	private Integer brandId;

	 
	private String material;
	
	
	private Integer currentPageCount;
	
	private Integer totalPageCount=0;


	public Integer getCurrentPageCount() {
		return currentPageCount;
	}


	public void setCurrentPageCount(Integer currentPageCount) {
		this.currentPageCount = currentPageCount;
	}


	public Integer getTotalPageCount() {
		return totalPageCount;
	}


	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getMemberurl() {
		return memberurl;
	}


	public void setMemberurl(String memberurl) {
		this.memberurl = memberurl;
	}


	public String getDetailintro() {
		return detailintro;
	}


	public void setDetailintro(String detailintro) {
		this.detailintro = detailintro;
	}


	public String getMiniature() {
		return miniature;
	}


	public void setMiniature(String miniature) {
		this.miniature = miniature;
	}


	public String getImage1() {
		return image1;
	}


	public void setImage1(String image1) {
		this.image1 = image1;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public String getCreateUser() {
		return createUser;
	}


	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}


	public String getUpdateUser() {
		return updateUser;
	}


	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}


	public String getImage4() {
		return image4;
	}


	public void setImage4(String image4) {
		this.image4 = image4;
	}


	public String getImage5() {
		return image5;
	}


	public void setImage5(String image5) {
		this.image5 = image5;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getSpec() {
		return spec;
	}


	public void setSpec(String spec) {
		this.spec = spec;
	}


	public Integer getBrandId() {
		return brandId;
	}


	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}


}
