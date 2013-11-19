package com.milespomeroy.jersey2jdbi2hk2.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.util.IntegerMapper;

import com.milespomeroy.jersey2jdbi2hk2.db.DatabaseUtil;

@Path("db")
public class DbResource {

	@GET
	@Produces("text/plain")
	public String getMagicNumber() {
		int magicNumber = 0;
		
		try(Handle handle = DatabaseUtil.getDbi().open())
		{
			magicNumber = handle.createQuery("SELECT magic FROM learn").map(IntegerMapper.FIRST).first();
		}
		
		return "The magic number is " + magicNumber;
	}
}
