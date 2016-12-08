package com.hundsun.jresplus.quickstart.biz.dao.impl;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.LikeDAO;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("likeDAO")
public class LikeDAOImpl extends BaseDAO implements LikeDAO{

	private static final String SQL_SPACE = "LIKES.";
	
	@Override
	public void addVuewNum(Goods goods) {
		// TODO Auto-generated method stub
		this.getSqlMapClientTemplate().update(SQL_SPACE+"addLike",goods);
	}

}
