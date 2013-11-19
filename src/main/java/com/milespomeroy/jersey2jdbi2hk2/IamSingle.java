package com.milespomeroy.jersey2jdbi2hk2;

import javax.inject.Singleton;

@Singleton
public class IamSingle {
	private int times;
	
	public void touch() {
		System.out.println("Something touched me!");
		times++;
		System.out.println("I've been touch " + times + " times.");
	}
}
