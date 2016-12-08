package com.hundsun.jresplus.quickstart.common;

import java.io.Serializable;
import java.math.BigDecimal;

import com.hundsun.jresplus.quickstart.biz.bo.TradeCart;
import com.hundsun.jresplus.quickstart.biz.po.User;
import com.hundsun.jresplus.quickstart.biz.po.Users;
import com.hundsun.jresplus.quickstart.enums.PermissionEnum;

/**
 * 
 * @author zhangsen
 *
 */
public class UserAgent implements Serializable {

    /**
     * 
     */
    private static final long  serialVersionUID = -7624896849738328677L;

    public static final String AGENT            = "userAgent";

    private Long               id;

    private String             realName;
    private String             nickName;

    private String             userName;

    private Long               prepay;                                  // 预存款

    private Long               score;                                   // 积分

    //added by zhouchen
    private Long               buildingId       = 0L;
    
    //add by tty
    private  String             openid;
     
    private String             member_id;

    public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getMember_id() {
		return member_id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	private TradeCart          tradeCart        = new TradeCart();

    public UserAgent() {
        super();
    }

    public UserAgent(Users users) {
        if (users != null) {
            this.id = users.getId();
            this.realName = users.getName();
            this.userName = users.getAccount();
            this.setBuildingId(users.getBuildingId());
        }
    }

    public UserAgent(User user) {
        if (user != null) {
            this.id = user.getId();
            this.realName = user.getRealname();
            this.userName = user.getUsername();
            this.nickName = user.getNickname();
            this.score = user.getScore();
            this.prepay = new BigDecimal(Double.valueOf(user.getPrepay())).movePointRight(2)
                .longValue();
            this.setBuildingId(user.getBuildingId());
            this.member_id=user.getMember_id();
            
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    /**
     * 判断用户是否有权限
     * @param em
     * @return
     */
    public boolean havePermission(PermissionEnum em) {
        return true;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public TradeCart getTradeCart() {
        return tradeCart;
    }

    public void setTradeCart(TradeCart tradeCart) {
        this.tradeCart = tradeCart;
    }

    public Long getPrepay() {
        return prepay;
    }

    public void setPrepay(Long prepay) {
        this.prepay = prepay;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

}
