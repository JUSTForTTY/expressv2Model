package com.hundsun.jresplus.quickstart.biz.dao.impl;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.PrepayLogDAO;
import com.hundsun.jresplus.quickstart.biz.po.PrepayLog;
import com.hundsun.jresplus.quickstart.biz.query.PrepayLogQuery;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("prepayLogDAO")
public class PrepayLogDAOImpl extends BaseDAO implements PrepayLogDAO {

    private static final String SQL_SPACE = "PREPAY_LOG.";

    public Long addPrepaylog(PrepayLog prepaylog) {
        Long id = (Long) this.getSqlMapClientTemplate().insert(SQL_SPACE + "insertPrepaylog",
            prepaylog);
        return id;
    }

    @Override
    public void getPagination(PrepayLogQuery query) {
        this.getPagination(query, SQL_SPACE + "getPaginationCount", SQL_SPACE + "getPaginationList");

    }

}
