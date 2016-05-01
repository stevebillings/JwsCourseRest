package com.uciext.ws.hw2.backend.model;

import java.util.List;

public class OrderDAO {

    private Long orderId;
    private String vendorName;
    private String vendorCode;
    private String orderNumber;
    private List<ProductOrderDAO> productOrderList;

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long value) {
        this.orderId = value;
    }

    public String getVendorName() {
        return vendorName;
    }
    public void setVendorName(String value) {
        this.vendorName = value;
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

		public String toString() {
			StringBuilder buff = new StringBuilder("[OrderDAO: ")
			.append("orderId=").append(orderId)
			.append(", vendorCode=").append(vendorCode)
			.append(", vendorName=").append(vendorName)
			.append(", orderNumber=").append(orderNumber)
			.append(",productOrderList=[")
			;
			for (ProductOrderDAO productOrder : productOrderList) {
				buff.append(productOrder.toString()).append(", ");
			}
			buff.append("]");
			buff.append("]");
			return buff.toString();
		}
}
