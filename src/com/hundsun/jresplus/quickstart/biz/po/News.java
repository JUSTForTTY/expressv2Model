package com.hundsun.jresplus.quickstart.biz.po;

import java.util.Date;

import com.hundsun.jresplus.quickstart.biz.query.BaseQuery;

public class News extends BaseQuery{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;//新闻id
	private String title;//标题
	private String image;//图片
	private String is_scroll;//是否滚动显示（Y_显示，N-不显示）
//	private int sort;//排序
	private String content;//内容
	private String briefintro;
	private String type;//类型 0：表示普通新闻，1：表示下载新闻，2表示特色新闻
	private String status;//状态 init-初始化；publish-发布；return-打回
	private String url;//链接地址
	private Date gmt_create;
	private Date gmt_modify;
	private Date gmt_publish;
	private Long buildingId;
	private int  providerId;
	
//	private Date gmt_publish;//发布时间
 //   private Date gmt_create;//创建人
  
//	private Date gmt_modify;//更新人
    
 //   public Date getGmt_publish() {
//		return gmt_publish;
//	}
//	public void setGmt_publish(Date gmt_publish) {
//		this.gmt_publish = gmt_publish;
//	}
//	public Date getGmt_create() {
//		return gmt_create;
//	}
//	public void setGmt_create(Date gmt_create) {
//		this.gmt_create = gmt_create;
//	}
//	public Date getGmt_modify() {
//		return gmt_modify;
//	}
//	public void setGmt_modify(Date gmt_modify) {
//		this.gmt_modify = gmt_modify;
//	}

	public Date getGmt_create() {
		return gmt_create;
	}
	public void setGmt_create(Date gmt_create) {
		this.gmt_create = gmt_create;
	}
	public Date getGmt_modify() {
		return gmt_modify;
	}
	public void setGmt_modify(Date gmt_modify) {
		this.gmt_modify = gmt_modify;
	}
	public Date getGmt_publish() {
		return gmt_publish;
	}
	public void setGmt_publish(Date gmt_publish) {
		this.gmt_publish = gmt_publish;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getIs_scroll() {
		return is_scroll;
	}
	public void setIs_scroll(String is_scroll) {
		this.is_scroll = is_scroll;
	}
//	public int getSort() {
//		return sort;
//	}
//	public void setSort(int sort) {
//		this.sort = sort;
//	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	public String getBriefintro() {
		return briefintro;
	}
	public void setBriefintro(String briefintro) {
		this.briefintro = briefintro;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

}
