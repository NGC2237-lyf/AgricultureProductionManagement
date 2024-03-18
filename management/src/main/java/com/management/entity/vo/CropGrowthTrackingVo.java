package com.management.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author TokisakiKurumi
 * @className CropGrowthTrackingVo
 * @date 2024/3/8
 * @description
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CropGrowthTrackingVo {
    private Integer trackingId;

    private Integer farmId;

    private String farmName;

    private Integer landId;

    private String cropType;

    private String growthStage;

    private Date observationDate;

    private BigDecimal height;

    private BigDecimal canopyWidth;

    private String leafColor;

    private String pestPresence;

    private String diseasePresence;

    private String nutrientDeficiency;

    private String notes;
}
