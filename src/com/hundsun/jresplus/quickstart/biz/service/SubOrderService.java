package com.hundsun.jresplus.quickstart.biz.service;

import com.hundsun.jresplus.quickstart.biz.po.SubOrder;


public interface SubOrderService {

    Long add(SubOrder subOrder);
    
    
    public void updateSubOrderInfo(Long out_trade_no);
    
    public void updateAfterSubOrderInfo(Long out_trade_no);
}
