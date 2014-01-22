package com.milespomeroy.jersey2jdbi2hk2;

import javax.inject.Singleton;

import com.milespomeroy.jersey2jdbi2hk2.service.MagicService;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.spi.internal.ValueFactoryProvider;

import com.milespomeroy.jersey2jdbi2hk2.ondemand.OnDemand;
import com.milespomeroy.jersey2jdbi2hk2.ondemand.OnDemandFactoryProvider;

public class MyBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(new IamSingle()).to(IamSingle.class);
		bind(OnDemandFactoryProvider.class).to(ValueFactoryProvider.class).in(Singleton.class);
        bind(OnDemandFactoryProvider.InjectionResolver.class).to(
            new TypeLiteral<InjectionResolver<OnDemand>>() {
            }).in(Singleton.class);
//		bind(MagicService.class).to(MagicService.class);
	}

}
