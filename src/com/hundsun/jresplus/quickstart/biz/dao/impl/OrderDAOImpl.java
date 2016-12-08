package com.hundsun.jresplus.quickstart.biz.dao.impl;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.OrderDAO;
import com.hundsun.jresplus.quickstart.biz.po.Order;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("orderDAO")
public class OrderDAOImpl extends BaseDAO implements OrderDAO {

    private static final String SQL_SPACE = "ORDER.";

    @Override
    public Long insert(Order order) {
        return (Long) this.getSqlMapClientTemplate().insert(SQL_SPACE + "insert", order);
    }
}
