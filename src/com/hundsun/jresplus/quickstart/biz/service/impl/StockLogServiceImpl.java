package com.hundsun.jresplus.quickstart.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.GoodsDAO;
import com.hundsun.jresplus.quickstart.biz.dao.StockLogDAO;
import com.hundsun.jresplus.quickstart.biz.po.Stock_Log;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.service.BaseService;
import com.hundsun.jresplus.quickstart.biz.service.StockLogService;
@Service("stockLogService")
public class StockLogServiceImpl extends BaseService implements StockLogService{
	 @Autowired
	    private StockLogDAO stockLogDAO;
	@Override
	public String addStockLog(Stock_Log log) {
		// TODO Auto-generated method stub
	
		
		
		return stockLogDAO.addStockLog(log);
	}
	@Override
	public void updateStockLog(Stock_Log log) {
		// TODO Auto-generated method stub
		stockLogDAO.updateStockLog(log);
	}

}
