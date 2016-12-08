package com.hundsun.jresplus.quickstart.biz.service;

import java.util.List;

import com.hundsun.jresplus.quickstart.biz.po.Category;
import com.hundsun.jresplus.quickstart.biz.query.CategoryQuery;

public interface CategoryService {

    public List<Category> getChildCategoryById(CategoryQuery cateQuery);

    public List<Category> getParentCategory(CategoryQuery cateQuery);

    public List<Category> getTopCategorys(String[] queryBuilding);

    public List<Category> getListByBuildingId(Long buildingId);

    public Category getCategoryById(Long categoryId);

    public Category getCategoryByIdWithParent(Long id);

}
