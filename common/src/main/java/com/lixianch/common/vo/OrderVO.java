package com.lixianch.common.vo;

import lombok.Data;

import java.util.List;

/**
 * created by lixianch on 2023/3/31
 */
@Data
public class OrderVO {
    private String orderNo;
    private List<OrderItemVO> items;
}
