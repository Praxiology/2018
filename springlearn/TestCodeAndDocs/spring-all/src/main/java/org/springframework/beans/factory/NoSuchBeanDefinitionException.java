package org.springframework.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.core.ResolvableType;

public class NoSuchBeanDefinitionException extends BeansException {

	private String beanName;

	private ResolvableType resolvableType;


}
