package com.phc.phcstore.storecoupon.coupon.dao;

import com.phc.phcstore.storecoupon.coupon.entity.MemberPriceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品会员价格
 * 
 * @author phcbest
 * @email phcbest2017@outlook.com
 * @date 2021-06-22 11:15:45
 */
@Mapper
public interface MemberPriceDao extends BaseMapper<MemberPriceEntity> {
	
}
