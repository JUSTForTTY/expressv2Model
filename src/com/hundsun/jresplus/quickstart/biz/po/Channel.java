package com.hundsun.jresplus.quickstart.biz.po;

import java.util.Date;

public class Channel extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5426050068780776890L;

	private Long              id;
	private String            name;
	private Short             status;
	private Date              createTime;
	private Date              modifyTime;
	private String            remark;
	private String		      logo;
	private String            url;
	private Integer           sort;
	private Short             is_display;
	private Long              building_id;
	private String            pic;
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Short getIs_display() {
		return is_display;
	}
	public void setIs_display(Short is_display) {
		this.is_display = is_display;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getBuilding_id() {
		return building_id;
	}
	public void setBuilding_id(Long building_id) {
		this.building_id = building_id;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
}
