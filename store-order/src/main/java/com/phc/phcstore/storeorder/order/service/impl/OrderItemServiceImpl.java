package com.phc.phcstore.storeorder.order.service.impl;

import com.phc.phcstore.storeorder.order.entity.OrderReturnReasonEntity;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phc.phcbstort.common.utils.PageUtils;
import com.phc.phcbstort.common.utils.Query;

import com.phc.phcstore.storeorder.order.dao.OrderItemDao;
import com.phc.phcstore.storeorder.order.entity.OrderItemEntity;
import com.phc.phcstore.storeorder.order.service.OrderItemService;


@Service("orderItemService")
@Slf4j
public class OrderItemServiceImpl extends ServiceImpl<OrderItemDao, OrderItemEntity> implements OrderItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderItemEntity> page = this.page(
                new Query<OrderItemEntity>().getPage(params),
                new QueryWrapper<OrderItemEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * queue：声明需要监听的所有队列
     * 方法参数可以写一下类型
     * 1. Message message 原生消息详细信息
     * 2. T<发送的消息类型> OrderReturnReasonEntity content
     * 3. Channel 当前传输数据的通道
     *
     *
     *
     */
    @RabbitListener(queues = {"hello-java-queue"})
    public void receiveMessage(Message message,
                               OrderReturnReasonEntity content,
                               Channel channel) {
        //获得消息体
        byte[] body = message.getBody();
        //获得消息头的属性
        MessageProperties messageProperties = message.getMessageProperties();

        log.info("监听到的消息为{} \n 内容为{}", message, content);
    }
}