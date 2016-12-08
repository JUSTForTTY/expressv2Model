package com.hundsun.jresplus.quickstart.biz.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.FastDAO;
import com.hundsun.jresplus.quickstart.biz.po.Fast;
import com.hundsun.network.common.dao.BaseDAO;
@Repository("fastDAO")
public class FastDAOImpl extends BaseDAO implements FastDAO{
	 private static final String SQL_SPACE = "FAST.";

	@Override
	public List<Fast> getfast(Long buildingId) {
		// TODO Auto-generated method stub
		return this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "queryList",buildingId);
	}
	


}
