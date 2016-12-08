package com.hundsun.jresplus.quickstart.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.OrderDAO;
import com.hundsun.jresplus.quickstart.biz.dao.OutPayDao;
import com.hundsun.jresplus.quickstart.biz.po.Order;
import com.hundsun.jresplus.quickstart.biz.po.OutPay;
import com.hundsun.jresplus.quickstart.biz.service.OrderService;
import com.hundsun.jresplus.quickstart.common.CommonDefine;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OutPayDao outPayDao;
    
    @Override
    public Long add(Order order) {
        return orderDAO.insert(order);
    }

	@Override
	public void updateOrderInfo(Long out_trade_no) {
		 
		 Order orderinfo=new Order();
	     orderinfo.setId(out_trade_no);
		 orderinfo.setStatus(CommonDefine.ORDERINFO_STATUS_CLOSED);
		 outPayDao.updateOrderInfo(orderinfo);
		 
	}

	@Override
	public void updateAfterOrderInfo(Long out_trade_no) {
		 Order orderinfo=new Order();
	     orderinfo.setId(out_trade_no);
		 orderinfo.setStatus(CommonDefine.ORDERINFO_STATUS_PAYED_SENDING);
		 outPayDao.updateOrderInfo(orderinfo);
		
	}
    
    
}
