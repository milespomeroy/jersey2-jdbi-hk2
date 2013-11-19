package com.milespomeroy.jersey2jdbi2hk2.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.milespomeroy.jersey2jdbi2hk2.dao.LearnDao;
import com.milespomeroy.jersey2jdbi2hk2.ondemand.OnDemand;

@Path("dao")
public class DaoResource {

	@GET
	@Produces("text/plain")
	public String getMagicNumber(@OnDemand LearnDao learnDao) {
		int magicNumber = 0;
		
		magicNumber = learnDao.getMagicNumber();
		
		return "The magic number is " + magicNumber;
	}
}
