package com.milespomeroy.jersey2jdbi2hk2.ondemand;

import com.milespomeroy.jersey2jdbi2hk2.db.DatabaseUtil;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;
import org.glassfish.jersey.server.internal.inject.AbstractValueFactoryProvider;
import org.glassfish.jersey.server.internal.inject.MultivaluedParameterExtractorProvider;
import org.glassfish.jersey.server.internal.inject.ParamInjectionResolver;
import org.glassfish.jersey.server.model.Parameter;
import org.skife.jdbi.v2.DBI;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Modifier;

@Singleton
public final class OnDemandFactoryProvider extends AbstractValueFactoryProvider {

	/**
     * Injection resolver for {@link OnDemand} annotation. Will create a Factory Provider for
     * the actual resolving of the DAO object.
     */
    @Singleton
    public static final class InjectionResolver extends ParamInjectionResolver<OnDemand> {
 
        /**
         * Create new {@link IdentityParam} annotation injection resolver.
         */
        public InjectionResolver() {
            super(OnDemandFactoryProvider.class);
        }
    }
 
    /**
     * Factory implementation for resolving request-based attributes and other information.
     */
    private static final class OnDemandFactory extends AbstractContainerRequestValueFactory<Object> {
        private DBI dbi;
        private Class<?> daoClass;
        
        public OnDemandFactory(Class<?> daoClass) {
			this.daoClass = daoClass;
			
			// TODO fix this, inject?
			this.dbi = DatabaseUtil.getDbi();
		}
 
        public Object provide() {
            return this.dbi.onDemand(this.daoClass);
        }
    }
 
    /**
     * {@link IdentityParam} annotation value factory provider injection constructor.
     * 
     * @param mpep
     *            multivalued parameter extractor provider.
     * @param injector
     *            injector instance.
     */
    @Inject
    public OnDemandFactoryProvider(MultivaluedParameterExtractorProvider mpep, ServiceLocator injector) {
        super(mpep, injector, Parameter.Source.UNKNOWN);
    }
 
    /**
     * Return a factory for the provided parameter. We only expect JDBI DAOs being annotated with
     * {@link OnDemand} annotation
     * 
     * @param parameter
     *            Parameter that was annotated for being injected
     * @return {@link OnDemandFactory} if interface or abstract (otherwise null)
     */
    @Override
    public AbstractContainerRequestValueFactory<?> createValueFactory(Parameter parameter) {
        Class<?> classType = parameter.getRawType();
        
        if(classType.isInterface() || Modifier.isAbstract(classType.getModifiers())) {
        	return new OnDemandFactory(classType);
        }
 
        return null;
    }
}
