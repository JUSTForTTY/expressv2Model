package com.hundsun.jresplus.quickstart.biz.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.NewsDAO;
import com.hundsun.jresplus.quickstart.biz.po.Building;
import com.hundsun.jresplus.quickstart.biz.po.Codemaster;
import com.hundsun.jresplus.quickstart.biz.po.News;
import com.hundsun.jresplus.quickstart.biz.query.NewsQuery;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("newsDAO")
public class NewsDAOImpl extends BaseDAO implements NewsDAO {

    private static final String SQL_SPACE = "NEWS.";

    @SuppressWarnings("unchecked")
    @Override
    public List<News> getpicturesNewsList(Long buildingId,String status) {
    	
    	System.out.println("sb:"+buildingId);
    	Building building=new Building();
    	building.setId(buildingId);
    	building.setRemark(status);
    	
        return this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "getAllByBuildingId",
        		building);
    }

	@Override
	public List<News> getNewsListByType(Integer providerid,String type) {
		// TODO Auto-generated method stub
		 NewsQuery query =new NewsQuery();
		 query.setType(type);
		 query.setProviderId(providerid);
		return this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "getzongheNewsList",
				query);
	}

	@Override
	public News getNewsById(Long id) {
		// TODO Auto-generated method stub
		return   (News) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE + "getNewsById",
				id);
	}

	@Override
	public News getNewsList(NewsQuery query) {
		// TODO Auto-generated method stub
 
		this.getPagination(query, SQL_SPACE + "newsCount", SQL_SPACE + "newsList");
		
		return null;
	}

	@Override
	public News getPreviousNews(News newsBean) {
		// TODO Auto-generated method stub
		
		return (News) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE + "getPreviousNews",
				newsBean);
	}

	@Override
	public News getNextNews(News newsBean) {
		// TODO Auto-generated method stub
		return (News) this.getSqlMapClientTemplate().queryForObject(SQL_SPACE + "getNextNews",
				newsBean);
	}

	@Override
	public List<Codemaster> getNewsType(Long buildingid) {
		// TODO Auto-generated method stub
		Codemaster codemaster=new Codemaster();
		codemaster.setBuilding_id(buildingid.toString());
		return (List<Codemaster>) this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "getNewsType",
				codemaster);
	}

}

