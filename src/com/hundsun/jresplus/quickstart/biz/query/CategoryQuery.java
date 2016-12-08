package com.hundsun.jresplus.quickstart.biz.query;

public class CategoryQuery extends BaseQuery {

    /**
     * UID
     */
    private static final long serialVersionUID = -5606782018100144859L;

    private String            name;

    private Long			  buildingId;

    private Long categoryId;
    
    private Long parentId;
    
    private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
}
