package com.phc.phcstore.storeorder;

import com.phc.phcstore.storeorder.order.entity.OrderReturnApplyEntity;
import com.phc.phcstore.storeorder.order.entity.OrderReturnReasonEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@Slf4j
@SpringBootTest
class StoreOrderApplicationTests {

    /***
     * 创建Exchange，queue，并且绑定关系
     *  使用全参构造器创建交换机
     */

    @Autowired
    AmqpAdmin amqpAdmin;
    private String string;

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

    /**
     * 测试发送消息
     * 第一个参数为交换机名字
     * 第二个参数为路由键
     * 第三个参数为消息内容
     */
    @Test
    void sendMessageTest() {
        string = "hello world";
        //发送对象  如果发送的消息是一个对象，会使用序列化机制
        OrderReturnReasonEntity orderReturnReasonEntity = new OrderReturnReasonEntity();
        orderReturnReasonEntity.setId(1L);
        orderReturnReasonEntity.setCreateTime(new Date());
        orderReturnReasonEntity.setName("hahahahah");
        rabbitTemplate.convertAndSend("hello-java-exchange", "hello.key",
                orderReturnReasonEntity);
        log.info("发送消息{} 成功", orderReturnReasonEntity);
    }
}
