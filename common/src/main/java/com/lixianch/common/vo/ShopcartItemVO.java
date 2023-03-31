package com.lixianch.common.vo;

import lombok.Data;

/**
 * created by lixianch on 2023/3/31
 */
@Data
public class ShopcartItemVO {
    private String goodsCode;
    private String goodsName;
    private Long num;
    private Long price;
    private String userName;
}
