package com.hundsun.jresplus.quickstart.biz.service;

import java.util.List;

import com.hundsun.jresplus.quickstart.biz.po.Building;
import com.hundsun.jresplus.quickstart.biz.po.PropertyNote;

public interface BuildingService {

	public List<Building> queryAll() ;

    public PropertyNote getPropertyNoteByBuildingId(Long buildingId);
    
    public  List<Building> getBuildingListByYuming(String tempContextUrl);
}
