package com.management.service;

import com.management.entity.AgriculturalProductSales;
import com.baomidou.mybatisplus.extension.service.IService;
import com.management.entity.vo.AgriculturalProductSalesVo;

import java.util.List;

/**
* @author lenovo
* @description 针对表【agricultural_product_sales】的数据库操作Service
* @createDate 2024-03-07 21:03:05
*/
public interface AgriculturalProductSalesService extends IService<AgriculturalProductSales> {

    List<AgriculturalProductSalesVo> getAll();

    List<AgriculturalProductSalesVo> getAgriculturalProductSales(Integer productId);
}
