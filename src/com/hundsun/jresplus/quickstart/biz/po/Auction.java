package com.hundsun.jresplus.quickstart.biz.po;

import java.util.Date;

import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;

public class Auction extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1013029656587894172L;
	
	private Date createtime;
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
     * 商品、企业、社团、房产、竞价的大图
     */
    private String            image2;
    /**
     * 商品、企业、社团、房产、竞价的大图
     */
    private String            image3;
    /**
     * 商品、企业、社团、房产、竞价的大图
     */
    private String            image4;
    /**
     * 商品、企业、社团、房产、竞价的大图
     */
    private String            image5;

    /**
     * 单位
     */
    private String            unit;

    /**
     * 市场价
     */
    private Double            refprice;

    /**
     * 邻居价、促销价（如果作为普通商品该字段为空，则为面议）
     */
    private Double            price;

    /**
     * 详细介绍
     */
    private String            detailintro;

    /**
     * 订购数量
     */
    private Long              ordernum;

    /**
     * 库存数量
     */
    private Long              stocknum;

    /**
     * 供应企业id
     */
    private Long              providerId;
    
    private Long              viewnum;
    
    private Long              salenum;
    
    
    public Long getViewnum() {
		return viewnum;
	}

	public void setViewnum(Long viewnum) {
		this.viewnum = viewnum;
	}

	public Long getSalenum() {
		return salenum;
	}

	public void setSalenum(Long salenum) {
		this.salenum = salenum;
	}

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

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getRefprice() {
        return refprice;
    }

    public void setRefprice(Double refprice) {
        this.refprice = refprice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDetailintro() {
        return detailintro;
    }

    public void setDetailintro(String detailintro) {
        this.detailintro = detailintro;
    }

    public Long getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Long ordernum) {
        this.ordernum = ordernum;
    }

    public Long getStocknum() {
        return stocknum;
    }

    public void setStocknum(Long stocknum) {
        this.stocknum = stocknum;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	

}
