package com.imooc.mall.controller;

import com.imooc.mall.common.ApiRestResponse;
import com.imooc.mall.common.Constant;
import com.imooc.mall.exception.MallExceptionEnum;
import com.imooc.mall.model.pojo.User;
import com.imooc.mall.request.AddCategoryReq;
import com.imooc.mall.request.UpdateCategoryReq;
import com.imooc.mall.service.CategoryService;
import com.imooc.mall.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class CategoryController {
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;

    @PostMapping("admin/category/add")
    @ResponseBody
    public ApiRestResponse addCategory(HttpSession session, @Validated @RequestBody AddCategoryReq addCategoryReq){
        //check
        User curUser = (User) session.getAttribute(Constant.MALL_USER);
        if (userService.checkAdminRole(curUser)) {
            categoryService.add(addCategoryReq);
            return ApiRestResponse.success();
        }else{
            return ApiRestResponse.error(MallExceptionEnum.NEED_ADMIN);
        }
    }

    @PostMapping("admin/category/update")
    @ResponseBody
    public ApiRestResponse updateCategory(HttpSession session,@Validated @RequestBody UpdateCategoryReq updateCategoryReq){
        User curUser = (User) session.getAttribute(Constant.MALL_USER);
        if (userService.checkAdminRole(curUser)) {
            categoryService.update(updateCategoryReq);
            return ApiRestResponse.success();
        }else{
            return ApiRestResponse.error(MallExceptionEnum.NEED_ADMIN);
        }
    }
}
