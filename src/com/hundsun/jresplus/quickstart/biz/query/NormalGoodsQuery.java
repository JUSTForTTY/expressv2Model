package com.hundsun.jresplus.quickstart.biz.query;

import java.util.ArrayList;
import java.util.List;

public class NormalGoodsQuery extends BaseQuery {
    /**
     * UUID
     */
    private static final long serialVersionUID = 1848806087494527190L;

    private String            name;

    private String            aliasname;

    private String            type;

    private Long              parentId;

    private Long              buildingId;

    private Long              categoryId;

    private List<String>      types            = new ArrayList<String>();

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAliasname() {
        return aliasname;
    }

    public void setAliasname(String aliasname) {
        this.aliasname = aliasname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void addType(String type) {
        types.add(type);
    }
}
