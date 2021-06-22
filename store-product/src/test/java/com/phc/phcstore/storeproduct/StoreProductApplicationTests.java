package com.phc.phcstore.storeproduct;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.phc.phcstore.storeproduct.product.entity.BrandEntity;
import com.phc.phcstore.storeproduct.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StoreProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {

//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setBrandId(1L);
//        brandEntity.setDescript("我比较想买的");
//
//        brandService.updateById(brandEntity);

        List<BrandEntity> brand_id = brandService.list(new QueryWrapper<BrandEntity>()
                .eq("brand_id", 1L));
        brand_id.forEach((item)->{
            System.out.println(item);
        });

    }

}
