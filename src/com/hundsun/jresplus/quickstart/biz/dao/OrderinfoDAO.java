package com.hundsun.jresplus.quickstart.biz.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.po.Order;
import com.hundsun.jresplus.quickstart.biz.po.Orderinfo;
import com.hundsun.jresplus.quickstart.biz.po.SubOrder;
import com.hundsun.jresplus.quickstart.biz.query.OrderInfoQuery;

public interface OrderinfoDAO {

    public List findAllOrderinfo();

    public Orderinfo findOrderinfoById(Long id);

    public Orderinfo findOrderinfoByOrdno(String orderno);

    public List searchOrderinfo(Map map);

    public Integer searchOrderinfoCount(Map map);

    public Long addOrderinfo(Orderinfo orderinfo);

    public void removeOrderinfo(Integer id);

    public void updateOrderinfo(Orderinfo orderinfo);

    public void updateOrderinfoSpecificField(Map map);

    public void batUpdateOrderinfoStatus(Map map);

    public void getPagination(OrderInfoQuery query);

    public void getOldPagination(OrderInfoQuery query);
    
    public Orderinfo findOrderinfoByIdUserId(Long id, Long userId);
    
    public Orderinfo findOldOrderinfoByIdUserId(Long id, Long userId);

    public void updateOrderinfoStatus(Long id, int status);
  //新订单下单
    public Long addNewOrderinfo(Order order);
    
    //新订单下单suborder
    public Long addNewSubOrderinfo(SubOrder suborder);
    
}
