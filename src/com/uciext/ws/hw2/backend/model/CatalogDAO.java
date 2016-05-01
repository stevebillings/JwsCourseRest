package com.uciext.ws.hw2.backend.model;

import java.util.Date;
import java.util.List;

public class CatalogDAO {

    private Date lastModifiedDate;
    private String version;
    private String description;
    private List<ProductDAO> productList;
    
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(Date value) {
        this.lastModifiedDate = value;
    }

    public String getVersion() {
        return version;
    }
    public void setVersion(String value) {
        this.version = value;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String value) {
        this.description = value;
    }

    public List<ProductDAO> getProductList() {
        return productList;
    }
    public void setProductList(List<ProductDAO> value) {
        this.productList = value;
    }

		public String toString() {
			StringBuilder buff = new StringBuilder("[CatalogDAO: ")
			.append("lastModifiedDate=").append(lastModifiedDate)
			.append(", version=").append(version)
			.append(", description=").append(description)
			.append(",productList=[")
			;
			for (ProductDAO product : productList) {
				buff.append(product.toString()).append(", ");
			}
			buff.append("]");
			buff.append("]");
			return buff.toString();
		}

}
