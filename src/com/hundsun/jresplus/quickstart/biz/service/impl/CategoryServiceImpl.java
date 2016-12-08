package com.hundsun.jresplus.quickstart.biz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.jresplus.quickstart.biz.dao.CategoryDAO;
import com.hundsun.jresplus.quickstart.biz.po.Category;
import com.hundsun.jresplus.quickstart.biz.query.CategoryQuery;
import com.hundsun.jresplus.quickstart.biz.service.BaseService;
import com.hundsun.jresplus.quickstart.biz.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl extends BaseService implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Category> getChildCategoryById(CategoryQuery cateQuery) {
        return categoryDAO.getChildCategoryById(cateQuery);

    }

    @Override
    public List<Category> getParentCategory(CategoryQuery cateQuery) {
        return categoryDAO.getParentCategory(cateQuery);
    }

    @Override
    public List<Category> getTopCategorys(String[] queryBuilding) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("level", 1);
        map.put("building", queryBuilding);
        map.put("order_col", "sort asc");
        return categoryDAO.searchCategory(map);
    }

    @Override
    public List<Category> getListByBuildingId(Long buildingId) {
        List<Category> categoryList = categoryDAO.getListByBuildingId(buildingId);
        // 取第二级的数据
        for (Category category : categoryList) {
            List<Category> subCategoryList = categoryDAO.getListByParentId(category.getId());
            category.setSubCategoryList(subCategoryList);
        }
        return categoryList;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryDAO.getCategoryById(id);
    }

    @Override
    public Category getCategoryByIdWithParent(Long id) {
        return categoryDAO.getCategoryByIdWithParent(id);
    }

}
