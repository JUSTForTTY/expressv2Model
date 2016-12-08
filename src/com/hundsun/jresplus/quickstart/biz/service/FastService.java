package com.hundsun.jresplus.quickstart.biz.service;

import java.util.List;

import com.hundsun.jresplus.quickstart.biz.po.Fast;

public interface FastService {

	//List<Fast> getfast();

	List<Fast> getfast(Long buildingId);

}
