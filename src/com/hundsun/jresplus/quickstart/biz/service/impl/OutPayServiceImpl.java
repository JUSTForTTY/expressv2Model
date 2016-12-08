package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.common.util.StringUtil;
import com.hundsun.jresplus.quickstart.biz.dao.OutPayDao;
import com.hundsun.jresplus.quickstart.biz.po.OutPay;
import com.hundsun.jresplus.quickstart.biz.po.PayInfo;
import com.hundsun.jresplus.quickstart.biz.service.GatewayService;
import com.hundsun.jresplus.quickstart.biz.service.OrderinfoService;
import com.hundsun.jresplus.quickstart.biz.service.OrderitemService;
import com.hundsun.jresplus.quickstart.biz.service.OutPayService;
import com.hundsun.jresplus.quickstart.common.CommonDefine;
import com.hundsun.jresplus.quickstart.common.Utils;

@Service("outPayService")
public class OutPayServiceImpl implements OutPayService {

    @Autowired
    private OutPayDao        outPayDao;
    @Autowired
    private GatewayService   alipayService;
    @Autowired
    private GatewayService   alipayWapService;
    @Autowired
    private OrderinfoService orderinfoService;
    @Autowired
    private OrderitemService orderitemService;

    @Override
    public String recharge(PayInfo data) {
        if (data.getAmount() == null || data.getAmount() == 0
            || StringUtil.isBlank(data.getNotify_url()) || data.getPayType() == null
            || data.getPayType() == 0 || data.getRequestId() == null || data.getRequestId() == 0) {
            return "";
        }

        OutPay outPayInfo = new OutPay();
        outPayInfo.setAmount(data.getAmount());
        outPayInfo.setPayType(data.getPayType());
        outPayInfo.setRequestId(data.getRequestId());
        outPayInfo.setUserId(data.getUserId());
        outPayInfo.setStatus(CommonDefine.OUTPAY_STATUS_INIT);
        outPayInfo.setCreated(Utils.now());
        outPayInfo.setUpdated(Utils.now());
        int outPayId = outPayDao.addOutPay(outPayInfo);
        if (outPayId == 0) {
            return "";
        }

        data.setOutPayId(outPayId);
        // TODO Auto-generated method stub
        if (data.getPayType() == CommonDefine.ORDERPAYTYPE_ALIPAY) {
            return alipayService.outPay(data);
        } else if (data.getPayType() == CommonDefine.ORDERPAYTYPE_ALIPAYWAP) {
            return alipayWapService.outPay(data);
        }
        return "error";
    }

    @Override
    public boolean notify(int outPayId, String outStatus, String outId) {
        OutPay outPay = outPayDao.selectByOutPayId(outPayId);
        if (outPay == null) {
            return false;
        }

        if (OutPayServiceImpl.isPaySuccess(outPay.getPayType(), outPay.getStatus(),
            outPay.getOutStatus())) {
            return true;
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("outPayId", outPayId);
        map.put("outStatus", outStatus);
        map.put("outId", outId);
        map.put("updated", Utils.now());
        outPayDao.updateOutPaySpecificField(map);

        //更新订单状态
        map.clear();
        map.put("id", outPay.getRequestId());
        map.put("status", 32);
        map.put("paymenttime", new Date());
        orderinfoService.updateOrderinfoSpecificField(map);

        //更新orderitem的状态
        orderitemService.updateStatusByOrderInfoId(outPay.getRequestId(), "32");

        //更新网关状态
        map.clear();
        map.put("outPayId", outPayId);
        map.put("updated", Utils.now());
        map.put("status", CommonDefine.OUTPAY_STATUS_SUCCESS);
        outPayDao.updateOutPaySpecificField(map);
        // TODO Auto-generated method stub
        return true;
    }

    /**
     * 是否支付
     * @param payType
     * @param status
     * @param outStatus
     * @return
     */
    public static boolean isPaySuccess(int payType, int status, String outStatus) {
        if (payType == CommonDefine.ORDERPAYTYPE_ALIPAY) {
            if (status == CommonDefine.OUTPAY_STATUS_SUCCESS || outStatus.equals("TRADE_SUCCESS")) {
                return true;
            } else {
                return false;
            }
        } else if (payType == CommonDefine.ORDERPAYTYPE_ALIPAYWAP) {
            if (status == CommonDefine.OUTPAY_STATUS_SUCCESS || outStatus.equals("success")
                || outStatus.equals("TRADE_SUCCESS") || outStatus.equals("TRADE_FINISH")) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }

    }

}
