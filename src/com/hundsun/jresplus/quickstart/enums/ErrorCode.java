package com.hundsun.jresplus.quickstart.enums;

import java.util.ArrayList;
import java.util.List;

public enum ErrorCode {
    SUCCESS((int)1001,"成功"),
    PARAM_ERROR((int)1002,"参数错误"),
    PARAM_EMPTY((int)1003,"参数为空"),
    SYSTEM_UNKNOW((int)1004,"系统未知错误");
    
    private int code;
    
    private String desc;
    
    ErrorCode(int code, String desc){
      this.code = code;
      this.desc = desc;
    }

    public int getCode() {
      return code;
    }

    public void setCode(int code) {
      this.code = code;
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }
    
    public static List<ErrorCode> toList() {
      List<ErrorCode> result = new ArrayList<ErrorCode>();
      for (ErrorCode institution : values()) {
          result.add(institution);
      }
      return result;
  }

    
}
