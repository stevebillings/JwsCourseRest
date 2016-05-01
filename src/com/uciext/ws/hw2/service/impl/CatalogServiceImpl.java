package com.uciext.ws.hw2.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.uciext.ws.hw2.util.Util;

import com.uciext.ws.hw2.service.CatalogService;

@Path("/catalog")
public class CatalogServiceImpl implements CatalogService {

	@Override
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {

		Util.log("entered catalog/hello");
		  
		return "Hello " + (new java.util.Date());
	}

}
