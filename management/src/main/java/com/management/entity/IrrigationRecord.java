package com.management.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @TableName irrigation_record
 */
@Data
@TableName("irrigation_record")
public class IrrigationRecord implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer irrigationId;

    private Long farmId;

    private Integer landId;

    private Date irrigationDate;

    private BigDecimal irrigationDuration;

    private BigDecimal waterConsumption;

    private String irrigationMethod;

    private String notes;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        IrrigationRecord other = (IrrigationRecord) that;
        return (this.getIrrigationId() == null ? other.getIrrigationId() == null : this.getIrrigationId().equals(other.getIrrigationId()))
            && (this.getFarmId() == null ? other.getFarmId() == null : this.getFarmId().equals(other.getFarmId()))
            && (this.getLandId() == null ? other.getLandId() == null : this.getLandId().equals(other.getLandId()))
            && (this.getIrrigationDate() == null ? other.getIrrigationDate() == null : this.getIrrigationDate().equals(other.getIrrigationDate()))
            && (this.getIrrigationDuration() == null ? other.getIrrigationDuration() == null : this.getIrrigationDuration().equals(other.getIrrigationDuration()))
            && (this.getWaterConsumption() == null ? other.getWaterConsumption() == null : this.getWaterConsumption().equals(other.getWaterConsumption()))
            && (this.getIrrigationMethod() == null ? other.getIrrigationMethod() == null : this.getIrrigationMethod().equals(other.getIrrigationMethod()))
            && (this.getNotes() == null ? other.getNotes() == null : this.getNotes().equals(other.getNotes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIrrigationId() == null) ? 0 : getIrrigationId().hashCode());
        result = prime * result + ((getFarmId() == null) ? 0 : getFarmId().hashCode());
        result = prime * result + ((getLandId() == null) ? 0 : getLandId().hashCode());
        result = prime * result + ((getIrrigationDate() == null) ? 0 : getIrrigationDate().hashCode());
        result = prime * result + ((getIrrigationDuration() == null) ? 0 : getIrrigationDuration().hashCode());
        result = prime * result + ((getWaterConsumption() == null) ? 0 : getWaterConsumption().hashCode());
        result = prime * result + ((getIrrigationMethod() == null) ? 0 : getIrrigationMethod().hashCode());
        result = prime * result + ((getNotes() == null) ? 0 : getNotes().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", irrigationId=").append(irrigationId);
        sb.append(", farmId=").append(farmId);
        sb.append(", landId=").append(landId);
        sb.append(", irrigationDate=").append(irrigationDate);
        sb.append(", irrigationDuration=").append(irrigationDuration);
        sb.append(", waterConsumption=").append(waterConsumption);
        sb.append(", irrigationMethod=").append(irrigationMethod);
        sb.append(", notes=").append(notes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}