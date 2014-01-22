package com.milespomeroy.jersey2jdbi2hk2;

import com.google.inject.AbstractModule;
import com.milespomeroy.jersey2jdbi2hk2.service.MagicService;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MagicService.class);
    }
}
