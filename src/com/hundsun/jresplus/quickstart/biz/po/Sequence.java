package com.hundsun.jresplus.quickstart.biz.po;

/**
 * 
 * @author chengy
 *
 */
public class Sequence extends BaseDomain {
    /**
     * 
     */
    private static final long serialVersionUID = -4014881959379268847L;
    private String            tablename;
    private Integer           seqno;

    public String getTablename() {
        return this.tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;

    }

    public Integer getSeqno() {
        return this.seqno;
    }

    public void setSeqno(Integer seqno) {
        this.seqno = seqno;

    }

}
