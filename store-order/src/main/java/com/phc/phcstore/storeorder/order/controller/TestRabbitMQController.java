package com.phc.phcstore.storeorder.order.controller;

import com.phc.phcstore.storeorder.order.entity.OrderEntity;
import com.phc.phcstore.storeorder.order.entity.OrderReturnReasonEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: PengHaiChen
 * @Description:
 * @Date: Create in 10:12 2021/8/11
 */
@RestController
@Slf4j
public class TestRabbitMQController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg")
    public String test(@RequestParam(value = "num", defaultValue = "10") Integer num) {
        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) {
                OrderReturnReasonEntity orderReturnReasonEntity = new OrderReturnReasonEntity();
                orderReturnReasonEntity.setId(1L);
                orderReturnReasonEntity.setCreateTime(new Date());
                orderReturnReasonEntity.setName("偶数");
                rabbitTemplate.convertAndSend("hello-java-exchange", "hello.key",
                        orderReturnReasonEntity);
                log.info("发送消息{} 成功", orderReturnReasonEntity);
            } else {
                OrderEntity orderEntity = new OrderEntity();
                orderEntity.setBillContent("偶数");
                rabbitTemplate.convertAndSend("hello-java-exchange", "hello.key",
                        orderEntity);
                log.info("发送消息{} 成功", orderEntity);
            }
        }
        return "success";
    }
}
