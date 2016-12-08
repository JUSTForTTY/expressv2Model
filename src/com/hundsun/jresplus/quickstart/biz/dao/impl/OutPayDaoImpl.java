package com.hundsun.jresplus.quickstart.biz.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.OutPayDao;
import com.hundsun.jresplus.quickstart.biz.po.Order;
import com.hundsun.jresplus.quickstart.biz.po.OutPay;
import com.hundsun.jresplus.quickstart.biz.po.SubOrder;
import com.hundsun.network.common.dao.BaseDAO;

@Service("outPayDao")
public class OutPayDaoImpl extends BaseDAO implements OutPayDao {
    private static final String SQL_SPACE = "OutPay.";

    @Override
    public int addOutPay(OutPay outPayInfo) {
        if (outPayInfo.getAmount() == null || outPayInfo.getAmount() <= 0
            || outPayInfo.getPayType() == null || outPayInfo.getPayType() == 0
            || outPayInfo.getRequestId() == null || outPayInfo.getRequestId() == 0) {
            return 0;
        }
        int id = (Integer) this.getSqlMapClientTemplate().insert(SQL_SPACE + "insertOutPay",
            outPayInfo);
        return id;
    }

    @Override
    public OutPay selectByOutPayId(int outPayId) {
        OutPay outPayInfo = (OutPay) this.getSqlMapClientTemplate().queryForObject(
            SQL_SPACE + "selectByOutPayId", outPayId);

        return outPayInfo;
    }

    @Override
    public int updateOutPaySpecificField(Map<String, Object> map) {
        return this.getSqlMapClientTemplate().update(SQL_SPACE + "updateOutPaySpecificField", map);
    }
    
    @Override
    public void updateOrderInfo(Order order) {
    	// TODO Auto-generated method stub
    	
    	this.getSqlMapClientTemplate().update(SQL_SPACE + "updateOrderInfo",order);
    }

    @Override
    public void updateSubOrderInfo(SubOrder subOrder) {
    	// TODO Auto-generated method stub
    	this.getSqlMapClientTemplate().update(SQL_SPACE + "updateSubOrderInfo",subOrder);
    	
    }

}
