package com.hundsun.jresplus.quickstart.biz.po;

public class Response {
  private int errCode;
  
  private Object body;

  public int getErrCode() {
    return errCode;
  }

  public void setErrCode(int errCode) {
    this.errCode = errCode;
  }

  public Object getBody() {
    return body;
  }

  public void setBody(Object body) {
    this.body = body;
  }
}
