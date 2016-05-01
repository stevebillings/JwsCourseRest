package com.uciext.ws.hw2.backend.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.uciext.ws.hw2.backend.InventoryManager;
import com.uciext.ws.hw2.backend.model.CatalogDAO;
import com.uciext.ws.hw2.backend.model.ProductDAO;
import com.uciext.ws.hw2.backend.model.ProductOrderDAO;
import com.uciext.ws.hw2.backend.model.OrderConfirmDAO;
import com.uciext.ws.hw2.backend.model.OrderDAO;

import com.uciext.ws.hw2.util.Util;

public class InventoryManagerImpl implements InventoryManager {

  private static Hashtable<String, ProductDAO> productMap = new Hashtable<String, ProductDAO>();
  
  public static Long orderId = 1000L;
  public static Long orderConfirmId = 2000L;
  
  static {
		// Create a Product Inventory repository for backend
		createProductInventory();
  }

	// Get Catalog
	public CatalogDAO getCatalog() {
		Util.log("---- InventoryManager: getCatalog");
		CatalogDAO catalog = new CatalogDAO();
		catalog.setLastModifiedDate(new Date());
    catalog.setDescription("Kindle");
		catalog.setProductList(new ArrayList<ProductDAO>(productMap.values()));

		Util.log(catalog.toString());
		return catalog;
	}
	
	// Process Order
	public OrderConfirmDAO processOrder(OrderDAO order) throws Exception {
		Util.log("---- InventoryManager: processOrder");
		Util.log(order.toString());
				
		order.setOrderId(orderId++);
		
		OrderConfirmDAO orderConfirm = new OrderConfirmDAO();
		orderConfirm.setOrderConfirmId(orderConfirmId++);
		orderConfirm.setVendorCode(order.getVendorCode());
		orderConfirm.setOrderNumber(order.getOrderNumber());
		List<ProductOrderDAO> confirmProductOrderList = new ArrayList<ProductOrderDAO>();
		
		Double totalPrice = 0.0;
		for (ProductOrderDAO productOrder : order.getProductOrderList()) {
			// Validate product
			if (!productMap.containsKey(productOrder.getProduct().getSku())) {
				throw new Exception ("Invalid Product Sku");
			}
			
			// Calculate confirmed quantity
			Double confirmQuantity = 0.0;
			ProductDAO product = productMap.get(productOrder.getProduct().getSku());
			if (product.getQuantity() >= productOrder.getOrderQuantity()) {
				confirmQuantity = productOrder.getOrderQuantity();
			}
			else {
				confirmQuantity = product.getQuantity();
			}
			totalPrice += confirmQuantity * product.getPrice();

			// Set new inventory quantity
			product.setQuantity(product.getQuantity() - confirmQuantity);
			productMap.put(product.getSku(), product);

			// Create Conformed PRoduct			
			ProductOrderDAO confirmProductOrder = new ProductOrderDAO();
			confirmProductOrder.setProduct(product);
			confirmProductOrder.setOrderQuantity(confirmQuantity);
			confirmProductOrderList.add(confirmProductOrder);

			Util.log("Product sku=" + product.getSku() 
				+ ", confirmedQuantity=" + confirmQuantity);
		}
		
		orderConfirm.setProductOrderList(confirmProductOrderList);
		orderConfirm.setTotalOrderPrice(totalPrice);

		Util.log("\n retuning order confirm");
		Util.log(orderConfirm.toString());				
		return orderConfirm;
	}

	// PRIVATE
	
	private static void createProductInventory() {
		
		ProductDAO product1 = new ProductDAO();
		product1.setProductId(13001001L);
		product1.setSku("111003392854");
		product1.setProductName("Kindle Fire");
		product1.setCategory("Kindle");
		product1.setQuantity(27.0);
		product1.setPrice(199.0);
		productMap.put(product1.getSku(), product1);

		ProductDAO product2 = new ProductDAO();
		product2.setProductId(13001002L);
		product2.setSku("111003392994");
		product2.setProductName("Kindle Paperwhite");
		product2.setCategory("Kindle");
		product2.setQuantity(13.0);
		product2.setPrice(119.0);
		productMap.put(product2.getSku(), product2);

		ProductDAO product3 = new ProductDAO();
		product3.setProductId(13001003L);
		product3.setSku("111003392939");
		product3.setProductName("Kindle E Ink");
		product3.setCategory("Kindle");
		product3.setQuantity(15.0);
		product3.setPrice(69.0);
		productMap.put(product3.getSku(), product3);
	}
}