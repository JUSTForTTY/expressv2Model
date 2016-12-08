package com.hundsun.jresplus.quickstart.biz.service;

import java.util.List;

import com.hundsun.jresplus.quickstart.biz.po.Codemaster;
import com.hundsun.jresplus.quickstart.biz.po.News;
import com.hundsun.jresplus.quickstart.biz.query.NewsQuery;

public interface NewsService {
 
	 

	List<News> getpicturesNewsList(Long buildingId,String status);

	
	
	
	/*
	 * add tty 
	 */
	List<News>  getNewsListByType(Integer provider,String type);
	
	
    public 	News  getNewsById(Long id);  
    
    public  News  getPreviousNews(News newsBean);
    
    public  News  getNextNews(News newsBean);
    
    public 	News  getNewsList(NewsQuery query);  
    
    
    
    public  List<Codemaster> getNewsType(Long building);
}




