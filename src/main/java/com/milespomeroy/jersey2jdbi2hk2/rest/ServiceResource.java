package com.milespomeroy.jersey2jdbi2hk2.rest;

import com.milespomeroy.jersey2jdbi2hk2.service.MagicService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/service")
public class ServiceResource
{
	@Inject
	private MagicService magicService;

	@GET
	@Produces("text/plain")
	public String getMagicNumber() {
		return "The magic number is " + this.magicService.getMagicNumber();
	}
}
