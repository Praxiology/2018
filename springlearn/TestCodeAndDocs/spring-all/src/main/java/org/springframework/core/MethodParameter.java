package org.springframework.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

public class MethodParameter {

	private static final Class<?> javaUtilOptionalClass;

	static {
		Class<?> clazz;
		try {
			clazz = ClassUtils.forName("java.util.Optional", MethodParameter.class.getClassLoader());
		} catch (ClassNotFoundException ex) {
			// Java 8 not available - Optional references simply not supported then.
			clazz = null;
		}
		javaUtilOptionalClass = clazz;
	}

	private final Method method;

	private final Constructor<?> constructor;

	private final int parameterIndex;

	private int nestingLevel = 1;

	/** Map from Integer level to Integer type index */
	Map<Integer, Integer> typeIndexesPerLevel;

	private volatile Class<?> containingClass;

	private volatile Class<?> parameterType;

	private volatile Type genericParameterType;

	private volatile Annotation[] parameterAnnotations;

	private volatile ParameterNameDiscoverer parameterNameDiscoverer;

	private volatile String parameterName;

	private volatile MethodParameter nestedMethodParameter;

	public MethodParameter(MethodParameter original) {
		Assert.notNull(original, "Original must not be null");
		this.method = original.method;
		this.constructor = original.constructor;
		this.parameterIndex = original.parameterIndex;
		this.nestingLevel = original.nestingLevel;
		this.typeIndexesPerLevel = original.typeIndexesPerLevel;
		this.containingClass = original.containingClass;
		this.parameterType = original.parameterType;
		this.genericParameterType = original.genericParameterType;
		this.parameterAnnotations = original.parameterAnnotations;
		this.parameterNameDiscoverer = original.parameterNameDiscoverer;
		this.parameterName = original.parameterName;
	}
	
	public Class<?> getParameterType() {
		if (this.parameterType == null) {
			if (this.parameterIndex < 0) {
				this.parameterType = (this.method != null ? this.method.getReturnType() : null);
			}
			else {
				this.parameterType = (this.method != null ?
					this.method.getParameterTypes()[this.parameterIndex] :
					this.constructor.getParameterTypes()[this.parameterIndex]);
			}
		}
		return this.parameterType;
	}
	
	public Annotation[] getParameterAnnotations() {
		if (this.parameterAnnotations == null) {
			Annotation[][] annotationArray = (this.method != null ?
					this.method.getParameterAnnotations() : this.constructor.getParameterAnnotations());
			if (this.parameterIndex >= 0 && this.parameterIndex < annotationArray.length) {
				this.parameterAnnotations = adaptAnnotationArray(annotationArray[this.parameterIndex]);
			}
			else {
				this.parameterAnnotations = new Annotation[0];
			}
		}
		return this.parameterAnnotations;
	}
	
	protected Annotation[] adaptAnnotationArray(Annotation[] annotations) {
		return annotations;
	}
	
	public Annotation[] getMethodAnnotations() {
		return null;
	}

	public Method getMethod() {
		return null;
	}

	public Class<?> getDeclaringClass() {
		return null;
	}

	public Constructor<?> getConstructor() {
		return null;
	}

	public int getParameterIndex() {
		return 0;
	}

	public Class<?> getContainingClass() {
		return null;
	}
}
