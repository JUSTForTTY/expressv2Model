package com.hundsun.jresplus.quickstart.biz.dao.impl;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.OrderDetailDAO;
import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("orderDetailDAO")
public class OrderDetailDAOImpl extends BaseDAO implements OrderDetailDAO {

    private static final String SQL_SPACE = "ORDER_DETAIL.";

    @Override
    public Long insert(OrderDetail detail) {
        return (Long) this.getSqlMapClientTemplate().insert(SQL_SPACE + "insert", detail);
    }

}
