package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipaySubmit;
import com.hundsun.jresplus.quickstart.biz.po.PayInfo;
import com.hundsun.jresplus.quickstart.biz.service.GatewayService;
import com.hundsun.jresplus.quickstart.common.CommonDefine;

@Service("alipayService")
public class AlipayServiceImpl implements GatewayService{

  public String outPay(PayInfo payInfo) {
    String payment_type = "1";
    //必填，不能修改
    //服务器异步通知页面路径
    String notify_url =  payInfo.getNotify_url();
    if (notify_url == null || notify_url == ""){
        notify_url = CommonDefine.ALIPAY_NOTIFY_URL ;
    }
    //需http://格式的完整路径，不能加?id=123这类自定义参数

    //页面跳转同步通知页面路径
    String return_url =  payInfo.getReturn_url();
    if (return_url == null || return_url == ""){
      return_url = CommonDefine.ALIPAY_RETURN_URL;
    }
    //需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

    //商户订单号
    String out_trade_no = String.valueOf(payInfo.getRequestId());
    //商户网站订单系统中唯一订单号，必填
 
    //订单名称
    String subject = payInfo.getDesc();
    //必填

    //付款金额
    String total_fee = String.valueOf((double)(payInfo.getAmount())/100);
    //必填

    //订单描述

    String body = String.valueOf(payInfo.getDesc());
    //商品展示地址
    String show_url = new String("http://www.wuyeok.com");
    //需以http://开头的完整路径，例如：http://www.商户网址.com/myorder.html

    //防钓鱼时间戳
    String anti_phishing_key = "";
    //若要使用请调用类文件submit中的query_timestamp函数

    //客户端的IP地址
    String exter_invoke_ip = "10.11.2.220";
    //非局域网的外网IP地址，如：221.0.0.1
    
    
    //////////////////////////////////////////////////////////////////////////////////
    
    //把请求参数打包成数组
    Map<String, String> sParaTemp = new HashMap<String, String>();
    sParaTemp.put("service", "create_direct_pay_by_user");
    sParaTemp.put("partner", AlipayConfig.partner);
    sParaTemp.put("seller_email", AlipayConfig.seller_email);
    sParaTemp.put("_input_charset", AlipayConfig.input_charset);
    sParaTemp.put("payment_type", payment_type);
    sParaTemp.put("notify_url", notify_url);
    sParaTemp.put("return_url", return_url);
    sParaTemp.put("out_trade_no", out_trade_no);
    sParaTemp.put("subject", subject);
    sParaTemp.put("total_fee", total_fee);
    sParaTemp.put("body", body);
    sParaTemp.put("show_url", show_url);
    sParaTemp.put("anti_phishing_key", anti_phishing_key);
    sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
    
    //建立请求
    String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
    return sHtmlText;
  }

}
