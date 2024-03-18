package com.management.Task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.management.entity.AgriculturalProductPrice;
import com.management.service.AgriculturalProductPriceService;
import com.management.service.AgriculturalProductService;
import com.management.service.impl.AgriculturalProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author TokisakiKurumi
 * @className ProductPriceTask
 * @date 2024/3/12
 * @description
 **/
@Component
public class ProductPriceTask {

    @Autowired
    private AgriculturalProductPriceService agriculturalProductPriceService;

    @Autowired
    private AgriculturalProductServiceImpl agriculturalProductService;

    public void run()
    {
        QueryWrapper<AgriculturalProductPrice> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("distinct product_id , product_name");
        List<AgriculturalProductPrice> agriculturalProductPrices = agriculturalProductPriceService.getBaseMapper().selectList(queryWrapper);
        agriculturalProductPrices.forEach(agriculturalProductPrice -> {
            if (ObjectUtils.isEmpty(agriculturalProductService.getById(agriculturalProductPrice.getProductId()))) {
                agriculturalProductPriceService.remove(new QueryWrapper<AgriculturalProductPrice>().eq("product_id", agriculturalProductPrice.getProductId()));
            } else {
                agriculturalProductService.updateData(agriculturalProductPrice.getProductId(),agriculturalProductPrice.getProductName());
            }
        });
    }
}
