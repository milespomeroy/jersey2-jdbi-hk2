package com.milespomeroy.jersey2jdbi2hk2;

import org.glassfish.jersey.server.ResourceConfig;

public class App extends ResourceConfig {
	public App() {
		packages("com.milespomeroy.jersey2jdbi2hk2.rest");
		registerInstances(new MyBinder());
	}
}
