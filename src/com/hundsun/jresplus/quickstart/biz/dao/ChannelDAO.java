package com.hundsun.jresplus.quickstart.biz.dao;

import java.util.List;

import com.hundsun.jresplus.quickstart.biz.po.Channel;
import com.hundsun.jresplus.quickstart.biz.po.DsVisitor;
import com.hundsun.jresplus.quickstart.biz.po.IndexCustom;
import com.hundsun.jresplus.quickstart.biz.query.CodemasterQuery;

public interface ChannelDAO {

    List<Channel> getAllByBuildingId(Long buildingId,String status);

    //banner 背景颜色
	List<CodemasterQuery> getColorByBuildingId(Long buildingId,String status);
	//标题模块
	List<CodemasterQuery> getBlockByBuildingId(Long buildingId,String status);
	
	
	public void contactUs(DsVisitor visitor);

}
