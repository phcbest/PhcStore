package com.phc.phcstore.storeorder;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class StoreOrderApplicationTests {

    /***
     * 创建Exchange，queue，并且绑定关系
     *  使用全参构造器创建交换机
     */

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    void contextLoads() {
        DirectExchange directExchange = new DirectExchange("hello-java-exchange", true, false);
        amqpAdmin.declareExchange(directExchange);
        log.info("exchange [{}] create success", "hello-java-exchange");

    }

    @Test
    void createQueue() {
        Queue queue = new Queue("hello-java-queue", true, false, false);
        amqpAdmin.declareQueue(queue);
        log.info("create queue [{}]success", "hello-java-queue");

    }

    @Test
    void createBinding() {
        Binding binding = new Binding("hello-java-queue", Binding.DestinationType.QUEUE,
                "hello-java-exchange", "hello.key", null);
        amqpAdmin.declareBinding(binding);
        log.info("交换机 {} 与队列 {} 绑定成功", "hello-java-exchange", "hello-java-queue");
    }

    @Autowired
    RabbitTemplate rabbitTemplate;

    //测试发送消息
    @Test
    void sendMessageTest() {
//        rabbitTemplate.convertAndSend();
    }
}
