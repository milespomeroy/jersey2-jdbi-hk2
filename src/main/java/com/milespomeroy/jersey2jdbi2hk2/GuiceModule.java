package com.milespomeroy.jersey2jdbi2hk2;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.milespomeroy.jersey2jdbi2hk2.service.MagicService;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bindConstant().annotatedWith(Names.named("dataSourceJndi")).to("java:/comp/env/jdbc/learndb");
        bind(MagicService.class);
    }
}
