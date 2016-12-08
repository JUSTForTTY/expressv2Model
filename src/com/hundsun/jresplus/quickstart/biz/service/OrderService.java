package com.hundsun.jresplus.quickstart.biz.service;

import com.hundsun.jresplus.quickstart.biz.po.Order;


public interface OrderService {

    Long add(Order order);
    
    public void  updateOrderInfo(Long out_trade_no);
    
    public void  updateAfterOrderInfo(Long out_trade_no);
    
}
