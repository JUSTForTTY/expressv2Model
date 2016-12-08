package com.hundsun.jresplus.quickstart.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum EnumPrepayType {
    /**
     * 充值
     */
    PAY_TYPE_PREPAY("prepay", "充值"),

    /**
     * 扣款
     */
    PAY_TYPE_ANTIPAY("antipay", "扣款"),

    /**
     * 订单支付
     */
    PAY_TYPE_PAYMENT("payment", "订单支付"),
	
	/**
     * 订单支付
     */
    PAY_TYPE_SCORE("score", "积分支付");

    private String code;
    private String description;

    EnumPrepayType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public boolean equals(String code) {
        if (this.code.equals(code)) {
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

    public static List<EnumPrepayType> toList() {
        List<EnumPrepayType> result = new ArrayList<EnumPrepayType>();
        for (EnumPrepayType institution : values()) {
            result.add(institution);
        }
        return result;
    }

    public static Map<String, String> toMap() {
        Map<String, String> enumDataMap = new HashMap<String, String>();
        for (EnumPrepayType e : EnumPrepayType.values()) {
            enumDataMap.put(String.valueOf(e.getCode()), e.getDescription());
        }
        return enumDataMap;
    }
}
