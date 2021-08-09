package com.phc.phcstore.storeproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1 整合mybatis-plus
 * 1） 导入依赖 mybatis-plus-boot-starter
 * 2)  配置数据源
 * 3)  使用MapperScan 配置扫描dao层路径
 * 4） 配置扫描 xml 路径 mapper-locations
 */
@EnableDiscoveryClient
@MapperScan("com.phc.phcstore.storeproduct.product.dao")
@SpringBootApplication
public class StoreProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreProductApplication.class, args);
    }

}
