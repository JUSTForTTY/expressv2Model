package com.hundsun.jresplus.quickstart.biz.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.StockDao;
import com.hundsun.jresplus.quickstart.biz.po.Stock_Inventory;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.query.StockQuery;
import com.hundsun.jresplus.quickstart.biz.service.StockService;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.hundsun.jresplus.quickstart.biz.dao.GoodsDAO;
import com.hundsun.jresplus.quickstart.biz.po.GoodsCollect;
import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.query.GoodsQuery;
import com.hundsun.jresplus.quickstart.biz.query.NormalGoodsQuery;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("stockDAO")
public class StockDaoImpl  extends BaseDAO  implements StockDao {
	 private static final String SQL_SPACE = "STOCKS.";
	@Override
	public void getList(StockQuery query) {
		//  
		   this.getPagination(query,SQL_SPACE + "stockCount", SQL_SPACE + "stockList");
		 
	}
	@Override
	public void updateOrder(OrderDetail query) {
		//  
		System.out.println(""+query.getId());
		System.out.println(""+query.getGoodsCount());
		
		 this.getSqlMapClientTemplate().update(SQL_SPACE + "updateOrderStock", query);
	}
	@Override
	public Stock_Inventory getById(Stock_Inventory stockInventory) {
		// TODO Auto-generated method stub
		
		
	  return (Stock_Inventory) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE + "getById", stockInventory);
	}
	 

	 

	
}
