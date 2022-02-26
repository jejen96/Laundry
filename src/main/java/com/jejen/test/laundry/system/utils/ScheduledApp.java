package com.jejen.test.laundry.system.utils;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScheduledApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AnnotationConfigApplicationContext(ScheduledConfig.class);
	}

}
