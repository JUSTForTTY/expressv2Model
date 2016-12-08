package com.hundsun.jresplus.quickstart.biz.po;

import java.util.Date;

public class Codemaster extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 542615006878079890L;

	private Integer              codeno;
	private String              codetype;
	private String              codename;
	private String              codeDescription;
	private String               content;
	private String               building_id;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getBuilding_id() {
		return building_id;
	}
	public void setBuilding_id(String building_id) {
		this.building_id = building_id;
	}
	
		
	
	
}
