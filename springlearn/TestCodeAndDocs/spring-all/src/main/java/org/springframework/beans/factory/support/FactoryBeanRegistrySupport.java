package org.springframework.beans.factory.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
	
	/** Cache of singleton objects created by FactoryBeans: FactoryBean name --> object */
	private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>(16);

}
