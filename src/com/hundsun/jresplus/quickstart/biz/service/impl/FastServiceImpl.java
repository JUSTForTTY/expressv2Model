package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.FastDAO;
import com.hundsun.jresplus.quickstart.biz.po.Fast;
import com.hundsun.jresplus.quickstart.biz.service.FastService;
@Service("fastService")
public class FastServiceImpl implements FastService{

	@Autowired
	private FastDAO fastDAO;

//	@Override
//	public List<Fast> getfast(Fast query) {
//		// TODO Auto-generated method stub
//		return fastDAO.getfast(query);
//	}

	@Override
	public List<Fast> getfast(Long buildingId) {
		// TODO Auto-generated method stub
		return fastDAO.getfast(buildingId);
	}

}
