package com.hundsun.jresplus.quickstart.biz.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.hundsun.jresplus.quickstart.biz.dao.CommentDAO;
import com.hundsun.jresplus.quickstart.biz.dao.ProviderDAO;
import com.hundsun.jresplus.quickstart.biz.query.ProviderQuery;

import com.hundsun.network.common.dao.BaseDAO;
@Repository("providerDAO")
public class ProviderDAOImpl extends BaseDAO implements ProviderDAO {
	private final String SQL_SPACE = "PROVIDER.";
	@Override
	public void getPagination(ProviderQuery query, Model model) {
		// TODO Auto-generated method stub
		this.getPagination(query, SQL_SPACE + "providerCount", SQL_SPACE + "providerList");
	}


}
