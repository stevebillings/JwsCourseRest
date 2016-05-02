package com.uciext.ws.hw2.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.uciext.ws.hw2.client.model.order.Order;
import com.uciext.ws.hw2.client.model.order.ProductOrder;

public class OrderingClient {
	private static int orderNumber = 0;

	public static void main(String[] argv) {
		if (argv.length < 1) {
			System.out.println("ERROR: Missing argument");
			printCommandUsage();
			System.exit(1);
		}

		try {
			if ("Hello".equalsIgnoreCase(argv[0])) {
				Client client = ClientBuilder.newClient();
				WebTarget myResource = client.target("http://127.0.0.1:8080/inventory/rest/catalog/hello");
				Invocation.Builder builder = myResource.request(MediaType.TEXT_PLAIN);
				String response = builder.get(String.class);
				System.out.println("Hello: response=" + response);
			} else if ("Get_Catalog".equalsIgnoreCase(argv[0])) {
				String response = getCatalog();
				System.out.println("Get_Catalog: response=" + response);
			} else if ("Submit_Order".equalsIgnoreCase(argv[0])) {
				List<ProductOrder> productOrders = new ArrayList<>(1);
				productOrders.add(createProductOrder("Kindle Fire", "111003392854", 2.0));
				String response = submitOrder("myVendorCode", "My Vendor", productOrders);
				System.out.println("Submit_Order: response=" + response);
			} else if ("Run_Sequence".equalsIgnoreCase(argv[0])) {
				String response = getCatalog();
				System.out.println("Get_Catalog: response=" + response);

				List<ProductOrder> productOrders = new ArrayList<>(2);
				productOrders.add(createProductOrder("Kindle Fire", "111003392854", 5.0));
				productOrders.add(createProductOrder("Kindle Paperwhite", "111003392994", 4.0));
				response = submitOrder("myVendorCode", "My Vendor", productOrders);
				System.out.println("Submit_Order: response=" + response);

				productOrders = new ArrayList<>(2);
				productOrders.add(createProductOrder("Kindle Fire", "111003392854", 5.0));
				productOrders.add(createProductOrder("Kindle Paperwhite", "111003392994", 7.0));
				response = submitOrder("myVendorCode", "My Vendor", productOrders);
				System.out.println("Submit_Order: response=" + response);

				productOrders = new ArrayList<>(2);
				productOrders.add(createProductOrder("Kindle Fire", "111003392854", 5.0));
				productOrders.add(createProductOrder("Kindle Paperwhite", "111003392994", 4.0));
				response = submitOrder("myVendorCode", "My Vendor", productOrders);
				System.out.println("Submit_Order: response=" + response);

				productOrders = new ArrayList<>(2);
				productOrders.add(createProductOrder("Kindle Fire", "111003392854", 5.0));
				productOrders.add(createProductOrder("Kindle Paperwhite", "111003392994", 4.0));
				response = submitOrder("myVendorCode", "My Vendor", productOrders);
				System.out.println("Submit_Order: response=" + response);

				response = getCatalog();
				System.out.println("Get_Catalog: response=" + response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static ProductOrder createProductOrder(String productName, String productSku, double quantity) {
		ProductOrder productOrder = new ProductOrder();
		productOrder.setProductName(productName);
		productOrder.setProductSku(productSku);
		productOrder.setOrderQuantity(quantity);
		return productOrder;
	}

	private static String submitOrder(String vendorCode, String vendorName, List<ProductOrder> productOrders) {
		Order order = new Order();
		order.setOrderNumber(String.valueOf(orderNumber++));
		order.setVendorCode(vendorCode);
		order.setVendorName(vendorName);

		for (ProductOrder productOrder : productOrders) {
			order.getProductOrder().add(productOrder);
		}

		Client client = ClientBuilder.newClient();
		WebTarget myResource = client.target("http://127.0.0.1:8080/inventory/rest/catalog/orders");
		Invocation.Builder builder = myResource.request(MediaType.APPLICATION_XML);
		String response = builder.post(Entity.xml(order), String.class);
		return response;
	}

	private static String getCatalog() {
		Client client = ClientBuilder.newClient();
		WebTarget myResource = client.target("http://127.0.0.1:8080/inventory/rest/catalog");
		Invocation.Builder builder = myResource.request(MediaType.APPLICATION_XML);
		String response = builder.get(String.class);
		return response;
	}

	private static void printCommandUsage() {
		System.err.println("Usage for Hello: java CatalogClient Hello");
		System.err.println("Usage for Get Catalog: java CatalogClient Get_Catalog");
		System.err.println("Usage for Submit Order: java CatalogClient Submit_Order");
		System.err.println("Usage for Run Sequence: java CatalogClient Run_Sequence");
	}
}
