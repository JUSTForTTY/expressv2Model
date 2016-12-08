package com.hundsun.jresplus.quickstart.biz.bo;

import com.hundsun.jresplus.quickstart.biz.po.User;

public class UserRegister extends User {

    /**
     * UID
     */
    private static final long serialVersionUID = -7492575766804851668L;

    private String            passwdConfirm;

    public String getPasswdConfirm() {
        return passwdConfirm;
    }

    public void setPasswdConfirm(String passwdConfirm) {
        this.passwdConfirm = passwdConfirm;
    }

}
