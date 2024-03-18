package com.management.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author TokisakiKurumi
 * @className LandVo
 * @date 2024/3/7
 * @description
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LandVo {
    private Integer landId;

    private String location;

    private BigDecimal area;

    private String topography;

    private String soilType;

    private String ownership;

    private Integer ownerId;

    private String landUse;

    private String ecologicalEnvironment;

    private BigDecimal marketValue;

    private String planningUse;

    private String ownerIntent;

}
