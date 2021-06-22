package com.phc.phcstore.storemember.member.feign;

import com.phc.phcbstort.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: PengHaiChen
 * @Description:
 * @Date: Create in 15:11 2021/6/22
 * feignClient这个注解的作用是声明这个是一个调用接口的类，对应的模块是store-coupon
 */

@FeignClient("store-coupon")
public interface CouponFeignService {

    /**
     *
     * @return
     */
    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();
}
