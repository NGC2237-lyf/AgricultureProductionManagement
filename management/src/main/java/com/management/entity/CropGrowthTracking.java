package com.management.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @TableName crop_growth_tracking
 */
@Data
public class CropGrowthTracking implements Serializable {
    private Integer trackingId;

    private Integer farmId;

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
        CropGrowthTracking other = (CropGrowthTracking) that;
        return (this.getTrackingId() == null ? other.getTrackingId() == null : this.getTrackingId().equals(other.getTrackingId()))
            && (this.getFarmId() == null ? other.getFarmId() == null : this.getFarmId().equals(other.getFarmId()))
            && (this.getLandId() == null ? other.getLandId() == null : this.getLandId().equals(other.getLandId()))
            && (this.getCropType() == null ? other.getCropType() == null : this.getCropType().equals(other.getCropType()))
            && (this.getGrowthStage() == null ? other.getGrowthStage() == null : this.getGrowthStage().equals(other.getGrowthStage()))
            && (this.getObservationDate() == null ? other.getObservationDate() == null : this.getObservationDate().equals(other.getObservationDate()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getCanopyWidth() == null ? other.getCanopyWidth() == null : this.getCanopyWidth().equals(other.getCanopyWidth()))
            && (this.getLeafColor() == null ? other.getLeafColor() == null : this.getLeafColor().equals(other.getLeafColor()))
            && (this.getPestPresence() == null ? other.getPestPresence() == null : this.getPestPresence().equals(other.getPestPresence()))
            && (this.getDiseasePresence() == null ? other.getDiseasePresence() == null : this.getDiseasePresence().equals(other.getDiseasePresence()))
            && (this.getNutrientDeficiency() == null ? other.getNutrientDeficiency() == null : this.getNutrientDeficiency().equals(other.getNutrientDeficiency()))
            && (this.getNotes() == null ? other.getNotes() == null : this.getNotes().equals(other.getNotes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTrackingId() == null) ? 0 : getTrackingId().hashCode());
        result = prime * result + ((getFarmId() == null) ? 0 : getFarmId().hashCode());
        result = prime * result + ((getLandId() == null) ? 0 : getLandId().hashCode());
        result = prime * result + ((getCropType() == null) ? 0 : getCropType().hashCode());
        result = prime * result + ((getGrowthStage() == null) ? 0 : getGrowthStage().hashCode());
        result = prime * result + ((getObservationDate() == null) ? 0 : getObservationDate().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getCanopyWidth() == null) ? 0 : getCanopyWidth().hashCode());
        result = prime * result + ((getLeafColor() == null) ? 0 : getLeafColor().hashCode());
        result = prime * result + ((getPestPresence() == null) ? 0 : getPestPresence().hashCode());
        result = prime * result + ((getDiseasePresence() == null) ? 0 : getDiseasePresence().hashCode());
        result = prime * result + ((getNutrientDeficiency() == null) ? 0 : getNutrientDeficiency().hashCode());
        result = prime * result + ((getNotes() == null) ? 0 : getNotes().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", trackingId=").append(trackingId);
        sb.append(", farmId=").append(farmId);
        sb.append(", landId=").append(landId);
        sb.append(", cropType=").append(cropType);
        sb.append(", growthStage=").append(growthStage);
        sb.append(", observationDate=").append(observationDate);
        sb.append(", height=").append(height);
        sb.append(", canopyWidth=").append(canopyWidth);
        sb.append(", leafColor=").append(leafColor);
        sb.append(", pestPresence=").append(pestPresence);
        sb.append(", diseasePresence=").append(diseasePresence);
        sb.append(", nutrientDeficiency=").append(nutrientDeficiency);
        sb.append(", notes=").append(notes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}