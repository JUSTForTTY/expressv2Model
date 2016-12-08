package com.hundsun.jresplus.quickstart.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单状态
 * @author chengy
 *
 */
public enum EnumOrderItemStatus {
    INIT("init", "初始化"),

    PAID("paid", "已付款"),

    DELIVERYING("deliverying", "配送中"),

    RECEIVED("received", "已收货"),

    COMMENTED("commented", "已评论");

    private String code;
    private String description;

    EnumOrderItemStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public boolean equals(String code) {
        if (this.code.equals(code)) {
            return true;
        }
        return false;
    }

    public boolean equals(EnumOrderItemStatus enumType) {
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

    public static List<EnumOrderItemStatus> toList() {
        List<EnumOrderItemStatus> result = new ArrayList<EnumOrderItemStatus>();
        for (EnumOrderItemStatus institution : values()) {
            result.add(institution);
        }
        return result;
    }

    public static Map<String, String> toMap() {
        Map<String, String> enumDataMap = new HashMap<String, String>();
        for (EnumOrderItemStatus e : EnumOrderItemStatus.values()) {
            enumDataMap.put(e.getCode(), e.getDescription());
        }
        return enumDataMap;
    }

}
