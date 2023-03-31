package com.lixianch.order.service;

import com.lixianch.common.vo.GoodsVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * created by lixianch on 2023/3/31
 */
@Service
public class OrderService {
    @Resource
    private RestTemplate restTemplate;

    public GoodsVO queryOrderByCode(String orderCode) {
        ResponseEntity<GoodsVO> entity = restTemplate.getForEntity("http://localhost:8001/goods/1000", GoodsVO.class);

        return entity.getBody();
    }
}
