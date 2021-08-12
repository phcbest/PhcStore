package com.phc.phcstore.storeorder.order.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Author: PengHaiChen
 * @Description:
 * @Date: Create in 14:35 2021/8/10
 */
@Configuration
@Slf4j
public class MyRabbitConfig {
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Autowired
    public RabbitTemplate rabbitTemplate;

    /**
     * 定制rabbitTemplate 设置确认回调
     *
     * @PostConstruct MyRabbitConfig对象创建完成后，执行这个方法
     */
    @PostConstruct
    public void initRabbitTemplate() {
        //消息抵达broker的确认回调
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             * 只要消息抵达Broker ack = true
             * @param correlationData 当前消息的唯一关联数据
             * @param ack 消息是否成功收到
             * @param cause 失败的原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("消息数据【{}】 消息接受状态【{}】 消息失败的原因【{}】", correlationData, ack, cause);
            }
        });

        //消息抵达队列的回调
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /***
             * 只要消息没有投递给指定的队列，就会触发这个回调
             * @param message   投递失败的消息内容
             * @param replyCode 回复的状态码
             * @param replyText 回复的文本内容
             * @param exchange  发送给的交换机
             * @param routingKey 消息的路由键
             */
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.error("进入队列失败的消息==>{} ,回复码==>{} ,回复==>{} ,交换机==>{} , 路由键==>{} ",
                        message, replyCode, replyText, exchange, routingKey);

            }
        });
    }

}
