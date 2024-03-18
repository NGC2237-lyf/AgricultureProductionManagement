package com.management.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author TokisakiKurumi
 * @className CropPlantingPlanVo
 * @date 2024/3/8
 * @description
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CropPlantingPlanVo {
    private Integer planId;

    private Integer farmId;

    private String farmName;

    private Integer year;

    private String season;

    private Integer landId;

    private String cropType;

    private BigDecimal plantingArea;

    private BigDecimal expectedYield;

    private Date plantingDate;

    private Date harvestDate;

    private String plantingMethod;

    private String fertilizerUsage;

    private String pesticideUsage;

    private String notes;
}
