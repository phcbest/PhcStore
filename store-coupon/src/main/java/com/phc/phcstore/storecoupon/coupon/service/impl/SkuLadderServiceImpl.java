package com.phc.phcstore.storecoupon.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phc.phcbstort.common.utils.PageUtils;
import com.phc.phcbstort.common.utils.Query;

import com.phc.phcstore.storecoupon.coupon.dao.SkuLadderDao;
import com.phc.phcstore.storecoupon.coupon.entity.SkuLadderEntity;
import com.phc.phcstore.storecoupon.coupon.service.SkuLadderService;


@Service("skuLadderService")
public class SkuLadderServiceImpl extends ServiceImpl<SkuLadderDao, SkuLadderEntity> implements SkuLadderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuLadderEntity> page = this.page(
                new Query<SkuLadderEntity>().getPage(params),
                new QueryWrapper<SkuLadderEntity>()
        );

        return new PageUtils(page);
    }

}