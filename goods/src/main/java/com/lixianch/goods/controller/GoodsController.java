package com.lixianch.goods.controller;

import cn.hutool.core.bean.BeanUtil;
import com.lixianch.common.vo.GoodsVO;
import com.lixianch.goods.domain.GoodsDO;
import com.lixianch.goods.service.GoodsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * created by lixianch on 2023/3/30
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @GetMapping("/{goodsCode}")
    public GoodsVO queryGoods(@PathVariable String goodsCode) {
        GoodsDO goodsDO = goodsService.queryGoodsByCode(goodsCode);
        GoodsVO goodsVO = BeanUtil.copyProperties(goodsDO, GoodsVO.class);

        return goodsVO;
    }
}
