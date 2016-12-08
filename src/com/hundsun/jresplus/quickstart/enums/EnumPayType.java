package com.hundsun.jresplus.quickstart.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum EnumPayType {
    /**
     * 预存款支付
     */
    PAY_TYPE_PREPAY("1", "预存款支付"),

    /**
     * 到付
     */
    PAY_TYPE_AFTERPAY("4", "货到付款"),

    /**
     * 积分支付
     */
    PAY_TYPE_SCORE("5", "积分支付"),

    /**
     * 支付宝付款
     */
    PAY_TYPE_ALIPAY("6", "支付宝"),
	 /**
     * 云库存取货付款
     */
	PAY_TYPE_YUNKUNCUN("8", "云库存取货");
	 

    private String code;
    private String description;

    EnumPayType(String code, String description) {
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

    public static List<EnumPayType> toList() {
        List<EnumPayType> result = new ArrayList<EnumPayType>();
        for (EnumPayType institution : values()) {
            result.add(institution);
        }
        return result;
    }

    public static Map<String, String> toMap() {
        Map<String, String> enumDataMap = new HashMap<String, String>();
        for (EnumPayType e : EnumPayType.values()) {
            enumDataMap.put(String.valueOf(e.getCode()), e.getDescription());
        }
        return enumDataMap;
    }
}
