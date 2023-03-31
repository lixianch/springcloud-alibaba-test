package com.lixianch.order.controller;

import com.lixianch.common.vo.OrderVO;
import com.lixianch.order.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created by lixianch on 2023/3/31
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Resource
    private OrderService orderService;

    public OrderVO queryByCode(String orderCode) {
        return null;
    }
}
