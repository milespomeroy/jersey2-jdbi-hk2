package com.milespomeroy.learn;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class MyBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(new IamSingle()).to(IamSingle.class);
	}

}
