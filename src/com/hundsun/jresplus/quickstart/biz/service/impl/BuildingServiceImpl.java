package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.BuildingDAO;
import com.hundsun.jresplus.quickstart.biz.po.Building;
import com.hundsun.jresplus.quickstart.biz.po.PropertyNote;
import com.hundsun.jresplus.quickstart.biz.service.BaseService;
import com.hundsun.jresplus.quickstart.biz.service.BuildingService;

@Service("buildingService")
public class BuildingServiceImpl extends BaseService implements BuildingService {

    @Autowired
    private BuildingDAO buildingDAO;

    @Override
    public List<Building> queryAll() {
        return buildingDAO.queryAll();
    }

    @Override
    public PropertyNote getPropertyNoteByBuildingId(Long buildingId) {
        return buildingDAO.getPropertyNoteByBuildingId(buildingId);
    }

	@Override
	public List<Building> getBuildingListByYuming(String tempContextUrl) {
		 
		
		return buildingDAO.getBuildingListByYuming(tempContextUrl);
	}

}
