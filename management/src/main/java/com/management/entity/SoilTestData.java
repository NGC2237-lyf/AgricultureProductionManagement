package com.management.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @TableName soil_test_data
 */
@Data
@TableName("soil_test_data")
public class SoilTestData implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer testId;

    private Integer location;

    private Date testDate;

    private BigDecimal phLevel;

    private BigDecimal nitrogen;

    private BigDecimal phosphorus;

    private BigDecimal potassium;

    private BigDecimal organicMatter;

    private String texture;

    private BigDecimal salinity;

    private BigDecimal soilMoisture;

    private String soilType;

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
        SoilTestData other = (SoilTestData) that;
        return (this.getTestId() == null ? other.getTestId() == null : this.getTestId().equals(other.getTestId()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getTestDate() == null ? other.getTestDate() == null : this.getTestDate().equals(other.getTestDate()))
            && (this.getPhLevel() == null ? other.getPhLevel() == null : this.getPhLevel().equals(other.getPhLevel()))
            && (this.getNitrogen() == null ? other.getNitrogen() == null : this.getNitrogen().equals(other.getNitrogen()))
            && (this.getPhosphorus() == null ? other.getPhosphorus() == null : this.getPhosphorus().equals(other.getPhosphorus()))
            && (this.getPotassium() == null ? other.getPotassium() == null : this.getPotassium().equals(other.getPotassium()))
            && (this.getOrganicMatter() == null ? other.getOrganicMatter() == null : this.getOrganicMatter().equals(other.getOrganicMatter()))
            && (this.getTexture() == null ? other.getTexture() == null : this.getTexture().equals(other.getTexture()))
            && (this.getSalinity() == null ? other.getSalinity() == null : this.getSalinity().equals(other.getSalinity()))
            && (this.getSoilMoisture() == null ? other.getSoilMoisture() == null : this.getSoilMoisture().equals(other.getSoilMoisture()))
            && (this.getSoilType() == null ? other.getSoilType() == null : this.getSoilType().equals(other.getSoilType()))
            && (this.getNotes() == null ? other.getNotes() == null : this.getNotes().equals(other.getNotes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTestId() == null) ? 0 : getTestId().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getTestDate() == null) ? 0 : getTestDate().hashCode());
        result = prime * result + ((getPhLevel() == null) ? 0 : getPhLevel().hashCode());
        result = prime * result + ((getNitrogen() == null) ? 0 : getNitrogen().hashCode());
        result = prime * result + ((getPhosphorus() == null) ? 0 : getPhosphorus().hashCode());
        result = prime * result + ((getPotassium() == null) ? 0 : getPotassium().hashCode());
        result = prime * result + ((getOrganicMatter() == null) ? 0 : getOrganicMatter().hashCode());
        result = prime * result + ((getTexture() == null) ? 0 : getTexture().hashCode());
        result = prime * result + ((getSalinity() == null) ? 0 : getSalinity().hashCode());
        result = prime * result + ((getSoilMoisture() == null) ? 0 : getSoilMoisture().hashCode());
        result = prime * result + ((getSoilType() == null) ? 0 : getSoilType().hashCode());
        result = prime * result + ((getNotes() == null) ? 0 : getNotes().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", testId=").append(testId);
        sb.append(", location=").append(location);
        sb.append(", testDate=").append(testDate);
        sb.append(", phLevel=").append(phLevel);
        sb.append(", nitrogen=").append(nitrogen);
        sb.append(", phosphorus=").append(phosphorus);
        sb.append(", potassium=").append(potassium);
        sb.append(", organicMatter=").append(organicMatter);
        sb.append(", texture=").append(texture);
        sb.append(", salinity=").append(salinity);
        sb.append(", soilMoisture=").append(soilMoisture);
        sb.append(", soilType=").append(soilType);
        sb.append(", notes=").append(notes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}