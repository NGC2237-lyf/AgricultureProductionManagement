package com.management.service;

import com.management.entity.AgriculturalProduct;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author lenovo
* @description 针对表【agricultural_product】的数据库操作Service
* @createDate 2024-03-07 21:03:05
*/
public interface AgriculturalProductService extends IService<AgriculturalProduct> {

    boolean insertProduct(List<AgriculturalProduct> products);
}
