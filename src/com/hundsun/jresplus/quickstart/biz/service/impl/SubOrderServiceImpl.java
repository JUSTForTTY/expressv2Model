package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.OutPayDao;
import com.hundsun.jresplus.quickstart.biz.dao.SubOrderDAO;
import com.hundsun.jresplus.quickstart.biz.po.SubOrder;
import com.hundsun.jresplus.quickstart.biz.service.SequenceService;
import com.hundsun.jresplus.quickstart.biz.service.SubOrderService;
import com.hundsun.jresplus.quickstart.common.CommonDefine;

@Service("subOrderService")
public class SubOrderServiceImpl implements SubOrderService {

    @Autowired
    private SubOrderDAO subOrderDAO;
    @Autowired
    private SequenceService sequenceService;
    @Autowired
    private OutPayDao outPayDao;
    @Override
    public Long add(SubOrder subOrder) {
     
    	 
    	    
        return subOrderDAO.insert(subOrder);
    }
	@Override
	public void updateSubOrderInfo(Long out_trade_no) {
		// TODO Auto-generated method stub
		
		SubOrder subOrder=new SubOrder();
		subOrder.setOrderId(out_trade_no); 
		subOrder.setStatus(CommonDefine.ORDERINFO_STATUS_CLOSED);
		
		outPayDao.updateSubOrderInfo(subOrder);
		
	}
	@Override
	public void updateAfterSubOrderInfo(Long out_trade_no) {
		// TODO Auto-generated method stub
		SubOrder subOrder=new SubOrder();
		subOrder.setOrderId(out_trade_no); 
		subOrder.setStatus(CommonDefine.ORDERINFO_STATUS_PAYED_SENDING);
		
		outPayDao.updateSubOrderInfo(subOrder);
	}
    
    
    

}
