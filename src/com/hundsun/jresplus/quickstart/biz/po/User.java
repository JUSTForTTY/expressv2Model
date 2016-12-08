package com.hundsun.jresplus.quickstart.biz.po;

import java.util.Date;

import com.hundsun.jresplus.quickstart.enums.EnumUserStatus;

/**
 * @author chengy
 * 
 */
public class User extends BaseDomain {
    /**
     * UID
     */
    private static final long serialVersionUID = 530171680853898946L;
    /**
     * 注册id
     */
    private Long              id;
    private String            username;
    private String            nickname;
    private String            passwd;
    private String            userquestion;
    private String            useranswer;
    private String            realname;
    private String            contactor;
    public String getContactor() {
		return contactor;
	}

	public void setContactor(String contactor) {
		this.contactor = contactor;
	}

	private String            gender;
    private String            tel;
    private String            email;
    private String            qq;
    private String            mobile;
    private String            address;
    private double            prepay;
    private Long              score;
    private Date              regtime;
    private Short             usertype;
    private Long              companyId;
    private Short             status;
    private Long              creatorId;
    private Date              createtime;
    private Long              recuserId;
    private String            recusername;
    private Long              buildingId;
    private String            cardId;
    //add by tty 
    private String             openId;
    private String             member_id;

    public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public boolean isNormal() {
        return EnumUserStatus.NORMAL.getCode() == status;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd
     *            the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @return the userquestion
     */
    public String getUserquestion() {
        return userquestion;
    }

    /**
     * @param userquestion
     *            the userquestion to set
     */
    public void setUserquestion(String userquestion) {
        this.userquestion = userquestion;
    }

    /**
     * @return the useranswer
     */
    public String getUseranswer() {
        return useranswer;
    }

    /**
     * @param useranswer
     *            the useranswer to set
     */
    public void setUseranswer(String useranswer) {
        this.useranswer = useranswer;
    }

    /**
     * @return the realname
     */
    public String getRealname() {
        return realname;
    }

    /**
     * @param realname
     *            the realname to set
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     *            the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     *            the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     *            the qq to set
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     *            the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the prepay
     */
    public double getPrepay() {
        return prepay;
    }

    /**
     * @param prepay
     *            the prepay to set
     */
    public void setPrepay(double prepay) {
        this.prepay = prepay;
    }

    /**
     * @return the score
     */
    public Long getscore() {
        return score;
    }

    /**
     * @param score
     *            the score to set
     */
    public void setscore(Long score) {
        this.score = score;
    }

    /**
     * @return the regtime
     */
    public Date getRegtime() {
        return regtime;
    }

    /**
     * @param regtime
     *            the regtime to set
     */
    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    /**
     * @return the usertype
     */
    public int getUsertype() {
        return usertype;
    }

    /**
     * @param usertype
     *            the usertype to set
     */
    public void setUsertype(Short usertype) {
        this.usertype = usertype;
    }

    /**
     * @return the companyId
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     *            the companyId to set
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * @return the creatorId
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId
     *            the creatorId to set
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * @return the createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     *            the createtime to set
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return the recuserId
     */
    public Long getRecuserId() {
        return recuserId;
    }

    /**
     * @param recuserId
     *            the recuserId to set
     */
    public void setRecuserId(Long recuserId) {
        this.recuserId = recuserId;
    }

    /**
     * @return the recusername
     */
    public String getRecusername() {
        return recusername;
    }

    /**
     * @param recusername
     *            the recusername to set
     */
    public void setRecusername(String recusername) {
        this.recusername = recusername;
    }

    /**
     * @return the buildingId
     */
    public Long getBuildingId() {
        return buildingId;
    }

    /**
     * @param buildingId
     *            the buildingId to set
     */
    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * @return the cardId
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * @param cardId
     *            the cardId to set
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

}
