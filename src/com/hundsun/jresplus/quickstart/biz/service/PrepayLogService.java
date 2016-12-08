package com.hundsun.jresplus.quickstart.biz.service;

import com.hundsun.jresplus.quickstart.biz.po.PrepayLog;
import com.hundsun.jresplus.quickstart.biz.query.PrepayLogQuery;

/**
 * 
 * @author chengy
 * @version $Id: PrepayLogService.java,v 0.1 2015年5月31日 下午8:47:52 chengy Exp $
 */
public interface PrepayLogService {
    
    public Long addPrepayLog(PrepayLog prepaylog);

    public void getPagination(PrepayLogQuery query);
}
