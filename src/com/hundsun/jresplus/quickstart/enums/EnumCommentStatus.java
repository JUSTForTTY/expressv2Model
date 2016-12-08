package com.hundsun.jresplus.quickstart.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 评论状态
 * @author chengy
 *
 */
public enum EnumCommentStatus {
    INIT("init", "待审核"),

    PASS("pass", "审核通过"),

    REJECT("reject", "退回");

    private String code;
    private String description;

    EnumCommentStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public boolean equals(String code) {
        if (this.code.equals(code)) {
            return true;
        }
        return false;
    }

    public boolean equals(EnumCommentStatus enumType) {
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

    public static List<EnumCommentStatus> toList() {
        List<EnumCommentStatus> result = new ArrayList<EnumCommentStatus>();
        for (EnumCommentStatus institution : values()) {
            result.add(institution);
        }
        return result;
    }

    public static Map<String, String> toMap() {
        Map<String, String> enumDataMap = new HashMap<String, String>();
        for (EnumCommentStatus e : EnumCommentStatus.values()) {
            enumDataMap.put(e.getCode(), e.getDescription());
        }
        return enumDataMap;
    }

}
