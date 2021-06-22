package com.phc.phcstore.storecoupon.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phc.phcbstort.common.utils.PageUtils;
import com.phc.phcbstort.common.utils.Query;

import com.phc.phcstore.storecoupon.coupon.dao.CouponSpuRelationDao;
import com.phc.phcstore.storecoupon.coupon.entity.CouponSpuRelationEntity;
import com.phc.phcstore.storecoupon.coupon.service.CouponSpuRelationService;


@Service("couponSpuRelationService")
public class CouponSpuRelationServiceImpl extends ServiceImpl<CouponSpuRelationDao, CouponSpuRelationEntity> implements CouponSpuRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CouponSpuRelationEntity> page = this.page(
                new Query<CouponSpuRelationEntity>().getPage(params),
                new QueryWrapper<CouponSpuRelationEntity>()
        );

        return new PageUtils(page);
    }

}