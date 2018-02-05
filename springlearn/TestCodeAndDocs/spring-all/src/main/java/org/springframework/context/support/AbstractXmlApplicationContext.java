package org.springframework.context.support;

import org.springframework.context.ApplicationContext;

public class AbstractXmlApplicationContext extends AbstractRefreshableConfigApplicationContext{
	
	//?
	private boolean validating = true;
	
	public AbstractXmlApplicationContext(ApplicationContext parent) {
		super(parent);
	}

}
