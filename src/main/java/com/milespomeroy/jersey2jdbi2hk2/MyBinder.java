package com.milespomeroy.jersey2jdbi2hk2;

import com.google.inject.Injector;
import com.milespomeroy.jersey2jdbi2hk2.ondemand.OnDemand;
import com.milespomeroy.jersey2jdbi2hk2.ondemand.OnDemandFactoryProvider;
import org.glassfish.hk2.api.Context;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.spi.internal.ValueFactoryProvider;
import org.jvnet.hk2.guice.bridge.api.GuiceScope;
import org.jvnet.hk2.guice.bridge.internal.GuiceScopeContext;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletContext;

public class MyBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(new IamSingle()).to(IamSingle.class);
        bind(OnDemandFactoryProvider.class).to(ValueFactoryProvider.class).in(Singleton.class);
        bind(OnDemandFactoryProvider.InjectionResolver.class).to(
                new TypeLiteral<InjectionResolver<OnDemand>>() {
                }).in(Singleton.class);

        // Guice HK2 Bridge
        bind(NullableGuiceScopeContext.class).to(NullableGuiceScopeContext.class)
                .to(GuiceScopeContext.class)
                .to(new TypeLiteral<Context<GuiceScope>>() {
                })
                .in(Singleton.class);
        bindFactory(GuiceProvider.class).to(Injector.class).in(Singleton.class);
    }

    @Singleton
    private static class NullableGuiceScopeContext extends GuiceScopeContext {
        @Override
        public boolean supportsNullCreation() {
            return true;
        }
    }

    private static class GuiceProvider implements Factory<Injector> {
        ServletContext servletContext;

        @Inject
        public void setServletContext(ServletContext servletContext) {
            this.servletContext = servletContext;
        }

        @Override
        public Injector provide() {
            return (Injector) servletContext.getAttribute(Injector.class.getName());
        }

        @Override
        public void dispose(Injector instance) {

        }
    }

}
