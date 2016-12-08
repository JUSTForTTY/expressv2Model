package com.hundsun.jresplus.quickstart.biz.service;

import java.util.List;

import com.hundsun.jresplus.quickstart.biz.po.Channel;
import com.hundsun.jresplus.quickstart.biz.po.DsVisitor;
import com.hundsun.jresplus.quickstart.biz.po.IndexCustom;
import com.hundsun.jresplus.quickstart.biz.query.CodemasterQuery;


public interface ChannelService {

    List<Channel> getIndexChannelList(Long buildingId,String status);
    
    //banner 背景色
    List<CodemasterQuery> getIndexChannelColor(Long buildingId,String status);

    //标题模块
    List<CodemasterQuery> getIndexChannelBlock(Long buildingId,String status);
    
    
    List<Channel> getListByBuildingIdChannelId(Long buildingId, Long channelId);
    
    
    public  void contactUs(DsVisitor visitor);
    
}
