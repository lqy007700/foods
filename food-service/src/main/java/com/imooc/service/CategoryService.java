package com.imooc.service;

import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;

import java.util.List;

public interface CategoryService {
    List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类id 查询子分类信息
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * 首页一级分类下的6个商品
     */
    List<NewItemsVO> getSixNewItemsLazy(Integer roomCatId);
}
