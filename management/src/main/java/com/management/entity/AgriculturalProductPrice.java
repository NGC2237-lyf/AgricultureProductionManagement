package com.management.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author TokisakiKurumi
 * @className AgriculturalProductPrice
 * @date 2024/3/12
 * @description
 **/
@Data
@NoArgsConstructor
@ToString
@TableName("agricultural_product_price")
public class AgriculturalProductPrice {
    private Integer productId;
    private String productName;
    private String unit;
    private BigDecimal price;
    private String description;

}
