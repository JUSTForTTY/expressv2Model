package com.hundsun.jresplus.quickstart.biz.service;


import org.springframework.ui.Model;

import com.hundsun.jresplus.quickstart.biz.query.ProviderQuery;





public interface ProviderService {
	public void getPagination(ProviderQuery query, Model model);
}
