package com.uciext.ws.hw2.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import com.uciext.ws.hw2.backend.InventoryManager;
import com.uciext.ws.hw2.backend.impl.InventoryManagerImpl;
import com.uciext.ws.hw2.backend.model.CatalogDAO;
import com.uciext.ws.hw2.backend.model.OrderConfirmDAO;
import com.uciext.ws.hw2.backend.model.OrderDAO;
import com.uciext.ws.hw2.backend.model.ProductDAO;
import com.uciext.ws.hw2.backend.model.ProductOrderDAO;
import com.uciext.ws.hw2.service.CatalogService;
import com.uciext.ws.hw2.service.model.catalog.Catalog;
import com.uciext.ws.hw2.service.model.catalog.Product;
import com.uciext.ws.hw2.service.model.order.Order;
import com.uciext.ws.hw2.service.model.order.ProductOrder;
import com.uciext.ws.hw2.service.model.orderConfirm.OrderConfirm;
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

	/*
	 * Create an order using POST
	 * 
	 * - The HTTP body is the XML with the order. - Test curl command: curl -X
	 * POST -H "Content-Type: application/xml" -d "<order xml>"
	 * "http://localhost:8080/inventory/rest/catalog/orders", or (with xml
	 * data): curl -X POST -H "Content-Type: application/xml" -d
	 * "<order><vendorCode>330029</vendorCode><vendorName>My Shop</vendorName><orderNumber>1000339</orderNumber><productOrder><productSku>111003392939</productSku><productName>Kindle E Ink</productName><orderQuantity>5</orderQuantity></productOrder><productOrder><productSku>111003392854</productSku><productName>Kindle Fire</productName><orderQuantity>3</orderQuantity></productOrder></order>"
	 * http://localhost:8080/inventory/rest/catalog/orders
	 */
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/orders")
	public OrderConfirm createOrder(JAXBElement<Order> jaxbOrder) throws Exception {

		Util.log("POST /orders request");
		Order order = jaxbOrder.getValue();

		OrderDAO orderDao = new OrderDAO();
		Long orderId = (new Date()).getTime();
		orderDao.setOrderId(orderId);
		orderDao.setOrderNumber(order.getOrderNumber());
		orderDao.setVendorCode(order.getVendorCode());
		orderDao.setVendorName(order.getVendorName());
		List<ProductOrderDAO> productOrderDaoList = new ArrayList<>(order.getProductOrder().size());
		orderDao.setProductOrderList(productOrderDaoList);
		for (ProductOrder productOrder : order.getProductOrder()) {
			ProductOrderDAO productOrderDao = new ProductOrderDAO();
			productOrderDao.setOrderQuantity(productOrder.getOrderQuantity());
			ProductDAO productDao = new ProductDAO();
			productDao.setProductName(productOrder.getProductName());
			productDao.setSku(productOrder.getProductSku());
			productOrderDao.setProduct(productDao);
			orderDao.getProductOrderList().add(productOrderDao);
		}

		OrderConfirmDAO orderConfirmDao = manager.processOrder(orderDao);

		OrderConfirm orderConfirm = new OrderConfirm();
		orderConfirm.setConfirmNumber(orderConfirmDao.getOrderNumber());
		orderConfirm.setOrderNumber(orderConfirmDao.getOrderNumber());
		orderConfirm.setTotalOrderPrice(orderConfirmDao.getTotalOrderPrice());
		orderConfirm.setVendorCode(orderConfirmDao.getVendorCode());

		Util.log("POST /orders response");
		return orderConfirm;
	}
}
