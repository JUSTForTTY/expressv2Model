package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.bo.Result;
import com.hundsun.jresplus.quickstart.biz.dao.GoodsCollectDAO;
import com.hundsun.jresplus.quickstart.biz.po.GoodsCollect;
import com.hundsun.jresplus.quickstart.biz.query.GoodsCollectQuery;
import com.hundsun.jresplus.quickstart.biz.service.GoodsCollectService;
import com.hundsun.jresplus.quickstart.common.UserAgent;
import com.hundsun.jresplus.quickstart.enums.EnumGoodsCollectType;

/**
 * 
 * @author chengy
 * @version $Id: GoodsCollectServiceImpl.java,v 0.1 2015年5月26日 上午8:31:09 chengy Exp $
 */
@Service("goodsCollectService")
public class GoodsCollectServiceImpl implements GoodsCollectService {

    @Autowired
    private GoodsCollectDAO goodsCollectDAO;

    @Override
    public Result addCollect(UserAgent user, Long goodsId, String type) {
        Result result = new Result();
        if (user == null || user.getUserName() == null) {
            result.setIsSuccess(false);
            result.setMessage("请先登录！");
            return result;
        }
        if (!EnumGoodsCollectType.toMap().containsKey(type)) {
            result.setIsSuccess(false);
            result.setMessage("此类型无法收藏！");
            return result;
        }
        String userName = user.getUserName();
        GoodsCollectQuery query = new GoodsCollectQuery();
        query.setType(type);
        query.setGoodsId(goodsId);
        query.setUserName(userName);
        List<GoodsCollect> collectList = goodsCollectDAO.queryList(query);
        if (collectList != null && collectList.size() > 0) {
            result.setIsSuccess(false);
            result.setMessage("已收藏！");
            return result;
        }
        GoodsCollect collect = new GoodsCollect(userName, goodsId, type);
        goodsCollectDAO.insert(collect);
        return result;
    }

    @Override
    public void getPagination(GoodsCollectQuery query) {
        goodsCollectDAO.getPagination(query);
    }

    @Override
    public Result deleteCollect(UserAgent user, Long id) {
        Result result = new Result();
        if (user == null || user.getUserName() == null) {
            result.setIsSuccess(false);
            result.setMessage("请先登录！");
            return result;
        }
        String userName = user.getUserName();
        GoodsCollectQuery query = new GoodsCollectQuery();
        query.setId(id);
        query.setUserName(userName);
        List<GoodsCollect> collectList = goodsCollectDAO.queryList(query);
        if (collectList == null || collectList.size() == 0) {
            result.setIsSuccess(false);
            result.setMessage("无此收藏！");
            return result;
        }
        goodsCollectDAO.deleteById(id);
        return result;
    }

    @Override
	public int collectPeople(Long id) {
		// TODO Auto-generated method stub
		return goodsCollectDAO.collectPeople(id);
	}

}
