package com.milespomeroy.jersey2jdbi2hk2.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("helloworld")
public class HelloWorldResource {
	
	private int beenCalled;
	
	@GET
	@Produces("text/plain")
	public String getHello() {
		beenCalled++;
		return "Hello World! You are the bomb! I've been called " + beenCalled + " times.";
	}
}
