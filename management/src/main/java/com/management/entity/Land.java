package com.management.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * @TableName land
 */
@Data
public class Land implements Serializable {
    private Integer landId;

    private String location;

    private BigDecimal area;

    private String topography;

    private String soilType;

    private Long ownership;

    private String landUse;

    private String ecologicalEnvironment;

    private BigDecimal marketValue;

    private String planningUse;

    private String ownerIntent;

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
        Land other = (Land) that;
        return (this.getLandId() == null ? other.getLandId() == null : this.getLandId().equals(other.getLandId()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getTopography() == null ? other.getTopography() == null : this.getTopography().equals(other.getTopography()))
            && (this.getSoilType() == null ? other.getSoilType() == null : this.getSoilType().equals(other.getSoilType()))
            && (this.getOwnership() == null ? other.getOwnership() == null : this.getOwnership().equals(other.getOwnership()))
            && (this.getLandUse() == null ? other.getLandUse() == null : this.getLandUse().equals(other.getLandUse()))
            && (this.getEcologicalEnvironment() == null ? other.getEcologicalEnvironment() == null : this.getEcologicalEnvironment().equals(other.getEcologicalEnvironment()))
            && (this.getMarketValue() == null ? other.getMarketValue() == null : this.getMarketValue().equals(other.getMarketValue()))
            && (this.getPlanningUse() == null ? other.getPlanningUse() == null : this.getPlanningUse().equals(other.getPlanningUse()))
            && (this.getOwnerIntent() == null ? other.getOwnerIntent() == null : this.getOwnerIntent().equals(other.getOwnerIntent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLandId() == null) ? 0 : getLandId().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getTopography() == null) ? 0 : getTopography().hashCode());
        result = prime * result + ((getSoilType() == null) ? 0 : getSoilType().hashCode());
        result = prime * result + ((getOwnership() == null) ? 0 : getOwnership().hashCode());
        result = prime * result + ((getLandUse() == null) ? 0 : getLandUse().hashCode());
        result = prime * result + ((getEcologicalEnvironment() == null) ? 0 : getEcologicalEnvironment().hashCode());
        result = prime * result + ((getMarketValue() == null) ? 0 : getMarketValue().hashCode());
        result = prime * result + ((getPlanningUse() == null) ? 0 : getPlanningUse().hashCode());
        result = prime * result + ((getOwnerIntent() == null) ? 0 : getOwnerIntent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", landId=").append(landId);
        sb.append(", location=").append(location);
        sb.append(", area=").append(area);
        sb.append(", topography=").append(topography);
        sb.append(", soilType=").append(soilType);
        sb.append(", ownership=").append(ownership);
        sb.append(", landUse=").append(landUse);
        sb.append(", ecologicalEnvironment=").append(ecologicalEnvironment);
        sb.append(", marketValue=").append(marketValue);
        sb.append(", planningUse=").append(planningUse);
        sb.append(", ownerIntent=").append(ownerIntent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}