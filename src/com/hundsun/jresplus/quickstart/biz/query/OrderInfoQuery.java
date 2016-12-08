package com.hundsun.jresplus.quickstart.biz.query;

public class OrderInfoQuery extends BaseQuery {

    /**
     * UID
     */
    private static final long serialVersionUID = -2215588545657972157L;

    private String            orderno;

    private String            username;

    private String            receivername;

    private String            startDate;

    private String            endDate;
    
    private String            payType;

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

}
