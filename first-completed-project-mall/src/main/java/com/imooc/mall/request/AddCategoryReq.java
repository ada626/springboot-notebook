package com.imooc.mall.request;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class AddCategoryReq {
    @Size(min=2,max=5)
    private String name;

    private Integer type;

    private Integer parentId;

    private Integer orderNum;
}
