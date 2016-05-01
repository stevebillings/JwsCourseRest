package com.uciext.ws.hw2.backend.model;

public class ProductOrderDAO {

    private ProductDAO product;
    private Double orderQuantity;

    public ProductDAO getProduct() {
        return product;
    }
    public void setProduct(ProductDAO value) {
        this.product = value;
    }

    public Double getOrderQuantity() {
        return orderQuantity;
    }
    public void setOrderQuantity(Double value) {
        this.orderQuantity = value;
    }

		public String toString() {
			StringBuilder buff = new StringBuilder("[ProductOrderDAO: ")
			.append("product=").append(product.toString())
			.append(", orderQuantity=").append(orderQuantity)
			.append("]");
			return buff.toString();
		}
}
