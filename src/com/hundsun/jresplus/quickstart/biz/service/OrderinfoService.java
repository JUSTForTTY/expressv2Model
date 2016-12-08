package com.hundsun.jresplus.quickstart.biz.service;

import java.util.List;
import java.util.Map;

import com.hundsun.jresplus.quickstart.biz.po.Order;
import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.jresplus.quickstart.biz.po.Orderinfo;
import com.hundsun.jresplus.quickstart.biz.po.SubOrder;
import com.hundsun.jresplus.quickstart.biz.query.OrderInfoQuery;

/**
 * 
 * @author chengy
 *
 */
public interface OrderinfoService {
    public List getAllOrderinfo();

    public Orderinfo getOrderinfoById(Long id);

    public Orderinfo getOrderinfoByOrdno(String orderno);

    public Orderinfo getOrderinfoByUserGoods(String orderno);

    public List searchOrderinfo(Map map);

    public Integer searchOrderinfoCount(Map map);

    public Long addOrderinfo(Orderinfo orderinfo);

    public void removeOrderinfo(Integer id);

    public void updateOrderinfo(Orderinfo orderinfo);

    public void updateOrderinfoSpecificField(String field, String fieldVal, Integer id);

    public void updateOrderinfoSpecificField(Map map);

    public void batUpdateOrderinfoStatus(Map map);

    /**
     * 是否要包含商品订单详情
     * @param params
     * @param isContainItems
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Orderinfo> searchOrderinfo(Map params, boolean isContainItems);

    public void getPagination(OrderInfoQuery query);

    public void getOldPagination(OrderInfoQuery query);
    
    public  List<OrderDetail> getDetailByIdUserId(Long id, Long userId);
    
    
    public Orderinfo getOldDetailByIdUserId(Long id, Long userId);

    public void updateOrderinfoStatus(Long id, int i);
    
    //新订单下单 tty
    public Long addNewOrderinfo(Order order);
    
    //新订单 下单 suborder
    
    public Long addNewSubOrderinfo(SubOrder suborder);
}
