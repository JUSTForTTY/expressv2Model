package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.ChannelDAO;
import com.hundsun.jresplus.quickstart.biz.po.Channel;
import com.hundsun.jresplus.quickstart.biz.po.DsVisitor;
import com.hundsun.jresplus.quickstart.biz.po.IndexCustom;
import com.hundsun.jresplus.quickstart.biz.query.CodemasterQuery;
import com.hundsun.jresplus.quickstart.biz.service.ChannelService;

@Service("channelService")
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelDAO channelDAO;

    @Override
    public List<Channel> getIndexChannelList(Long buildingId,String status) {
        return channelDAO.getAllByBuildingId(buildingId,status);
    }

    
    
    
    
    @Override
    public List<Channel> getListByBuildingIdChannelId(Long buildingId, Long channelId) {
        List<Channel> channelList = channelDAO.getAllByBuildingId(buildingId);
        if (channelList != null && !channelList.isEmpty()) {
            boolean findChoosedChannel = false;
            for (Channel channel : channelList) {
                if (channel.getId().equals(channelId)) {
                    findChoosedChannel = true;
                    channel.setIsChoosed(true);
                }
            }
            if (!findChoosedChannel) {
                channelList.get(0).setIsChoosed(true);
            }
        }
        return channelList;
    }




//头部颜色替换
    @Override
    public List<CodemasterQuery> getIndexChannelColor(Long buildingId,String status) {
        return channelDAO.getColorByBuildingId(buildingId,status);
    }
    
  //标题模块
    @Override
    public List<CodemasterQuery> getIndexChannelBlock(Long buildingId,String status) {
        return channelDAO.getBlockByBuildingId(buildingId,status);
    }





	@Override
	public void contactUs(DsVisitor visitor) {
		// TODO Auto-generated method stub
		
		channelDAO.contactUs(visitor);
		
	}    

}
