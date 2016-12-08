package com.hundsun.jresplus.quickstart.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumUsersType {

    BASE_DATA((short) 0, "基础数据"), DEVELOPMENT_LEVEL((short) 1, "开发级"), APPLICATION_LEVEL((short) 2,
                                                                                         "应用级");

    private EnumUsersType(Short code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Short  code;
    private String msg;

    public Short getCode() {
        return code;
    }

    public void setCode(Short code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Map<String, String> toMap() {
        Map<String, String> enumDataMap = new HashMap<String, String>();
        for (EnumUsersType e : EnumUsersType.values()) {
            enumDataMap.put(e.getCode().toString(), e.getMsg());
        }
        return enumDataMap;
    }
}
