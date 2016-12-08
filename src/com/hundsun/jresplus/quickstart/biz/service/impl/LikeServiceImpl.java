package com.hundsun.jresplus.quickstart.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.LikeDAO;
import com.hundsun.jresplus.quickstart.biz.po.Goods;
import com.hundsun.jresplus.quickstart.biz.service.BaseService;
import com.hundsun.jresplus.quickstart.biz.service.LikeService;

@Service("likeService")
public class LikeServiceImpl extends BaseService implements LikeService {

	@Autowired
	private LikeDAO likeDAO;
	
	@Override
	public void addViewNum(Goods goods) {
		// TODO Auto-generated method stub
		likeDAO.addVuewNum(goods);
	}

}
