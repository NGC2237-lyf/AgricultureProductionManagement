package com.management.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @TableName crop_planting_plan
 */
@Data
@TableName("crop_planting_plan")
public class CropPlantingPlan implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer planId;

    private Integer farmId;

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
        CropPlantingPlan other = (CropPlantingPlan) that;
        return (this.getPlanId() == null ? other.getPlanId() == null : this.getPlanId().equals(other.getPlanId()))
            && (this.getFarmId() == null ? other.getFarmId() == null : this.getFarmId().equals(other.getFarmId()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getSeason() == null ? other.getSeason() == null : this.getSeason().equals(other.getSeason()))
            && (this.getLandId() == null ? other.getLandId() == null : this.getLandId().equals(other.getLandId()))
            && (this.getCropType() == null ? other.getCropType() == null : this.getCropType().equals(other.getCropType()))
            && (this.getPlantingArea() == null ? other.getPlantingArea() == null : this.getPlantingArea().equals(other.getPlantingArea()))
            && (this.getExpectedYield() == null ? other.getExpectedYield() == null : this.getExpectedYield().equals(other.getExpectedYield()))
            && (this.getPlantingDate() == null ? other.getPlantingDate() == null : this.getPlantingDate().equals(other.getPlantingDate()))
            && (this.getHarvestDate() == null ? other.getHarvestDate() == null : this.getHarvestDate().equals(other.getHarvestDate()))
            && (this.getPlantingMethod() == null ? other.getPlantingMethod() == null : this.getPlantingMethod().equals(other.getPlantingMethod()))
            && (this.getFertilizerUsage() == null ? other.getFertilizerUsage() == null : this.getFertilizerUsage().equals(other.getFertilizerUsage()))
            && (this.getPesticideUsage() == null ? other.getPesticideUsage() == null : this.getPesticideUsage().equals(other.getPesticideUsage()))
            && (this.getNotes() == null ? other.getNotes() == null : this.getNotes().equals(other.getNotes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPlanId() == null) ? 0 : getPlanId().hashCode());
        result = prime * result + ((getFarmId() == null) ? 0 : getFarmId().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getSeason() == null) ? 0 : getSeason().hashCode());
        result = prime * result + ((getLandId() == null) ? 0 : getLandId().hashCode());
        result = prime * result + ((getCropType() == null) ? 0 : getCropType().hashCode());
        result = prime * result + ((getPlantingArea() == null) ? 0 : getPlantingArea().hashCode());
        result = prime * result + ((getExpectedYield() == null) ? 0 : getExpectedYield().hashCode());
        result = prime * result + ((getPlantingDate() == null) ? 0 : getPlantingDate().hashCode());
        result = prime * result + ((getHarvestDate() == null) ? 0 : getHarvestDate().hashCode());
        result = prime * result + ((getPlantingMethod() == null) ? 0 : getPlantingMethod().hashCode());
        result = prime * result + ((getFertilizerUsage() == null) ? 0 : getFertilizerUsage().hashCode());
        result = prime * result + ((getPesticideUsage() == null) ? 0 : getPesticideUsage().hashCode());
        result = prime * result + ((getNotes() == null) ? 0 : getNotes().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", planId=").append(planId);
        sb.append(", farmId=").append(farmId);
        sb.append(", year=").append(year);
        sb.append(", season=").append(season);
        sb.append(", landId=").append(landId);
        sb.append(", cropType=").append(cropType);
        sb.append(", plantingArea=").append(plantingArea);
        sb.append(", expectedYield=").append(expectedYield);
        sb.append(", plantingDate=").append(plantingDate);
        sb.append(", harvestDate=").append(harvestDate);
        sb.append(", plantingMethod=").append(plantingMethod);
        sb.append(", fertilizerUsage=").append(fertilizerUsage);
        sb.append(", pesticideUsage=").append(pesticideUsage);
        sb.append(", notes=").append(notes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}