package com.hundsun.jresplus.quickstart.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.OrderinfoDAO;
import com.hundsun.jresplus.quickstart.biz.po.Order;
import com.hundsun.jresplus.quickstart.biz.po.Orderinfo;
import com.hundsun.jresplus.quickstart.biz.po.SubOrder;
import com.hundsun.jresplus.quickstart.biz.query.OrderInfoQuery;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("orderinfoDAO")
public class OrderinfoDAOImpl extends BaseDAO implements OrderinfoDAO {
    private static final String SQL_SPACE = "Orderinfo.";

    public List findAllOrderinfo() {
        List list = this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "selectAllOrderinfo",
            null);
        return list;
    }

    public Orderinfo findOrderinfoById(Long id) {
        Orderinfo orderinfo = (Orderinfo) this.getSqlMapClientTemplate().queryForObject(
            SQL_SPACE + "selectOrderinfoById", id);

        return orderinfo;
    }

    public Orderinfo findOrderinfoByOrdno(String orderno) {
        Orderinfo orderinfo = (Orderinfo) this.getSqlMapClientTemplate().queryForObject(
            SQL_SPACE + "selectOrderinfoByOrdno", orderno);
        return orderinfo;
    }

    public List searchOrderinfo(Map map) {
        List list = this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "searchOrderinfo", map);

        return list;
    }

    public Integer searchOrderinfoCount(Map map) {
        return (Integer) this.getSqlMapClientTemplate().queryForObject(
            SQL_SPACE + "searchOrderinfoCount", map);
    }

    public Long addOrderinfo(Orderinfo orderinfo) {
        Long id = (Long) this.getSqlMapClientTemplate().insert(SQL_SPACE + "insertOrderinfo",
            orderinfo);
        return id;
    }

    public void removeOrderinfo(Integer id) {
        this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "deleteOrderinfo", id);

    }

    public void updateOrderinfo(Orderinfo orderinfo) {
        this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "updateOrderinfo", orderinfo);

    }

    public void updateOrderinfoSpecificField(Map map) {
        this.getSqlMapClientTemplate().update(SQL_SPACE + "updateOrderinfoSpecificField", map);

    }

    public void batUpdateOrderinfoStatus(Map map) {
        this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "batUpdateOrderinfoStatus", map);

    }

    @Override
    public void getPagination(OrderInfoQuery query) {
        this.getPagination(query, "ORDER." + "queryOrderInfoCount", "ORDER."
                                                                     + "queryOrderInfoList");
    }
    
    @Override
    public void getOldPagination(OrderInfoQuery query) {
        this.getPagination(query, SQL_SPACE + "queryOrderInfoCount", SQL_SPACE
                                                                     + "queryOrderInfoList");
    }

    @Override
    public Orderinfo findOrderinfoByIdUserId(Long id, Long userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("userId", userId);
        return (Orderinfo) this.getSqlMapClientTemplate().queryForObject(
            "ORDER." + "getById", map);
    }

    public Orderinfo findOldOrderinfoByIdUserId(Long id, Long userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("userId", userId);
        return (Orderinfo) this.getSqlMapClientTemplate().queryForObject(
            SQL_SPACE + "findOrderinfoByIdUserId", map);
    }
    @Override
    public void updateOrderinfoStatus(Long id, int status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("status", status);
        this.getSqlMapClientTemplate().update(SQL_SPACE + "updateOrderinfoStatus", map);
    }
    
    @Override
	public Long addNewOrderinfo(Order neworder) {
		// TODO Auto-generated method stub
		
		
		 Long id = (Long) this.getSqlMapClientTemplate().insert(SQL_SPACE + "insertNewOrderinfo",
				 neworder);
		   return id;
	}

	@Override
	public Long addNewSubOrderinfo(SubOrder suborder) {
		// TODO Auto-generated method stub
		
		 Long id = (Long) this.getSqlMapClientTemplate().insert(SQL_SPACE + "insertNewSubOrderinfo",
				 suborder);
		   return id;
	}
	
}
