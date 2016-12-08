package com.hundsun.jresplus.quickstart.biz.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.OrderitemDAO;
import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.jresplus.quickstart.biz.po.Orderitem;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("orderitemDAO")
public class OrderitemDAOImpl extends BaseDAO implements OrderitemDAO {

    private static final String SQL_SPACE = "Orderitem.";

    public List searchOrderitem(Map map) {
        List list = this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "searchOrderitem", map);
        return list;
    }

    public Integer searchOrderitemCount(Map map) {

        return (Integer) this.getSqlMapClientTemplate().queryForObject(
            SQL_SPACE + "searchOrderitemCount", map);

    }

    public List findAllOrderitem() {
        List list = this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "selectAllOrderitem",
            null);
        return list;
    }

    public List findOrderitemsByOrdid(Long orderinfo_id) {
        List list = this.getSqlMapClientTemplate().queryForList(
            SQL_SPACE + "selectOrderitemsByOrdid", orderinfo_id);

        return list;
    }

    public OrderDetail findOrderitemById(Long id) {
    	
    	OrderDetail orderDetail = (OrderDetail) this.getSqlMapClientTemplate().queryForObject(
            "ORDER_DETAIL." + "getById", id);

        return orderDetail;
    }

    public void addOrderitem(Orderitem orderitem) {

        this.getSqlMapClientTemplate().insert(SQL_SPACE + "insertOrderitem", orderitem);

    }

    public void removeOrderitem(Integer id) {

        this.getSqlMapClientTemplate().delete(SQL_SPACE + "deleteOrderitem", id);

    }

    public void updateOrderitem(Orderitem orderitem) {

        this.getSqlMapClientTemplate().update(SQL_SPACE + "updateOrderitem", orderitem);

    }

    public Integer searchOrderitemSumCount(Map map) {
        return (Integer) this.getSqlMapClientTemplate().queryForObject(
            SQL_SPACE + "searchOrderitemSumCount", map);
    }

    public List searchOrderitemSum(Map map) {
        List list = this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "searchOrderitemSum",
            map);

        return list;
    }

    /**
     * 更新orderitem的订单状态
     * @param orderInfoId
     * @param status
     */
    public void updateStatusByOrderInfoId(Long orderInfoId, String status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", status);
        map.put("orderinfo_id", orderInfoId);
        this.getSqlMapClientTemplate().update(SQL_SPACE + "updateStatusByOrderInfoId", map);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderDetail> getByOrderInfoId(Long orderId) {
    	
        return this.getSqlMapClientTemplate().queryForList("ORDER_DETAIL." + "getByOrderId", orderId);
    }

    @Override
    public void updateStatusById(Long orderItemId, String status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", status);
        map.put("id", orderItemId);
        this.getSqlMapClientTemplate().update(SQL_SPACE + "updateStatusByOrderItemId", map);
    }

    @Override
    public Orderitem getById(Long itemId) {
        return (Orderitem) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE + "getById",
            itemId);
    }
    

	@Override
	public void addNewOrderitem(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		 this.getSqlMapClientTemplate().insert(SQL_SPACE + "insertNewOrderitem", orderDetail);
		
	}

	@Override
	  public List<Orderitem> getByOldOrderInfoId(Long id) {
        return this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "getByOrderInfoId", id);
    }

	@Override
	public Orderitem findOldOrderitemById(Long id) {
		// TODO Auto-generated method stub
		 Orderitem orderitem = (Orderitem) this.getSqlMapClientTemplate().queryForObject(
		            SQL_SPACE + "selectOrderitemById", id);

		        return orderitem;
	}
}
