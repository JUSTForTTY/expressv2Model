package com.hundsun.jresplus.quickstart.biz.service;

import com.hundsun.jresplus.quickstart.biz.po.PayInfo;

public interface OutPayService {
  String recharge(PayInfo data);
  
  boolean notify(int outPayId, String outStatus, String outId);
  
}
