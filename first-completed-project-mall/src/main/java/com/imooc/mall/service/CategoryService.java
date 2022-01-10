package com.imooc.mall.service;

import com.imooc.mall.request.AddCategoryReq;
import org.springframework.stereotype.Service;


public interface CategoryService {
    void add(AddCategoryReq addCategoryReq);
}
