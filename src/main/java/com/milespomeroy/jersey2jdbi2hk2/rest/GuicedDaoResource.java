package com.milespomeroy.jersey2jdbi2hk2.rest;

import com.milespomeroy.jersey2jdbi2hk2.service.MagicService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("guiced/dao")
public class GuicedDaoResource {
    @Inject
    private MagicService magicService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMagicNumber() {
        return "The magic number is " + this.magicService.getMagicNumberFromDao();
    }
}
