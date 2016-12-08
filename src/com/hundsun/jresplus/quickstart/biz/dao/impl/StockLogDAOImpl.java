package com.hundsun.jresplus.quickstart.biz.dao.impl;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.StockLogDAO;
import com.hundsun.jresplus.quickstart.biz.po.Stock_Log;
import com.hundsun.network.common.dao.BaseDAO;
@Repository("stockLogDAO")
public class StockLogDAOImpl extends BaseDAO implements  StockLogDAO {
 private final String SQL_SPACE="STOCKLOG.";
	@Override
	public String addStockLog(Stock_Log log) {
		// TODO Auto-generated method stub
	
		String importBillID= (String) this.getSqlMapClientTemplate().insert(SQL_SPACE + "insertStocklog",
	           log);
	        return importBillID;
	    }
	@Override
	public void updateStockLog(Stock_Log log) {
		// TODO Auto-generated method stub
		  this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "updateStockLog", log);
			}
	}


