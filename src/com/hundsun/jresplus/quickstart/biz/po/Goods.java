package com.hundsun.jresplus.quickstart.biz.po;

import java.util.Date;
import java.util.List;

import com.hundsun.jresplus.quickstart.enums.EnumGoodsType;

/**
 * 商品（普通商品、促销商品、企业、社团、房产、竞价）
 * @author chengy
 *
 */
public class Goods extends BaseDomain {

    /**
     * UID
     */
    private static final long serialVersionUID = 4854878032704849328L;

    /**
     * 主键id
     */
    private Long              id;

    /**
     * 简介
     */
    private String            briefintro;

    /**
     * 商品类型（normal-普通商品；sale-促销商品；provider-企业；society-社团；house-房产；auction-竞价；integral-积分）
     * @see EnumGoodsType
     */
    private String            type;

    /**
     * 商品、企业、社团、房产、竞价的名称
     */
    private String            name;

    /**
     * 商品别名
     */
    private String            aliasname;

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

    private List<String>      imageList;

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

    /**
     * 状态标识（0-初始状态；1-下载订单、订购量清零；2-录入多余供应量；3-下架）
     */
    private String            status;

    private String            privatecode;

    private Integer           isoutofstock;

    /**
     * 更新时间
     */

    private Date              last_modified;

    private Integer           scoreAdd;                               // 购买后增加的积分数
    
    private Long           memberId;
    
    private String         memberName;
    
    private Long              score; 

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public Integer getScoreAdd() {
        return scoreAdd;
    }

    public void setScoreAdd(Integer scoreAdd) {
        this.scoreAdd = scoreAdd;
    }

    public Date getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Date last_modified) {
        this.last_modified = last_modified;
    }

    public boolean isScoreGoods() {
        return EnumGoodsType.INTEGRAL.getCode().equals(type);
    }

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

    public String getAliasname() {
        return aliasname;
    }

    public void setAliasname(String aliasname) {
        this.aliasname = aliasname;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrivatecode() {
        return privatecode;
    }

    public void setPrivatecode(String privatecode) {
        this.privatecode = privatecode;
    }

    public Integer getIsoutofstock() {
        return isoutofstock;
    }

    public void setIsoutofstock(Integer isoutofstock) {
        this.isoutofstock = isoutofstock;
    }

    public static boolean isInSupply(Goods goods, int num) {
        Long stocknum = goods.getStocknum();
        // 订购数
        Long ordernum = goods.getOrdernum();
        // 库存-订购数
        Long remainnum = (stocknum == null || ordernum == null) ? 0 : (stocknum - ordernum);
        if (goods.getStatus().equals("0") && (remainnum >= num)) {
            return true;
        } else {
            return false;
        }
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

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

}
