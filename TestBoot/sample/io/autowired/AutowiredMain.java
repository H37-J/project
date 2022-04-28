package com.hjk.testboot.sample.io.autowired;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredMain {
    	public static void main(String... args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext
				(HellConfiguration.class);
		MessageRender mr = ctx.getBean("renderer", MessageRender.class);
		mr.render();
	}
}
