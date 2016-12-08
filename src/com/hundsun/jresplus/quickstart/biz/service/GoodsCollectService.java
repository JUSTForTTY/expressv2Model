package com.hundsun.jresplus.quickstart.biz.service;

import com.hundsun.jresplus.quickstart.biz.bo.Result;
import com.hundsun.jresplus.quickstart.biz.query.GoodsCollectQuery;
import com.hundsun.jresplus.quickstart.common.UserAgent;

/**
 * 收藏
 * @author chengy
 * @version $Id: GoodsCollectService.java,v 0.1 2015年5月26日 上午7:46:33 chengy Exp $
 */
public interface GoodsCollectService {

    /**
     * 添加
     * @param user
     * @param goodsId
     * @param type
     * @return
     */
    public Result addCollect(UserAgent user, Long goodsId, String type);

    /**
     * 分页查询
     * @param query
     */
    public void getPagination(GoodsCollectQuery query);

    /**
     * 删除
     * @param user
     * @param id
     * @return
     */
    public Result deleteCollect(UserAgent user, Long id);
    
    /*
     *统计关注人数
     * 
     */
    public int   collectPeople(Long id);

}
