package com.milespomeroy.jersey2jdbi2hk2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.lingotek.jdbi.JdbiModule;

import javax.servlet.annotation.WebListener;

@WebListener
public class GuiceConfig extends GuiceServletContextListener
{
	@Override
	protected Injector getInjector()
	{
		return Guice.createInjector(
                    new JdbiModule(),
                    new GuiceModule(),
					new ServletModule()
					{
						@Override
						protected void configureServlets()
						{
						}
					}
		);
	}
}
