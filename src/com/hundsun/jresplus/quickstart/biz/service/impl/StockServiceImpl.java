package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.SequenceDAO;
import com.hundsun.jresplus.quickstart.biz.dao.StockDao;
import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.jresplus.quickstart.biz.po.Stock_Inventory;
import com.hundsun.jresplus.quickstart.biz.query.StockQuery;
import com.hundsun.jresplus.quickstart.biz.service.StockService;
@Service("stockService")
public class StockServiceImpl  implements StockService{
	    @Autowired
	    private StockDao stockDao;
	@Override
	public List<Stock_Inventory> getList(StockQuery query) {
	  
		stockDao.getList(query);
		
		return  null;
	}
	@Override
	public void updateStock(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		
		stockDao.updateOrder(orderDetail);
	}
	@Override
	public Stock_Inventory getById(Stock_Inventory stockInventory) {
	 
		return stockDao.getById(stockInventory);
	}

}
