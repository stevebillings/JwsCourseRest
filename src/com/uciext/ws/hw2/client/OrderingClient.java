package com.uciext.ws.hw2.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.uciext.ws.hw2.client.model.order.Order;
import com.uciext.ws.hw2.client.model.order.ProductOrder;

public class OrderingClient {

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
				Client client = ClientBuilder.newClient();
				WebTarget myResource = client.target("http://127.0.0.1:8080/inventory/rest/catalog");
				Invocation.Builder builder = myResource.request(MediaType.APPLICATION_XML);
				String response = builder.get(String.class);
				System.out.println("Get_Catalog: response=" + response);
			} else if ("Submit_Order".equalsIgnoreCase(argv[0])) {
				Order order = new Order();
				order.setOrderNumber("1");
				order.setVendorCode("testVendorCode");
				order.setVendorName("Test Vendor Name");

				ProductOrder productOrder = new ProductOrder();
				productOrder.setProductName("Kindle Fire");
				productOrder.setProductSku("111003392854");
				productOrder.setOrderQuantity(2.0);
				order.getProductOrder().add(productOrder);

				Client client = ClientBuilder.newClient();
				WebTarget myResource = client.target("http://127.0.0.1:8080/inventory/rest/catalog/orders");
				Invocation.Builder builder = myResource.request(MediaType.APPLICATION_XML);
				String response = builder.post(Entity.xml(order), String.class);
				System.out.println("Get_Catalog: response=" + response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printCommandUsage() {
		System.err.println("Usage for Hello: java CatalogClient Hello");
		System.err.println("Usage for Get Catalog: java CatalogClient Get_Catalog");
		System.err.println("Usage for Submit Order: java CatalogClient Submit_Order");
	}
}
