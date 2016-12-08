package com.hundsun.jresplus.quickstart.biz.dao;

import org.springframework.ui.Model;

import com.hundsun.jresplus.quickstart.biz.query.CommentQuery;
import com.hundsun.jresplus.quickstart.biz.query.ProviderQuery;

public interface ProviderDAO {
	public void getPagination(ProviderQuery query, Model model);
}
