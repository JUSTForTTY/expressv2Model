package com.hundsun.jresplus.quickstart.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.PrepayLogDAO;
import com.hundsun.jresplus.quickstart.biz.po.PrepayLog;
import com.hundsun.jresplus.quickstart.biz.query.PrepayLogQuery;
import com.hundsun.jresplus.quickstart.biz.service.BaseService;
import com.hundsun.jresplus.quickstart.biz.service.PrepayLogService;

@Service("prepayLogService")
public class PrepayLogServiceImpl extends BaseService implements PrepayLogService {
    @Autowired
    private PrepayLogDAO prepayLogDAO;
    
    public Long addPrepayLog(PrepayLog prepaylog) {
        return prepayLogDAO.addPrepaylog(prepaylog);
    }
    @Override
    public void getPagination(PrepayLogQuery query) {
        prepayLogDAO.getPagination(query);
    }

}
