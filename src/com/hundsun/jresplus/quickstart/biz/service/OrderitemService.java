package com.hundsun.jresplus.quickstart.biz.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.bo.Result;
import com.hundsun.jresplus.quickstart.biz.po.OrderDetail;
import com.hundsun.jresplus.quickstart.biz.po.Orderitem;

/**
 * 
 * @author chengy
 *
 */
@Service("orderitemService")
public interface OrderitemService {
    public List searchOrderitem(Map map);

    public Integer searchOrderitemCount(Map map);

    public List getAllOrderitem();

    public List getOrderitemsByOrdid(Long orderinfo_id);

    public OrderDetail getOrderitemById(Long id);
    
    public Orderitem getOldOrderitemById(Long id);

    public void addOrderitem(Orderitem orderitem);

    public void removeOrderitem(Integer id);

    public void updateOrderitem(Orderitem orderitem);

    public int searchOrderitemSumCount(Map map);

    public List searchOrderitemSum(Map map);

    public void updateStatusByOrderInfoId(long orderInfoId, String status);

    public void updateStatusById(long id, String status);

    public Long receive(Long itemId, Long id);
    
  //下子订单
    public void addNewOrderitem(OrderDetail orderDetail);
}
