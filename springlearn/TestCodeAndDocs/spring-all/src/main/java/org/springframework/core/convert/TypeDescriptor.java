package org.springframework.core.convert;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.core.ResolvableType;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

public class TypeDescriptor implements Serializable {
	
	static final Annotation[] EMPTY_ANNOTATION_ARRAY = new Annotation[0];

	private static final boolean streamAvailable = ClassUtils.isPresent(
			"java.util.stream.Stream", TypeDescriptor.class.getClassLoader());

	private static final Map<Class<?>, TypeDescriptor> commonTypesCache = new HashMap<Class<?>, TypeDescriptor>(18);

	private static final Class<?>[] CACHED_COMMON_TYPES = {
			boolean.class, Boolean.class, byte.class, Byte.class, char.class, Character.class,
			double.class, Double.class, int.class, Integer.class, long.class, Long.class,
			float.class, Float.class, short.class, Short.class, String.class, Object.class};

	static {
		for (Class<?> preCachedClass : CACHED_COMMON_TYPES) {
			commonTypesCache.put(preCachedClass, valueOf(preCachedClass));
		}
	}


	private final Class<?> type;

	private final ResolvableType resolvableType;

	private final Annotation[] annotations;
	
	protected TypeDescriptor(ResolvableType resolvableType, Class<?> type, Annotation[] annotations) {
		this.resolvableType = resolvableType;
		this.type = (type != null ? type : resolvableType.resolve(Object.class));
		this.annotations = nullSafeAnnotations(annotations);
	}
	public TypeDescriptor(MethodParameter methodParameter) {
		Assert.notNull(methodParameter, "MethodParameter must not be null");
		this.resolvableType = ResolvableType.forMethodParameter(methodParameter);
		this.type = this.resolvableType.resolve(methodParameter.getParameterType());
		this.annotations = (methodParameter.getParameterIndex() == -1 ?
				nullSafeAnnotations(methodParameter.getMethodAnnotations()) :
				nullSafeAnnotations(methodParameter.getParameterAnnotations()));
	}
	
	private Annotation[] nullSafeAnnotations(Annotation[] annotations) {
		return (annotations != null ? annotations : EMPTY_ANNOTATION_ARRAY);
	}
	
	public static TypeDescriptor valueOf(Class<?> type) {
		if (type == null) {
			type = Object.class;
		}
		TypeDescriptor desc = commonTypesCache.get(type);
		return (desc != null ? desc : new TypeDescriptor(ResolvableType.forClass(type), null, null));
	}

}
