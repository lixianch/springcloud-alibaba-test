package com.lixianch.shopcart.service;

import com.lixianch.common.MessageException;
import com.lixianch.common.vo.GoodsVO;
import com.lixianch.shopcart.domain.ShopcartItemDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * created by lixianch on 2023/3/31
 */
@Service
@Slf4j
public class ShopcartService {
    @Resource
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public ShopcartItemDO addItem(String goodsCode, Long num){
        ServiceInstance serviceInstance = loadBalancerClient.choose("spring-cloud-ali-goods");
        log.info(String.format("host=%s, port=%s", serviceInstance.getHost(), serviceInstance.getPort()));
        ResponseEntity<GoodsVO> entity = restTemplate.getForEntity(String.format("http://%s:%s/goods/%s", serviceInstance.getHost(), serviceInstance.getPort(), goodsCode), GoodsVO.class);
        if(entity.getStatusCode() != HttpStatus.OK){
            throw new MessageException("未找到对应商品");
        }
        GoodsVO goodsVO = entity.getBody();
        ShopcartItemDO itemDO = new ShopcartItemDO();
        itemDO.setGoodsCode(goodsVO.getGoodsCode());
        itemDO.setGoodsName(goodsVO.getGoodsName());
        itemDO.setNum(num);
        itemDO.setPrice(goodsVO.getPrice());
        return itemDO;
    }
}
