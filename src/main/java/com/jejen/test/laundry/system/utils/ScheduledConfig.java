package com.jejen.test.laundry.system.utils;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@EnableScheduling
@ComponentScan(basePackages={"com.jejen.test.laundry.system.controller"})
public class ScheduledConfig {
	
}
