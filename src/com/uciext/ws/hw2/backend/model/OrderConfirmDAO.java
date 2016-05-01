package com.uciext.ws.hw2.backend.model;

import java.util.List;

public class OrderConfirmDAO {

    private Long orderConfirmId;
    private String vendorCode;
    private String orderNumber;
    private List<ProductOrderDAO> productOrderList;
    private Double totalOrderPrice;

    public Long getOrderConfirmId() {
        return orderConfirmId;
    }
    public void setOrderConfirmId(Long value) {
        this.orderConfirmId = value;
    }

    public String getVendorCode() {
        return vendorCode;
    }
    public void setVendorCode(String value) {
        this.vendorCode = value;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String value) {
        this.orderNumber = value;
    }

    public List<ProductOrderDAO> getProductOrderList() {
        return productOrderList;
    }
    public void setProductOrderList(List<ProductOrderDAO> value) {
        this.productOrderList = value;
    }

    public Double getTotalOrderPrice() {
        return totalOrderPrice;
    }
    public void setTotalOrderPrice(Double value) {
        this.totalOrderPrice = value;
    }

		public String toString() {
			StringBuilder buff = new StringBuilder("[OrderConfirmDAO: ")
			.append("orderConfirmId=").append(orderConfirmId)
			.append(", vendorCode=").append(vendorCode)
			.append(", orderNumber=").append(orderNumber)
			.append(", totalOrderPrice=").append(totalOrderPrice)
			.append(",productConfirmList=[")
			;
			for (ProductOrderDAO productOrder : productOrderList) {
				buff.append(productOrder.toString()).append(", ");
			}
			buff.append("]");
			buff.append("]");
			return buff.toString();
		}
}
