package com.imooc.mall.service;

import com.imooc.mall.model.pojo.Category;
import com.imooc.mall.request.AddCategoryReq;
import com.imooc.mall.request.UpdateCategoryReq;
import org.springframework.stereotype.Service;


public interface CategoryService {
    void add(AddCategoryReq addCategoryReq);

    void update(UpdateCategoryReq updateCategory);
}
