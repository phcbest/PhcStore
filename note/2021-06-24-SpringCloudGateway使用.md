---
layout: article
title: Gateway的使用
tags: ["Gateway","SpringCloud"]
---

# [SpringCloudGateway](https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/)

---

### 基本组成

- Route 路由  网关的基本构建模块是 ID ，目标URI，断言集合和过滤器集合  
- Predicate 断言 匹配http请求的内容
- Filter 过滤器 在request发送到下游之前或之后修改http的request或response

### 工作流程

请求到达网关，网关利用断言判断是否符合路由规则，如果符合路由规则，就通过过滤器进入到服务中

### 使用方法

1. 创建一个服务网关，注册进nacos中。注意不同的服务中，下面两条配置的版本号要保证一致，不然会报找不到装配对象

   ```xml
   <parent>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-parent</artifactId>
       <version>2.2.5.RELEASE</version>
       <relativePath/> <!-- lookup parent from repository -->
   </parent>
   
       <properties>
           <java.version>1.8</java.version>
           <spring-cloud.version>Hoxton.SR9</spring-cloud.version>
       </properties>
   ```

2. 编写配置

   ```yml
   spring:
     cloud:
       gateway:
         routes:
           - id: test_routes
             uri: http://www.baidu.com
             predicates:
               - Query=url,wb
   #访问 http://localhost:88/?url=wb
           - id: qq_routes
             uri: http://www.qq.com
             predicates:
               - Query=url,qq
   #访问 http://localhost:88/?url=qq
   ```

3. 注意网关需要排除数据源，需要修改主类的注解`@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})`

4. 注意要在bootstrap.properties中配置好配置中心的参数

   ```properties
   spring.application.name=store-gateway
   spring.cloud.nacos.config.server-addr=192.168.23.182:8848
   spring.cloud.nacos.config.namespace=5f4404a5-36ac-4e2b-a3aa-66143182bab4
   ```

5. 注意要在application.properties中配置好注册中心的参数

   ```properties
   spring.cloud.nacos.discovery.server-addr=192.168.23.182:8848
   spring.application.name=store-gateway
   server.port=88
   ```

   

