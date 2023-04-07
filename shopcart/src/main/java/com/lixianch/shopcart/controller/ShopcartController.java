package com.lixianch.shopcart.controller;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lixianch.common.vo.ShopcartItemVO;
import com.lixianch.shopcart.config.DynamicPropertiesConfig;
import com.lixianch.shopcart.domain.ShopcartItemDO;
import com.lixianch.shopcart.service.ShopcartService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created by lixianch on 2023/3/31
 */
@RestController
@RequestMapping("/shopcart")
public class ShopcartController {
    @Resource
    private ShopcartService shopcartService;
    @Resource
    private DynamicPropertiesConfig dynamicPropertiesConfig;

    @PutMapping("/{goodsCode}/{num}")
    @SentinelResource(value = "shopcartAddItem", blockHandler = "addItemBlockHandler")
    public ShopcartItemVO addItem(@PathVariable String goodsCode, @PathVariable Long num){
        ShopcartItemDO itemDO = shopcartService.addItem(goodsCode, num);
        ShopcartItemVO itemVO = BeanUtil.copyProperties(itemDO, ShopcartItemVO.class);
        itemVO.setUserName(dynamicPropertiesConfig.getUserName());
        return itemVO;
    }

    public ShopcartItemVO addItemBlockHandler(@PathVariable String goodsCode, @PathVariable Long num, BlockException e){
        ShopcartItemVO itemVO = new ShopcartItemVO();
        itemVO.setGoodsName("fail:" + e.getMessage());
        return itemVO;
    }
}
