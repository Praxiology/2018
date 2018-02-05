package org.springframework.beans.factory;

import org.springframework.beans.FatalBeanException;

public class BeanDefinitionStoreException extends FatalBeanException {

	private String resourceDescription;

	private String beanName;

}
