package com.hundsun.jresplus.quickstart.biz.service;

import java.util.List;

import com.hundsun.jresplus.quickstart.biz.po.News;

public interface FrontNewsService  {

	
	
	List<News>  getzongheNewsList(Long buildingId);
}
