package com.milespomeroy.jersey2jdbi2hk2;

import org.glassfish.hk2.api.DynamicConfigurationService;
import org.glassfish.hk2.api.MultiException;
import org.glassfish.hk2.api.Populator;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Inject;
import java.io.IOException;

public class App extends ResourceConfig {

	@Inject
	public App(ServiceLocator serviceLocator) {
		System.out.println(serviceLocator);

		DynamicConfigurationService dcs = serviceLocator.getService(DynamicConfigurationService.class);
		Populator populator = dcs.getPopulator();

		try {
			populator.populate(new Finder());
		}
		catch (IOException e) {
			throw new MultiException(e);
		}

		packages("com.milespomeroy.jersey2jdbi2hk2.rest");
		registerInstances(new MyBinder());
	}
}
