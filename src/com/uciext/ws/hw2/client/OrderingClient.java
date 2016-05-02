package com.uciext.ws.hw2.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printCommandUsage() {
		System.err.println("Usage for Hello: java CatalogClient Hello");
		System.err.println("Usage for Get Catalog: java CatalogClient Get_Catalog");
		System.err.println("Usage for Create Order: java CatalogClient Create_Order");
	}
}
