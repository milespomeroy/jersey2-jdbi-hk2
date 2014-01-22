package com.milespomeroy.jersey2jdbi2hk2;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
public class App extends ResourceConfig {
    public App() {
		packages("com.milespomeroy.jersey2jdbi2hk2.rest");
        registerClasses(JerseyEventListener.class);
		registerInstances(new MyBinder());
	}
}
