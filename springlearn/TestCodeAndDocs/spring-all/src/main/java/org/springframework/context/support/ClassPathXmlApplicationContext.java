package org.springframework.context.support;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{
	
	private Resource[] configResources;
	
	public ClassPathXmlApplicationContext(ApplicationContext parent) {
		super(parent);
	}

}
