package com.hundsun.jresplus.quickstart.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumUserStatus {

    DELETE_STATUS((short) 2, "黑名单"), NORMAL((short) 1, "启用"), INIT((short) 0, "初始化");

    private short  code;

    private String desc;

    public short getCode() {
        return code;
    }

    public void setCode(short code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    EnumUserStatus(short code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Map<String, String> toMap() {
        Map<String, String> enumDataMap = new HashMap<String, String>();
        for (EnumUserStatus e : EnumUserStatus.values()) {
            enumDataMap.put(String.valueOf(e.getCode()), e.getDesc());
        }
        return enumDataMap;
    }
}
