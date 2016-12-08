package com.hundsun.jresplus.quickstart.biz.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.ChannelDAO;
import com.hundsun.jresplus.quickstart.biz.po.Building;
import com.hundsun.jresplus.quickstart.biz.po.Channel;
import com.hundsun.jresplus.quickstart.biz.po.DsVisitor;
import com.hundsun.jresplus.quickstart.biz.po.IndexCustom;
import com.hundsun.jresplus.quickstart.biz.query.CodemasterQuery;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("chanelDAO")
public class ChannelDAOImpl extends BaseDAO implements ChannelDAO {

    private static final String SQL_SPACE = "CHANNEL.";

    @SuppressWarnings("unchecked")
    @Override
    public List<Channel> getAllByBuildingId(Long buildingId,String status) {
    	 Building building=new Building();
		  building.setId(buildingId);
		  building.setRemark(status);
        return this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "getAllByBuildingId",
        		building);
    }
    
//头部颜色替换
	@SuppressWarnings("unchecked")
	@Override
	public List<CodemasterQuery> getColorByBuildingId(Long buildingId,String status) {
		
		 Building building=new Building();
		  building.setId(buildingId);
		  building.setRemark(status);
        return this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "getColorByBuildingId",
        		building);
        }

//标题模块
	  @SuppressWarnings("unchecked")
	@Override
	    public List<CodemasterQuery> getBlockByBuildingId(Long buildingId,String status) {
		  
		  Building building=new Building();
		  building.setId(buildingId);
		  building.setRemark(status);
	        return this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "getBlockByBuildingId",
	        		building);
	    }

	@Override
	public void contactUs(DsVisitor visitor) {
		
		
		this.getSqlMapClientTemplate().insert(SQL_SPACE+"contactUs",visitor);
		
		
	}

}
