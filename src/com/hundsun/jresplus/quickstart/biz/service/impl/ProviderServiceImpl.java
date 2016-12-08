package com.hundsun.jresplus.quickstart.biz.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hundsun.jresplus.quickstart.biz.dao.ProviderDAO;
import com.hundsun.jresplus.quickstart.biz.query.ProviderQuery;
import com.hundsun.jresplus.quickstart.biz.service.BaseService;
import com.hundsun.jresplus.quickstart.biz.service.ProviderService;
@Service("providerService")
public class ProviderServiceImpl extends BaseService implements ProviderService{
	 @Autowired
	 private ProviderDAO providerDAO;
	 public void getPagination(ProviderQuery query, Model model) {
			// TODO Auto-generated method stub
			providerDAO.getPagination(query, model);
			
		}
	

}
