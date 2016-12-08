package com.hundsun.jresplus.quickstart.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.StockDetailLogDAO;
import com.hundsun.jresplus.quickstart.biz.po.Stock_Detail_Log;
import com.hundsun.jresplus.quickstart.biz.service.BaseService;
import com.hundsun.jresplus.quickstart.biz.service.StockDetailLogService;
@Service("stockDetailLogService")
public class StockDetailLogServiceImpl  extends BaseService implements StockDetailLogService{
	  @Autowired
	private   StockDetailLogDAO  stockDetailLogDAO ;
	@Override
	public void addDetaillog(Stock_Detail_Log sdl) {
		// TODO Auto-generated method stub
		stockDetailLogDAO.insert(sdl);
	}

}
