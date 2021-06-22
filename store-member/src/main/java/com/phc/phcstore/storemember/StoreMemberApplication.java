package com.phc.phcstore.storemember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 想要远程调用别的服务
 * 1） 引入欧鹏feign
 * 2） 编写一个接口 告诉spring cloud这个接口需要远程调用
 * 3） 接口接口的每一个方法都是都是声明调用远程服务的请求
 * 4） 在main 中使用EnableFeignClients(basePackages ="xxx")注解开启远程调用功能,xxx是需要扫描的feign的路径
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.phc.phcstore.storemember.member.feign")
@SpringBootApplication
public class StoreMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreMemberApplication.class, args);
    }

}
