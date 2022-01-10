package com.imooc.mall.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UpdateCategoryReq {
    @NotNull(message = "id不能为null")
    private Integer id;

    @Size(min=2,max=6)
    @NotNull(message = "name不能为null")
    private String name;

    @NotNull
    @Max(3)
    private Integer type;

    @NotNull(message = "parentId不能为null")
    private Integer parentId;

    @NotNull(message = "orderNum不能为null")
    private Integer orderNum;

}
