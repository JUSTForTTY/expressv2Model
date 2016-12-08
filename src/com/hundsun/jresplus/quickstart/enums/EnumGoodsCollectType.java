package com.hundsun.jresplus.quickstart.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 收藏类型
 * @author chengy
 *
 */
public enum EnumGoodsCollectType {
    /**
     * 普通商品
     */
    NORMAL("normal", "普通商品"),

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
    SCORE("score", "积分商品");

    private String code;
    private String description;

    EnumGoodsCollectType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public boolean equals(String code) {
        if (this.code.equals(code)) {
            return true;
        }
        return false;
    }

    public boolean equals(EnumGoodsCollectType enumType) {
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

    public static List<EnumGoodsCollectType> toList() {
        List<EnumGoodsCollectType> result = new ArrayList<EnumGoodsCollectType>();
        for (EnumGoodsCollectType institution : values()) {
            result.add(institution);
        }
        return result;
    }

    public static Map<String, String> toMap() {
        Map<String, String> enumDataMap = new HashMap<String, String>();
        for (EnumGoodsCollectType e : EnumGoodsCollectType.values()) {
            enumDataMap.put(String.valueOf(e.getCode()), e.getDescription());
        }
        return enumDataMap;
    }

}
