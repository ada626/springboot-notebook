package com.imooc.mall.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.imooc.mall.exception.MallException;
import com.imooc.mall.exception.MallExceptionEnum;
import com.imooc.mall.model.dao.CategoryMapper;
import com.imooc.mall.model.pojo.Category;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.request.AddCategoryReq;
import com.imooc.mall.request.UpdateCategoryReq;
import com.imooc.mall.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void add(AddCategoryReq addCategoryReq){
        Category category = new Category();
        BeanUtils.copyProperties(addCategoryReq,category);
        Category categoryOdd = (Category) categoryMapper.selectByName(addCategoryReq.getName());
        if (categoryOdd!=null) {
            throw new MallException(MallExceptionEnum.NAME_EXISTED);
        }
        int count = categoryMapper.insertSelective(category);
        if(count==0){
            throw new MallException(MallExceptionEnum.INSERT_FAILED);
        }
    }

    @Override
    public void update(UpdateCategoryReq updateCategory){
        Category category = new Category();
        BeanUtils.copyProperties(updateCategory,category);
        if (category.getName()!=null) {
            Category categoryOdd = (Category) categoryMapper.selectByName(category.getName());
            if(categoryOdd!=null&&categoryOdd.getId().equals(category.getId())){
                throw new MallException(MallExceptionEnum.NAME_EXISTED);
            }
        }
        int count = categoryMapper.updateByPrimaryKeySelective(category);
        if (count==0) {
            throw new MallException(MallExceptionEnum.ID_EXIST);
        }
    }
}
