package com.hundsun.jresplus.quickstart.biz.dao;

import java.util.Map;

import com.hundsun.jresplus.quickstart.biz.po.Order;
import com.hundsun.jresplus.quickstart.biz.po.OutPay;
import com.hundsun.jresplus.quickstart.biz.po.SubOrder;


public interface OutPayDao {
  public int addOutPay(OutPay outPayInfo);
  
  public OutPay selectByOutPayId(int outPayId);
  
  public int updateOutPaySpecificField(Map<String, Object> map);
  
  
  
//更新订单状态（新订单表）
  
  public void updateOrderInfo(Order order);
  
  public void updateSubOrderInfo(SubOrder subOrder);
  
}
