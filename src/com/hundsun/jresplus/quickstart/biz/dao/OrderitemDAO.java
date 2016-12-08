package com.hundsun.jresplus.quickstart.biz.dao;

import java.util.List;
import java.util.Map;

import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.jresplus.quickstart.biz.po.Orderitem;

public interface OrderitemDAO {

    public List searchOrderitem(Map map);

    public Integer searchOrderitemCount(Map map);

    public List findAllOrderitem();

    public List<Orderitem> findOrderitemsByOrdid(Long id);

    public OrderDetail findOrderitemById(Long id);
    
    public Orderitem findOldOrderitemById(Long id);

    public void addOrderitem(Orderitem orderitem);

    public void removeOrderitem(Integer id);

    public void updateOrderitem(Orderitem orderitem);

    public Integer searchOrderitemSumCount(Map map);

    public List searchOrderitemSum(Map map);

    public List<OrderDetail> getByOrderInfoId(Long id);
    
    public List<Orderitem> getByOldOrderInfoId(Long id);
    
    public void updateStatusByOrderInfoId(Long orderInfoId, String status);
    
    public void updateStatusById(Long orderItemId, String status);

    public Orderitem getById(Long itemId);
    
    //下子订单
    public void addNewOrderitem(OrderDetail orderDetail);
}
