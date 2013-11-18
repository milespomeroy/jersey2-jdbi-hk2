package com.milespomeroy.learn;

import org.glassfish.jersey.server.ResourceConfig;

public class App extends ResourceConfig {
	public App() {
		packages("com.milespomeroy.learn.rest");
		registerInstances(new MyBinder());
	}
}
