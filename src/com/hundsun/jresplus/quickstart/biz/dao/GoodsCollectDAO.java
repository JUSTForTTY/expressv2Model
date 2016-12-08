package com.hundsun.jresplus.quickstart.biz.dao;

import java.util.List;

import com.hundsun.jresplus.quickstart.biz.po.GoodsCollect;
import com.hundsun.jresplus.quickstart.biz.query.GoodsCollectQuery;

/**
 * 收藏
 * @author chengy
 * @version $Id: GoodsCollectDAO.java,v 0.1 2015年5月25日 下午10:34:37 chengy Exp $
 */
public interface GoodsCollectDAO {

    public Long insert(GoodsCollect collect);

    public void getPagination(GoodsCollectQuery query);

    public List<GoodsCollect> queryList(GoodsCollectQuery query);

    public int deleteById(Long id);
    
    public int collectPeople(Long id);

}
