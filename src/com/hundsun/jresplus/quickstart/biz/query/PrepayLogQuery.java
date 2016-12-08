package com.hundsun.jresplus.quickstart.biz.query;

/**
 * 
 * @author chengy
 * @version $Id: PrepayLogQuery.java,v 0.1 2015年5月31日 下午8:51:05 chengy Exp $
 */
public class PrepayLogQuery extends BaseQuery {

    private static final long serialVersionUID = 434854591405502156L;

    private Long              userId;

    private String            payType;

    private String            startDate;

    private String            endDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
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

}
