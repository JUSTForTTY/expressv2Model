package com.hundsun.jresplus.quickstart.biz.dao;

import com.hundsun.jresplus.quickstart.biz.po.Stock_Log;

public interface StockLogDAO {

	public String addStockLog(Stock_Log log);

	public void updateStockLog(Stock_Log log);

}
