package com.hundsun.jresplus.quickstart.biz.dao;

import java.util.List;

import com.hundsun.jresplus.quickstart.biz.po.Fast;

public interface FastDAO {

//	List<Fast> getfast();

	List<Fast> getfast(Long buildingId);

}
