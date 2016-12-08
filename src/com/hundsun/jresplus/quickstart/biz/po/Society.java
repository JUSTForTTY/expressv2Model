package com.hundsun.jresplus.quickstart.biz.po;

import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;

/**
 * 社团
 * @author wangxiaochan
 *
 */
public class Society extends BaseDomain {

    /**
     * 主键id
     */
    private Long              id;

    /**
     * 简介
     */
    private String            briefintro;

    /**
     * 商品类型（normal-普通商品；sale-促销商品；provider-企业；society-社团；house-房产；auction-竞价）
     * @see EnumGoodsType
     */
    private String            type;

    /**
     * 商品、企业、社团、房产、竞价的名称
     */
    private String            name;

    /**
     * 缩略图，商品、企业、社团、房产、竞价的logo
     */
    private String            miniature;

    /**
     * 商品、企业、社团、房产、竞价的大图
     */
    private String            image1;

    /**
     * 详细介绍
     */
    private String            detailintro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBriefintro() {
		return briefintro;
	}

	public void setBriefintro(String briefintro) {
		this.briefintro = briefintro;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDetailintro() {
		return detailintro;
	}

	public void setDetailintro(String detailintro) {
		this.detailintro = detailintro;
	}

    
}
