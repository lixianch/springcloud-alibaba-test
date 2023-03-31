package com.lixianch.shopcart.domain;


import lombok.Data;

/**
 * created by lixianch on 2023/3/31
 */
@Data
public class ShopcartItemDO {
    private Long id;
    private String goodsCode;
    private String goodsName;
    private Long num;
    private Long price;
}
