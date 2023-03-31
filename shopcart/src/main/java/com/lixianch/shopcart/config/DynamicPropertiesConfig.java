package com.lixianch.shopcart.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * created by lixianch on 2023/3/31
 */
@Component
@ConfigurationProperties(prefix = "dynamic.config")
@Data
@RefreshScope
public class DynamicPropertiesConfig {
    private String userName;
}
