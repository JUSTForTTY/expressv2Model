package com.hundsun.jresplus.quickstart.biz.service;

import java.util.Map;

import com.hundsun.jresplus.quickstart.biz.po.PayInfo;

public interface GatewayService {
  //去支付
  public String outPay(PayInfo payInfo);
  //回调
  //public boolean notify(Map<String,String> keyMap);
}
