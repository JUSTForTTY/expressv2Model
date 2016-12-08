package com.hundsun.jresplus.quickstart.biz.service;

import java.util.List;

import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.jresplus.quickstart.biz.po.Stock_Inventory;
import com.hundsun.jresplus.quickstart.biz.query.StockQuery;

public interface StockService {
 
	   public List<Stock_Inventory> getList(StockQuery query);
	   
	   public void updateStock(OrderDetail orderDetail);
	   
	   public  Stock_Inventory   getById(Stock_Inventory stockInventory);
}
