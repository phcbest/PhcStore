package com.phc.phcstore.storecoupon.coupon.dao;

import com.phc.phcstore.storecoupon.coupon.entity.HomeSubjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 * 
 * @author phcbest
 * @email phcbest2017@outlook.com
 * @date 2021-06-22 11:15:45
 */
@Mapper
public interface HomeSubjectDao extends BaseMapper<HomeSubjectEntity> {
	
}
