package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.NewsDAO;
import com.hundsun.jresplus.quickstart.biz.po.News;
import com.hundsun.jresplus.quickstart.biz.service.FrontNewsService;

@Service("frontNewsService")
public class FrontNewsServiceImpl implements FrontNewsService {
	 @Autowired
	    private NewsDAO newsDAO;
	
	@Override
	public List<News> getzongheNewsList(Long buildingId) {
		// TODO Auto-generated method stub
		return newsDAO.getzongheNewsList(buildingId);
	}

}
