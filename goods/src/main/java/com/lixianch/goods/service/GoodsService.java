package com.lixianch.goods.service;

import com.lixianch.goods.domain.GoodsDO;
import org.springframework.stereotype.Service;

/**
 * created by lixianch on 2023/3/30
 */
@Service
public class GoodsService {
    public GoodsDO queryGoodsByCode(String goodsCode) {
        GoodsDO goodsDO = new GoodsDO();
        goodsDO.setId(1000L);
        goodsDO.setGoodsCode("1000");
        goodsDO.setGoodsName("测试商品2");
        goodsDO.setPrice(100L);

        return goodsDO;
    }
}
