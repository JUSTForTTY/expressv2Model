package com.hundsun.jresplus.quickstart.biz.dao;

import com.hundsun.jresplus.quickstart.biz.po.PrepayLog;
import com.hundsun.jresplus.quickstart.biz.query.PrepayLogQuery;

public interface PrepayLogDAO {
    public Long addPrepaylog(PrepayLog prepaylog);

    public void getPagination(PrepayLogQuery query);
}
