package com.uciext.ws.hw2.backend.model;

public class ProductDAO {

    private Long productId;
    private String sku;
    private String productName;
    private String category;
    private Double quantity;
    private Double price;

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long value) {
        this.productId = value;
    }

    public String getSku() {
        return sku;
    }
    public void setSku(String value) {
        this.sku = value;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String value) {
        this.productName = value;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String value) {
        this.category = value;
    }

    public Double getQuantity() {
        return quantity;
    }
    public void setQuantity(Double value) {
        this.quantity = value;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double value) {
        this.price = value;
    }

		public String toString() {
			StringBuilder buff = new StringBuilder("[ProductDAO: ")
			.append("productId=").append(productId)
			.append(", sku=").append(sku)
			.append(", productName=").append(productName)
			.append(", category=").append(category)
			.append(", quantity=").append(quantity)
			.append(", price=").append(price)
			.append("]");
			return buff.toString();
		}
}
