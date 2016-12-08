package com.hundsun.jresplus.quickstart.biz.po;

import java.util.List;

/**
 * 类别
 * @author zhouchen
 *
 */
public class Category extends BaseDomain {

    /**
     * UID
     */
    private static final long serialVersionUID = -2500828098304395640L;

    /**
     * 主键id
     */
    private Long              id;

    /**
     * 分类名称
     */
    private String            name;

    /**
     * 说明
     */
    private String            remark;

    /**
     * 排序
     */
    private Long              sort;

    /**
     * 所属分类
     */
    private Long              parent_id;

    /**
     * 图片
     */
    private String            image;

    /**
     *
     */
    private Long              goodsnum;

    /**
     * 
     */
    private int               isopen;

    private String            parent_name;

    private String            url;

    private String            tag1;

    private String            tag2;

    private String            tag3;

    private String            tag4;

    private String            tag5;

    /**
     * 子类目
     */
    private List<Category>    subCategoryList;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Long goodsNum) {
        this.goodsnum = goodsNum;
    }

    public int getIsopen() {
        return isopen;
    }

    public void setIsopen(int isopen) {
        this.isopen = isopen;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public List<Category> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<Category> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }

    public String getTag4() {
        return tag4;
    }

    public void setTag4(String tag4) {
        this.tag4 = tag4;
    }

    public String getTag5() {
        return tag5;
    }

    public void setTag5(String tag5) {
        this.tag5 = tag5;
    }

}
