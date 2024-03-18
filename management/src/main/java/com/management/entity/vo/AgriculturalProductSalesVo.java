package com.management.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author TokisakiKurumi
 * @className AgriculturalProductSalesVo
 * @date 2024/3/13
 * @description
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AgriculturalProductSalesVo {
    private Integer saleId;

    private Integer productId;

    private String productName;

    private Date saleDate;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;

    private String customerName;

    private String customerContact;

    private String paymentMethod;

    private String deliveryAddress;

    private String customerFeedback;
}
