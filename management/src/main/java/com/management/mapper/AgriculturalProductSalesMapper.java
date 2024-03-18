package com.management.mapper;

import com.management.entity.AgriculturalProductSales;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.management.entity.vo.AgriculturalProductSalesVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author lenovo
* @description 针对表【agricultural_product_sales】的数据库操作Mapper
* @createDate 2024-03-07 21:03:05
* @Entity com.management.entity.AgriculturalProductSales
*/
@Mapper
public interface AgriculturalProductSalesMapper extends BaseMapper<AgriculturalProductSales> {

    List<AgriculturalProductSalesVo> getAll();

    List<AgriculturalProductSalesVo> getAgriculturalProductSales(@Param("productId") Integer productId);

}




