package org.springframework.context.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ProtocolResolver;

public class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
	
	private Boolean allowBeanDefinitionOverriding;

	private Boolean allowCircularReferences;

	/** Bean factory for this context */
	private DefaultListableBeanFactory beanFactory;

	/** Synchronization monitor for the internal BeanFactory */
	private final Object beanFactoryMonitor = new Object();
	
	public AbstractRefreshableApplicationContext(ApplicationContext parent) {
		super(parent);
	}

	public void setId(String id) {
	}

	public void setParent(ApplicationContext parent) {
	}

	public ConfigurableEnvironment getEnvironment() {
		return null;
	}

	public void setEnvironment(ConfigurableEnvironment environment) {
	}

	public void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor) {
	}

	public void addApplicationListener(ApplicationListener<?> listener) {
	}

	public void addProtocolResolver(ProtocolResolver resolver) {
	}

	public void refresh() throws BeansException, IllegalStateException {
	}

	public void registerShutdownHook() {
	}

	public void close() {
	}

	public boolean isActive() {
		return false;
	}

	public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
		return null;
	}

	public String getId() {
		return null;
	}

	public String getApplicationName() {
		return null;
	}

	public String getDisplayName() {
		return null;
	}

	public long getStartupDate() {
		return 0;
	}

	public ApplicationContext getParent() {
		return null;
	}

	public AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException {
		return null;
	}

}
