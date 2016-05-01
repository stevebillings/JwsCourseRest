package com.uciext.ws.hw2.service.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.uciext.ws.hw2.backend.InventoryManager;
import com.uciext.ws.hw2.backend.impl.InventoryManagerImpl;
import com.uciext.ws.hw2.backend.model.CatalogDAO;
import com.uciext.ws.hw2.backend.model.ProductDAO;
import com.uciext.ws.hw2.service.CatalogService;
import com.uciext.ws.hw2.service.model.catalog.Catalog;
import com.uciext.ws.hw2.service.model.catalog.Product;
import com.uciext.ws.hw2.util.Util;

/*
 * Get a "hello" message.
 * Test curl command:
 * curl -X GET "http://localhost:8080/inventory/rest/catalog/hello"
 */
@Path("/catalog")
public class CatalogServiceImpl implements CatalogService {

	private InventoryManager manager = new InventoryManagerImpl();

	@Override
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {

		Util.log("entered catalog/hello");

		return "Hello " + (new java.util.Date());
	}

	/*
	 * Get the catalog (including all products) - Test curl command: curl -X GET
	 * "http://localhost:8080/inventory/rest/catalog"
	 */
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/")
	public Catalog getCatalog() {
		Util.log("/catalog request");

		// Get data
		CatalogDAO catalogDao = manager.getCatalog();

		// Create a response
		Catalog catalog = new Catalog();
		catalog.setDescription(catalogDao.getDescription());
		catalog.setLastModifiedDate(catalogDao.getLastModifiedDate().toString());

		List<ProductDAO> productDaoList = catalogDao.getProductList();
		for (ProductDAO productDao : productDaoList) {
			Product product = new Product();
			product.setName(productDao.getProductName());
			product.setPrice(productDao.getPrice());
			product.setQuantity(productDao.getQuantity());
			product.setSku(productDao.getSku());
			catalog.getProduct().add(product);
		}

		Util.log("/catalog response");
		return catalog;
	}
}
