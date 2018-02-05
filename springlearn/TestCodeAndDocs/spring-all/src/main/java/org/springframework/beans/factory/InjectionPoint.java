package org.springframework.beans.factory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.springframework.core.MethodParameter;
import org.springframework.util.Assert;

public class InjectionPoint {
	protected MethodParameter methodParameter;
	protected Field field;
	private volatile Annotation[] fieldAnnotations;
	public InjectionPoint(MethodParameter methodParameter) {
		Assert.notNull(methodParameter, "MethodParameter must not be null");
		this.methodParameter = methodParameter;
	}
}
