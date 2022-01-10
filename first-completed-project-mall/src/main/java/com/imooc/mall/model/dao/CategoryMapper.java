package com.imooc.mall.model.dao;

import com.imooc.mall.model.pojo.Category;
import org.springframework.stereotype.Repository;

import java.util.Calendar;

@Repository
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    Category selectByName(String name);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}