package com.hundsun.jresplus.quickstart.biz.dao;

import java.util.List;

import com.hundsun.jresplus.quickstart.biz.po.Building;
import com.hundsun.jresplus.quickstart.biz.po.PropertyNote;

/**
 * 商品dao
 * @author chengy
 *
 */
public interface BuildingDAO {

    /**
     * 通过指定条件查询用户信息
     * @param record
     * @return
     */
    List<Building> queryAll();

    PropertyNote getPropertyNoteByBuildingId(Long buildingId);
    
    
    public  List<Building> getBuildingListByYuming(String tempContextUrl);
}
