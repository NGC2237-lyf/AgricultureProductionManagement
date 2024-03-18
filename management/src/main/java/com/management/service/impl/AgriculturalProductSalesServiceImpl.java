package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.entity.AgriculturalProductSales;
import com.management.entity.vo.AgriculturalProductSalesVo;
import com.management.service.AgriculturalProductSalesService;
import com.management.mapper.AgriculturalProductSalesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lenovo
* @description 针对表【agricultural_product_sales】的数据库操作Service实现
* @createDate 2024-03-07 21:03:05
*/
@Service
public class AgriculturalProductSalesServiceImpl extends ServiceImpl<AgriculturalProductSalesMapper, AgriculturalProductSales>
    implements AgriculturalProductSalesService{

    @Autowired
    private AgriculturalProductSalesMapper agriculturalProductSalesMapper;

    @Override
    public List<AgriculturalProductSalesVo> getAll() {
        return agriculturalProductSalesMapper.getAll();
    }

    @Override
    public List<AgriculturalProductSalesVo> getAgriculturalProductSales(Integer productId) {
        return agriculturalProductSalesMapper.getAgriculturalProductSales(productId);
    }
}




