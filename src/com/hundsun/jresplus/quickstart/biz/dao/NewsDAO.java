package com.hundsun.jresplus.quickstart.biz.dao;

import java.util.List;

import com.hundsun.jresplus.quickstart.biz.po.Codemaster;
import com.hundsun.jresplus.quickstart.biz.po.News;
import com.hundsun.jresplus.quickstart.biz.query.NewsQuery;

public interface NewsDAO {
	   List<News> getpicturesNewsList(Long buildingId,String status);

	   
	   List<News>  getNewsListByType(Integer providerid,String type);
	   
	   /*
	    * add tty
	    */
	   public 	News  getNewsById(Long id); 
	   
	   public 	News  getNewsList(NewsQuery query); 
	   
	   public  News  getPreviousNews(News newsBean);
	    
	   public  News  getNextNews(News newsBean);
	   
	   public  List<Codemaster> getNewsType(Long building);
}
