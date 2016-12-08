package com.hundsun.jresplus.quickstart.biz.query;

import java.util.Date;

public class CodemasterQuery extends BaseQuery {

    /**
     * UID
     */
    private static final long serialVersionUID = -5606782018900144859L;

	private Integer codeno;
	private String codetype;
	private String codename;
	private String codeDescription;
	private String content;

	private Integer id;
	private Integer building_id;
	private Integer floor;
	private String type;
	private String custom_detail;
	private Date    create_time;
	private Date    modify_time;
	private String description;
	private String enable;
	private String create_user;
	private String modify_user;
	private String more;
	public Integer getCodeno() {
		return codeno;
	}
	public void setCodeno(Integer codeno) {
		this.codeno = codeno;
	}
	public String getCodetype() {
		return codetype;
	}
	public void setCodetype(String codetype) {
		this.codetype = codetype;
	}
	public String getCodename() {
		return codename;
	}
	public void setCodename(String codename) {
		this.codename = codename;
	}
	public String getCodeDescription() {
		return codeDescription;
	}
	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBuilding_id() {
		return building_id;
	}
	public void setBuilding_id(Integer building_id) {
		this.building_id = building_id;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCustom_detail() {
		return custom_detail;
	}
	public void setCustom_detail(String custom_detail) {
		this.custom_detail = custom_detail;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getMore() {
		return more;
	}
	public void setMore(String more) {
		this.more = more;
	}
    
}
