package com.phc.phcstore.storeorder.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phc.phcbstort.common.utils.PageUtils;
import com.phc.phcbstort.common.utils.Query;
import com.phc.phcstore.storeorder.order.dao.OrderItemDao;
import com.phc.phcstore.storeorder.order.entity.OrderEntity;
import com.phc.phcstore.storeorder.order.entity.OrderItemEntity;
import com.phc.phcstore.storeorder.order.entity.OrderReturnReasonEntity;
import com.phc.phcstore.storeorder.order.service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("orderItemService")
@Slf4j
@RabbitListener(queues = {"hello-java-queue"})
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
     * <p>
     * queue： 很多人都可以来监听，只要收到消息，队列删除消息，只能有一个接受到消息
     * 1） 订单服务启动多个
     * 2） 只有一个消息完全处理完才能接受下一个消息
     * <p>
     * 最后的使用
     *
     * @RabbitListener 标记在类上，说明要监听那些队列
     * @@RabbitHandler 标记在方法上，重载区分不同的消息
     */
    @RabbitHandler
    public void receiveMessage1(OrderReturnReasonEntity content) {
        log.info("receiveMessage 1监听到的消息为{} ", content);
    }

    @RabbitHandler
    public void receiveMessage2(OrderEntity content) {
        log.info("receiveMessage 2监听到的消息为{}", content);
    }
}