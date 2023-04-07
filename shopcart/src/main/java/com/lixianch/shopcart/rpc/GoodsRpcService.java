package com.lixianch.shopcart.rpc;

import com.lixianch.common.vo.GoodsVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by lixianch on 2023/4/6
 */
@FeignClient(name = "spring-cloud-ali-goods", fallback = GoodsRpcServiceFallback.class, configuration = FeignConfiguration.class)
//@RequestMapping("/goods")
public interface GoodsRpcService {
    @GetMapping("/goods/{goodsCode}")
    GoodsVO queryGoods(@PathVariable String goodsCode);
}
class FeignConfiguration {
    @Bean
    public GoodsRpcServiceFallback goodsRpcServiceFallback() {
        return new GoodsRpcServiceFallback();
    }
}