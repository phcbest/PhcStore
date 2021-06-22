package com.phc.phcstore.storeorder.order.dao;

import com.phc.phcstore.storeorder.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author phcbest
 * @email phcbest2017@outlook.com
 * @date 2021-06-22 12:30:28
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
