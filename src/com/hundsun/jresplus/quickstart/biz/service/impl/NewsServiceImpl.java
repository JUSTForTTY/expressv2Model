package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.NewsDAO;
import com.hundsun.jresplus.quickstart.biz.po.Codemaster;
import com.hundsun.jresplus.quickstart.biz.po.News;
import com.hundsun.jresplus.quickstart.biz.query.NewsQuery;
import com.hundsun.jresplus.quickstart.biz.service.NewsService;

 

 
@Service("newsService")
public class NewsServiceImpl implements NewsService{
	    @Autowired
	    private NewsDAO newsDAO;
    
		@Override
		public List<News> getpicturesNewsList(Long buildingId,String status) {
			
			 
			// TODO Auto-generated method stub
			return newsDAO.getpicturesNewsList(buildingId,status);
		}

		 

		@Override
		public List<News> getNewsListByType(Integer provider,String type) {
			// TODO Auto-generated method stub
			
			return newsDAO.getNewsListByType(provider,type);
		}



		@Override
		public News getNewsById(Long id) {
			// TODO Auto-generated method stub
			
			
			return newsDAO.getNewsById(id);
		}



		@Override
		public News getNewsList(NewsQuery query) {
			// TODO Auto-generated method stub
			return newsDAO.getNewsList(query);
		}



		@Override
		public News getPreviousNews(News newsBean) {
			// TODO Auto-generated method stub
			return newsDAO.getPreviousNews(newsBean);
		}



		@Override
		public News getNextNews(News newsBean) {
			// TODO Auto-generated method stub
			return newsDAO.getNextNews(newsBean);
		}



		@Override
		public List<Codemaster> getNewsType(Long building) {
			// TODO Auto-generated method stub
			
			return newsDAO.getNewsType(building);
		}


	}
