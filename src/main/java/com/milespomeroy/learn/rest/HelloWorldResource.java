package com.milespomeroy.learn.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.milespomeroy.learn.IamSingle;

@Path("helloworld")
public class HelloWorldResource {
	
	private int beenCalled;
	private IamSingle iamSingle;
	
	@Inject
	public HelloWorldResource(IamSingle iamSingle) {
		this.iamSingle = iamSingle;
	}
	
	@GET
	@Produces("text/plain")
	public String getHello() {
		beenCalled++;
		iamSingle.touch();
		return "Hello World! You are the bomb! I've been called " + beenCalled + " times.";
	}
}
