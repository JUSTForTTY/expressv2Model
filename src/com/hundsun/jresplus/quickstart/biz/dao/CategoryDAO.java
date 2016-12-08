package com.hundsun.jresplus.quickstart.biz.dao;

import java.util.List;
import java.util.Map;

import com.hundsun.jresplus.quickstart.biz.po.Category;
import com.hundsun.jresplus.quickstart.biz.query.CategoryQuery;

/**
 * 商品dao
 * @author chengy
 *
 */
public interface CategoryDAO {
    public List<Category> getParentCategory(CategoryQuery cateQuery);

    public List<Category> getChildCategoryById(CategoryQuery query);

    public List<Category> searchCategory(Map<String, Object> map);

    public List<Category> getListByBuildingId(Long buildingId);

    public List<Category> getListByParentId(Long id);

    public Category getCategoryById(Long id);

    public Category getCategoryByIdWithParent(Long id);
}
