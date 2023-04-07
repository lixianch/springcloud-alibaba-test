package com.lixianch.shopcart.rpc;

import com.lixianch.common.vo.GoodsVO;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * created by lixianch on 2023/4/6
 */
public class GoodsRpcServiceFallback implements GoodsRpcService {
    @Override
    public GoodsVO queryGoods(@PathVariable String goodsCode) {
        GoodsVO goodsVO = new GoodsVO();
        goodsVO.setGoodsCode(goodsCode);
        goodsVO.setGoodsName("Mock goods");
        goodsVO.setPrice(0L);

        return goodsVO;
    }
}
