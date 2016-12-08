package com.hundsun.jresplus.quickstart.biz.dao.impl;
import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.StockDetailLogDAO;
import com.hundsun.jresplus.quickstart.biz.po.Stock_Detail_Log;
import com.hundsun.network.common.dao.BaseDAO;
@Repository("stockDetailLogDAO")
public class StockDetailLogDAOImpl  extends BaseDAO implements StockDetailLogDAO{
	 private static final String SQL_SPACE = "StockDetailLog.";
	@Override
	public void insert(Stock_Detail_Log sdl) {
		// TODO Auto-generated method stub
		   this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "insertStockDetailLog", sdl);
	}

}
