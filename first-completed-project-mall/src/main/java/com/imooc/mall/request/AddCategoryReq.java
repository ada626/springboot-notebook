package com.imooc.mall.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AddCategoryReq {
    @Size(min=2,max=5)
    @NotNull(message = "名字不能为空")
    private String name;

    @NotNull(message = "层级数不能为空")
    @Max(3)
    private Integer type;

    @NotNull(message = "目录不能为空")
    private Integer parentId;

    @NotNull(message = "订单号不能为空")
    private Integer orderNum;
}
