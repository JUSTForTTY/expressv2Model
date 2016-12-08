package com.hundsun.jresplus.quickstart.biz.bo;

/**
 * 
 * @author chengy
 * @version $Id: Result.java,v 0.1 2015年5月26日 上午8:21:19 chengy Exp $
 */
public class Result {

    private boolean isSuccess = true;

    private String  message;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean result) {
        this.isSuccess = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
