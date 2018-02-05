package org.springframework.beans.factory.config;

import java.io.Serializable;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.core.MethodParameter;

public class DependencyDescriptor extends InjectionPoint implements Serializable{
	
	private final Class<?> declaringClass;

	private String methodName;

	private Class<?>[] parameterTypes;

	private int parameterIndex;

	private String fieldName;

	private final boolean required;

	private final boolean eager;

	private int nestingLevel = 1;

	private Class<?> containingClass;

	public DependencyDescriptor(MethodParameter methodParameter, boolean required, boolean eager) {
		super(methodParameter);
		this.declaringClass = methodParameter.getDeclaringClass();
		if (this.methodParameter.getMethod() != null) {
			this.methodName = methodParameter.getMethod().getName();
			this.parameterTypes = methodParameter.getMethod().getParameterTypes();
		}
		else {
			this.parameterTypes = methodParameter.getConstructor().getParameterTypes();
		}
		this.parameterIndex = methodParameter.getParameterIndex();
		this.containingClass = methodParameter.getContainingClass();
		this.required = required;
		this.eager = eager;
	}

}
