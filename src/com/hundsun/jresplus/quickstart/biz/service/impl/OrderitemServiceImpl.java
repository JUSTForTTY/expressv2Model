/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: soft.buylog.cn</p>
 * @author :James Lee
 * @version 1.0
 */
package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.bo.Result;
import com.hundsun.jresplus.quickstart.biz.dao.OrderinfoDAO;
import com.hundsun.jresplus.quickstart.biz.dao.OrderitemDAO;
import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.jresplus.quickstart.biz.po.Orderinfo;
import com.hundsun.jresplus.quickstart.biz.po.Orderitem;
import com.hundsun.jresplus.quickstart.biz.service.BaseService;
import com.hundsun.jresplus.quickstart.biz.service.OrderitemService;
import com.hundsun.jresplus.quickstart.enums.EnumOrderItemStatus;

@Service("orderitemService")
public class OrderitemServiceImpl extends BaseService implements OrderitemService {

    @Autowired
    private OrderitemDAO orderitemDAO;
    @Autowired
    private OrderinfoDAO orderinfoDAO;

    public List searchOrderitem(Map map) {
        return (List) orderitemDAO.searchOrderitem(map);
    }

    public Integer searchOrderitemCount(Map map) {
        return orderitemDAO.searchOrderitemCount(map);
    }

    public List getAllOrderitem() {
        return (List) orderitemDAO.findAllOrderitem();
    }

    public List getOrderitemsByOrdid(Long orderinfo_id) {
        return (List) orderitemDAO.findOrderitemsByOrdid(orderinfo_id);
    }

    public OrderDetail getOrderitemById(Long id) {
        return orderitemDAO.findOrderitemById(id);
    }

    public void addOrderitem(Orderitem orderitem) {
        orderitemDAO.addOrderitem(orderitem);
    }

    public void removeOrderitem(Integer id) {
        orderitemDAO.removeOrderitem(id);
    }

    public void updateOrderitem(Orderitem orderitem) {
        orderitemDAO.updateOrderitem(orderitem);
    }

    public void updateStatusByOrderInfoId(long orderinfoId, String status) {
        orderitemDAO.updateStatusByOrderInfoId(orderinfoId, status);
    }

    public void updateStatusById(long id, String status) {
        orderitemDAO.updateStatusById(id, status);
    }

    public int searchOrderitemSumCount(Map map) {
        return orderitemDAO.searchOrderitemSumCount(map);
    }

    public List searchOrderitemSum(Map map) {
        return (List) orderitemDAO.searchOrderitemSum(map);
    }

    @Override
    public Long receive(Long itemId, Long userId) {
        Orderitem item = orderitemDAO.getById(itemId);
        Long infoId = item.getOrderinfo_id();
        Orderinfo orderinfo = orderinfoDAO.findOrderinfoByIdUserId(infoId, userId);
        if (orderinfo != null) {
            orderitemDAO.updateStatusById(itemId, EnumOrderItemStatus.RECEIVED.getCode());
            return infoId;
        }
        return null;
    }
    
    @Override
	public void addNewOrderitem(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		
		
		  orderitemDAO.addNewOrderitem(orderDetail);
		
		
	}

	@Override
	public Orderitem getOldOrderitemById(Long id) {
		// TODO Auto-generated method stub
		 return orderitemDAO.findOldOrderitemById(id);
	}

}
