package com.management.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author TokisakiKurumi
 * @className IrrigationRecordVo
 * @date 2024/3/8
 * @description
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IrrigationRecordVo {
    private Integer irrigationId;

    private Long farmId;

    private String farmName;

    private Integer landId;

    private Date irrigationDate;

    private BigDecimal irrigationDuration;

    private BigDecimal waterConsumption;

    private String irrigationMethod;

    private String notes;
}
