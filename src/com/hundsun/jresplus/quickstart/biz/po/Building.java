/**
 * 
 */
package com.hundsun.jresplus.quickstart.biz.po;

import java.util.Date;

/**
 * @author chengy
 * 
 */
public class Building extends BaseDomain {

    /**
     * 系统配置所有楼宇的值为0
     */
    public static final int   allBuildings     = 0;
    /**
     * UID
     */
    private static final long serialVersionUID = -7756892770447105900L;
    private Long              id;
    private String            buildingName;
    private Short             status;
    private Date              createTime;
    private Date              modifyTime;
    private String            remark;
    private String            remark2;
    private String            title;
    private String            logo;
    private String            sublogo;
    
    
    

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the buildingName
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * @param buildingName
     *            the buildingName to set
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    /**
     * @return the status
     */
    public Short getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     *            the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     *            the modifyTime to set
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     *            the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getSublogo() {
		return sublogo;
	}

	public void setSublogo(String sublogo) {
		this.sublogo = sublogo;
	}

}
