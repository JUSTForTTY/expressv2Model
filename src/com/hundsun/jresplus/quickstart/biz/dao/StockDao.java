package com.hundsun.jresplus.quickstart.biz.dao;

import java.util.List;

import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.jresplus.quickstart.biz.po.Stock_Inventory;
import com.hundsun.jresplus.quickstart.biz.query.StockQuery;

public interface StockDao {

	
	public void  getList(StockQuery query);
	
	public void  updateOrder(OrderDetail query);
	
	public  Stock_Inventory getById(Stock_Inventory stockInventory);
}
