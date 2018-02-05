package org.springframework.context.support;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

public class AbstractRefreshableConfigApplicationContext extends AbstractRefreshableApplicationContext 
       implements BeanNameAware, InitializingBean{
	  
	//
	private String[] configLocations;

	private boolean setIdCalled = false;
	
	public AbstractRefreshableConfigApplicationContext(ApplicationContext parent) {
		super(parent);
	}

	public void setBeanName(String name) {
		
	}

	public void afterPropertiesSet() throws Exception {
		
	}
}
