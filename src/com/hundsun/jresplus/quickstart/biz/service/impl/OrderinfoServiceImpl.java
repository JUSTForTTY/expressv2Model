/**
* <p>Title: </p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2008</p>
* <p>Company: soft.buylog.cn</p>
* @author :James Lee
* @version 1.0
*/
package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.OrderinfoDAO;
import com.hundsun.jresplus.quickstart.biz.dao.OrderitemDAO;
import com.hundsun.jresplus.quickstart.biz.po.Order;
import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.jresplus.quickstart.biz.po.Orderinfo;
import com.hundsun.jresplus.quickstart.biz.po.Orderitem;
import com.hundsun.jresplus.quickstart.biz.po.SubOrder;
import com.hundsun.jresplus.quickstart.biz.query.OrderInfoQuery;
import com.hundsun.jresplus.quickstart.biz.service.BaseService;
import com.hundsun.jresplus.quickstart.biz.service.OrderinfoService;

@Service("orderinfoService")
public class OrderinfoServiceImpl extends BaseService implements OrderinfoService {
    @Autowired
    private OrderinfoDAO orderinfoDAO;
    @Autowired
    private OrderitemDAO orderitemDAO;

    public List getAllOrderinfo() {
        return (List) orderinfoDAO.findAllOrderinfo();
    }

    public Orderinfo getOrderinfoById(Long id) {
        return orderinfoDAO.findOrderinfoById(id);
    }

    public Orderinfo getOrderinfoByOrdno(String orderno) {
        return orderinfoDAO.findOrderinfoByOrdno(orderno);
    }

    public Orderinfo getOrderinfoByUserGoods(String orderno) {
        return orderinfoDAO.findOrderinfoByOrdno(orderno);
    }

    public List searchOrderinfo(Map map) {
        return (List) orderinfoDAO.searchOrderinfo(map);
    }

    public Integer searchOrderinfoCount(Map map) {
        return orderinfoDAO.searchOrderinfoCount(map);
    }

    public Long addOrderinfo(Orderinfo orderinfo) {
        return orderinfoDAO.addOrderinfo(orderinfo);
    }

    public void removeOrderinfo(Integer id) {
        orderinfoDAO.removeOrderinfo(id);
    }

    public void updateOrderinfo(Orderinfo orderinfo) {
        orderinfoDAO.updateOrderinfo(orderinfo);
    }

    public void updateOrderinfoSpecificField(String field, String fieldVal, Integer id) {
        Map map = new HashMap();
        map.put("field", field);
        map.put("fieldVal", fieldVal);
        map.put("id", id);
        orderinfoDAO.updateOrderinfoSpecificField(map);
    }

    public void updateOrderinfoSpecificField(Map map) {
        orderinfoDAO.updateOrderinfoSpecificField(map);
    }

    public void batUpdateOrderinfoStatus(Map map) {
        orderinfoDAO.batUpdateOrderinfoStatus(map);
    }

    /**
     * 是否要包含商品订单详情
     * @param params
     * @param isContainItems
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Orderinfo> searchOrderinfo(Map params, boolean isContainItems) {
        List<Orderinfo> orderinfos = (List<Orderinfo>) orderinfoDAO.searchOrderinfo(params);
        if (isContainItems) {
            for (Orderinfo orderinfo : orderinfos) {
                orderinfo.setOrderItems(orderitemDAO.findOrderitemsByOrdid(orderinfo.getId()));
            }
        }
        return orderinfos;
    }

    @Override
    public void getPagination(OrderInfoQuery query) {
        orderinfoDAO.getPagination(query);
    }

    @Override
    public List<OrderDetail> getDetailByIdUserId(Long id, Long userId) {
     //   Orderinfo orderinfo = orderinfoDAO.findOrderinfoByIdUserId(id, userId);
      //  if (orderinfo != null) {
    	List<OrderDetail> orderDetail = orderitemDAO.getByOrderInfoId(id);
         //   orderinfo.setOrderItems(orderItemList);
      //  }
        return orderDetail;
    }

    @Override
    public void updateOrderinfoStatus(Long id, int status) {
        orderinfoDAO.updateOrderinfoStatus(id, status);
    }
    @Override
	public Long addNewOrderinfo(Order order) {
		// TODO Auto-generated method stub
		
		
		 return orderinfoDAO.addNewOrderinfo(order);
	}

	@Override
	public Long addNewSubOrderinfo(SubOrder suborder) {
		// TODO Auto-generated method stub
		
		return orderinfoDAO.addNewSubOrderinfo(suborder);
	}

	@Override
	public void getOldPagination(OrderInfoQuery query) {
		// TODO Auto-generated method stub
		orderinfoDAO.getOldPagination(query);
	}

	@Override
	public Orderinfo getOldDetailByIdUserId(Long id, Long userId) {
		// TODO Auto-generated method stub
		   Orderinfo orderinfo = orderinfoDAO.findOldOrderinfoByIdUserId(id, userId);
	        if (orderinfo != null) {
	            List<Orderitem> orderItemList = orderitemDAO.getByOldOrderInfoId(id);
	            orderinfo.setOrderItems(orderItemList);
	        }
	        return orderinfo;
	}
}
