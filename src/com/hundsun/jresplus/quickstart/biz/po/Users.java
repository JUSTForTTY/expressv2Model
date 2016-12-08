package com.hundsun.jresplus.quickstart.biz.po;


import java.util.Date;

public class Users {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户登录账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 状态： 0禁用 1启用  2删除
     */
    private Short status;

    /**
     * 用户类型： 1： 开发级 2：应用级 3：其他
     */
    private Short userType;

    /**
     * 最后登录ip
     */
    private String lastLoginIp;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 登录次数
     */
    private Long loginNum;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModify;

    /**
     * 角色id
     */
    private Long[] roleId;
    /**
     * 新密码，修改时用
     */
    private String newPassword ;
    /**
     * 默认子系统
     */
    private Long   defaultSubSys ;

    /**
     * 来源：登录：login，其他:other
     * 
     */
    
    private String source;
    /**
     * 楼宇号 
     * added by zhouc
     */
    private Long   buildingId ;

    public Users(){
    }

    public Users(String account, String password){
    	this.account = account;
    	this.password = password;
    }

    public Users(long id, String account, String password,String lastLoginIp){
    	this.id =id;
    	this.account = account;
    	this.password = password;
    	this.lastLoginIp = lastLoginIp;
    }
    
    
	public Long getDefaultSubSys() {
		return defaultSubSys;
	}

	public void setDefaultSubSys(Long defaultSubSys) {
		this.defaultSubSys = defaultSubSys;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Long[] getRoleId() {
		return roleId;
	}

	public void setRoleId(Long[] roleId) {
		this.roleId = roleId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getUserType() {
		return userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Long getLoginNum() {
		return loginNum;
	}

	public void setLoginNum(Long loginNum) {
		this.loginNum = loginNum;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModify() {
		return gmtModify;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}

   }