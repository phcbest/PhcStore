package com.phc.phcstore.storeorder.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phc.phcbstort.common.utils.PageUtils;
import com.phc.phcbstort.common.utils.Query;

import com.phc.phcstore.storeorder.order.dao.OrderReturnReasonDao;
import com.phc.phcstore.storeorder.order.entity.OrderReturnReasonEntity;
import com.phc.phcstore.storeorder.order.service.OrderReturnReasonService;


@Service("orderReturnReasonService")
public class OrderReturnReasonServiceImpl extends ServiceImpl<OrderReturnReasonDao, OrderReturnReasonEntity> implements OrderReturnReasonService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderReturnReasonEntity> page = this.page(
                new Query<OrderReturnReasonEntity>().getPage(params),
                new QueryWrapper<OrderReturnReasonEntity>()
        );

        return new PageUtils(page);
    }

}