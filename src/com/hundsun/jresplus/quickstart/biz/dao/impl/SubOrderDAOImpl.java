package com.hundsun.jresplus.quickstart.biz.dao.impl;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.SubOrderDAO;
import com.hundsun.jresplus.quickstart.biz.po.SubOrder;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("subOrderDAO")
public class SubOrderDAOImpl extends BaseDAO implements SubOrderDAO {

    private static final String SQL_SPACE = "SUB_ORDER.";

    @Override
    public Long insert(SubOrder subOrder) {
        return (Long) this.getSqlMapClientTemplate().insert(SQL_SPACE + "insert", subOrder);
    }

}
