package com.hundsun.jresplus.quickstart.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品类型
 * @author chengy
 *
 */
public enum EnumGoodsType {
    /**
     * 普通商品
     */
    NORMAL("normal", "普通商品"),

    /**
     * 促销商品
     */
    SALE("sale", "促销商品"),

    /**
     * 企业
     */
    PROVIDER("provider", "企业"),

    /**
     * 社团
     */
    SOCIETY("society", "社团"),

    /**
     * 房产
     */
    HOUSE("house", "房产"),

    /**
     * 竞价
     */
    AUCTION("auction", "竞价"),

    /**
     * 积分商品
     */
    INTEGRAL("score", "积分");

    private String code;
    private String description;

    EnumGoodsType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public boolean equals(String code) {
        if (this.code.equals(code)) {
            return true;
        }
        return false;
    }

    public boolean equals(EnumGoodsType enumType) {
        if (enumType != null && this.code.equals(enumType.getCode())) {
            return true;
        }
        return false;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static List<EnumGoodsType> toList() {
        List<EnumGoodsType> result = new ArrayList<EnumGoodsType>();
        for (EnumGoodsType institution : values()) {
            result.add(institution);
        }
        return result;
    }

}
