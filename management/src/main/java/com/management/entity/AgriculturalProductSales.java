package com.management.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @TableName agricultural_product_sales
 */
@Data
public class AgriculturalProductSales implements Serializable {
    private Integer saleId;

    private Integer productId;

    private Date saleDate;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;

    private String customerName;

    private String customerContact;

    private String paymentMethod;

    private String deliveryAddress;

    private String customerFeedback;

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
        AgriculturalProductSales other = (AgriculturalProductSales) that;
        return (this.getSaleId() == null ? other.getSaleId() == null : this.getSaleId().equals(other.getSaleId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getSaleDate() == null ? other.getSaleDate() == null : this.getSaleDate().equals(other.getSaleDate()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getUnitPrice() == null ? other.getUnitPrice() == null : this.getUnitPrice().equals(other.getUnitPrice()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
            && (this.getCustomerName() == null ? other.getCustomerName() == null : this.getCustomerName().equals(other.getCustomerName()))
            && (this.getCustomerContact() == null ? other.getCustomerContact() == null : this.getCustomerContact().equals(other.getCustomerContact()))
            && (this.getPaymentMethod() == null ? other.getPaymentMethod() == null : this.getPaymentMethod().equals(other.getPaymentMethod()))
            && (this.getDeliveryAddress() == null ? other.getDeliveryAddress() == null : this.getDeliveryAddress().equals(other.getDeliveryAddress()))
            && (this.getCustomerFeedback() == null ? other.getCustomerFeedback() == null : this.getCustomerFeedback().equals(other.getCustomerFeedback()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSaleId() == null) ? 0 : getSaleId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getSaleDate() == null) ? 0 : getSaleDate().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getUnitPrice() == null) ? 0 : getUnitPrice().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getCustomerName() == null) ? 0 : getCustomerName().hashCode());
        result = prime * result + ((getCustomerContact() == null) ? 0 : getCustomerContact().hashCode());
        result = prime * result + ((getPaymentMethod() == null) ? 0 : getPaymentMethod().hashCode());
        result = prime * result + ((getDeliveryAddress() == null) ? 0 : getDeliveryAddress().hashCode());
        result = prime * result + ((getCustomerFeedback() == null) ? 0 : getCustomerFeedback().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", saleId=").append(saleId);
        sb.append(", productId=").append(productId);
        sb.append(", saleDate=").append(saleDate);
        sb.append(", quantity=").append(quantity);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", customerName=").append(customerName);
        sb.append(", customerContact=").append(customerContact);
        sb.append(", paymentMethod=").append(paymentMethod);
        sb.append(", deliveryAddress=").append(deliveryAddress);
        sb.append(", customerFeedback=").append(customerFeedback);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}