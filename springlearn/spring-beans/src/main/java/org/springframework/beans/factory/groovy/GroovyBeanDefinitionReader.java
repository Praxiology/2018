package org.springframework.beans.factory.groovy;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.io.Resource;

import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;

public class GroovyBeanDefinitionReader extends AbstractBeanDefinitionReader implements GroovyObject {

	public GroovyBeanDefinitionReader(BeanDefinitionRegistry registry) {
		super(registry);
	}

	@Override
	public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object invokeMethod(String name, Object args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getProperty(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperty(String propertyName, Object newValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MetaClass getMetaClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMetaClass(MetaClass metaClass) {
		// TODO Auto-generated method stub
		
	}

}
