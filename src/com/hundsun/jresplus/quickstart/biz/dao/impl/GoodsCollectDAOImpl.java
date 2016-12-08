package com.hundsun.jresplus.quickstart.biz.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.GoodsCollectDAO;
import com.hundsun.jresplus.quickstart.biz.po.GoodsCollect;
import com.hundsun.jresplus.quickstart.biz.query.GoodsCollectQuery;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("goodsCollectDAO")
public class GoodsCollectDAOImpl extends BaseDAO implements GoodsCollectDAO {

    private static final String SQL_SPACE = "GOODS_COLLECT.";

    @Override
    public Long insert(GoodsCollect collect) {
        return (Long) this.getSqlMapClientTemplate().insert(SQL_SPACE + "insert", collect);
    }

    @Override
    public void getPagination(GoodsCollectQuery query) {
        this.getPagination(query, SQL_SPACE + "getPaginationCount", SQL_SPACE + "getPaginationList");
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<GoodsCollect> queryList(GoodsCollectQuery query) {
        return this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "queryList", query);
    }

    @Override
    public int deleteById(Long id) {
        return this.getSqlMapClientTemplate().delete(SQL_SPACE + "deleteById", id);
    }

    @Override
	public int collectPeople(Long id) {
		// TODO Auto-generated method stub
		return (Integer) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE+"collectPeople",id);
	}

}
