package com.hundsun.jresplus.quickstart.biz.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.BuildingDAO;
import com.hundsun.jresplus.quickstart.biz.po.Building;
import com.hundsun.jresplus.quickstart.biz.po.PropertyNote;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("buildingDAO")
public class BuildingDAOImpl extends BaseDAO implements BuildingDAO {

    private static final String SQL_SPACE = "BUILDING.";

    @SuppressWarnings("unchecked")
    @Override
    public List<Building> queryAll() {
        return (List<Building>) this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "queryAll");
    }

    @Override
    public PropertyNote getPropertyNoteByBuildingId(Long buildingId) {
        return (PropertyNote) this.getSqlMapClientTemplate().queryForObject(
            SQL_SPACE + "getPropertyNoteByBuildingId", buildingId);
    }

	@Override
	public List<Building> getBuildingListByYuming(String tempContextUrl) {
		 
		
		return this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "getBuildingListByYuming", tempContextUrl);
	}

}
