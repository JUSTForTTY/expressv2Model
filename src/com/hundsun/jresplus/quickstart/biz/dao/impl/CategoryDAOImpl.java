package com.hundsun.jresplus.quickstart.biz.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hundsun.jresplus.quickstart.biz.dao.CategoryDAO;
import com.hundsun.jresplus.quickstart.biz.po.Category;
import com.hundsun.jresplus.quickstart.biz.query.CategoryQuery;
import com.hundsun.network.common.dao.BaseDAO;

@Repository("categoryDAO")
public class CategoryDAOImpl extends BaseDAO implements CategoryDAO {

    private static final String SQL_SPACE = "CATEGORY.";

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> getChildCategoryById(CategoryQuery query) {
        return this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "queryList", query);

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> getParentCategory(CategoryQuery query) {

        return this.getSqlMapClientTemplate().queryForList(SQL_SPACE + "categoryList", query);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> searchCategory(Map<String, Object> map) {
        List<Category> list = this.getSqlMapClientTemplate().queryForList(
            SQL_SPACE + "searchCategory", map);
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> getListByBuildingId(Long buildingId) {
        List<Category> list = this.getSqlMapClientTemplate().queryForList(
            SQL_SPACE + "getListByBuildingId", buildingId);
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> getListByParentId(Long parentId) {
        List<Category> list = this.getSqlMapClientTemplate().queryForList(
            SQL_SPACE + "getListByParentId", parentId);
        return list;
    }

    @Override
    public Category getCategoryById(Long id) {
        return (Category) this.getSqlMapClientTemplate().queryForObject(
            SQL_SPACE + "getCategoryById", id);
    }

    @Override
    public Category getCategoryByIdWithParent(Long id) {
        return (Category) this.getSqlMapClientTemplate().queryForObject(
            SQL_SPACE + "getCategoryByIdWithParent", id);
    }

}
