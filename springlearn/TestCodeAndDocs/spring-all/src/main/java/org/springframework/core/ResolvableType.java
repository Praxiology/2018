/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Map;

import org.springframework.core.ResolvableType.VariableResolver;
//import org.springframework.core.SerializableTypeWrapper.FieldTypeProvider;
//import org.springframework.core.SerializableTypeWrapper.MethodParameterTypeProvider;
import org.springframework.core.SerializableTypeWrapper.TypeProvider;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.springframework.util.ObjectUtils;
//import org.springframework.util.StringUtils;

/**
 * Encapsulates a Java {@link java.lang.reflect.Type}, providing access to
 * {@link #getSuperType() supertypes}, {@link #getInterfaces() interfaces}, and
 * {@link #getGeneric(int...) generic parameters} along with the ability to ultimately
 * {@link #resolve() resolve} to a {@link java.lang.Class}.
 *
 * <p>{@code ResolvableTypes} may be obtained from {@link #forField(Field) fields},
 * {@link #forMethodParameter(Method, int) method parameters},
 * {@link #forMethodReturnType(Method) method returns} or
 * {@link #forClass(Class) classes}. Most methods on this class will themselves return
 * {@link ResolvableType}s, allowing easy navigation. For example:
 * <pre class="code">
 * private HashMap&lt;Integer, List&lt;String&gt;&gt; myMap;
 *
 * public void example() {
 *     ResolvableType t = ResolvableType.forField(getClass().getDeclaredField("myMap"));
 *     t.getSuperType(); // AbstractMap&lt;Integer, List&lt;String&gt;&gt;
 *     t.asMap(); // Map&lt;Integer, List&lt;String&gt;&gt;
 *     t.getGeneric(0).resolve(); // Integer
 *     t.getGeneric(1).resolve(); // List
 *     t.getGeneric(1); // List&lt;String&gt;
 *     t.resolveGeneric(1, 0); // String
 * }
 * </pre>
 *
 * @author Phillip Webb
 * @author Juergen Hoeller
 * @author Stephane Nicoll
 * @since 4.0
 * @see #forField(Field)
 * @see #forMethodParameter(Method, int)
 * @see #forMethodReturnType(Method)
 * @see #forConstructorParameter(Constructor, int)
 * @see #forClass(Class)
 * @see #forType(Type)
 * @see #forInstance(Object)
 * @see ResolvableTypeProvider
 */
@SuppressWarnings("serial")
public class ResolvableType implements Serializable {

	/**
	 * {@code ResolvableType} returned when no value is available. {@code NONE} is used
	 * in preference to {@code null} so that multiple method calls can be safely chained.
	 */
	public static final ResolvableType NONE = new ResolvableType(null, null, null, 0);

	private static final ResolvableType[] EMPTY_TYPES_ARRAY = new ResolvableType[0];

	private static final ConcurrentReferenceHashMap<ResolvableType, ResolvableType> cache =
			new ConcurrentReferenceHashMap<ResolvableType, ResolvableType>(256);


	/**
	 * The underlying Java type being managed (only ever {@code null} for {@link #NONE}).
	 */
	private final Type type;

	/**
	 * Optional provider for the type.
	 */
	private final TypeProvider typeProvider;

	/**
	 * The {@code VariableResolver} to use or {@code null} if no resolver is available.
	 */
	private final VariableResolver variableResolver;

	/**
	 * The component type for an array or {@code null} if the type should be deduced.
	 */
	private final ResolvableType componentType;

	/**
	 * Copy of the resolved value.
	 */
	private final Class<?> resolved;

	private final Integer hash;

	private ResolvableType superType;

	private ResolvableType[] interfaces;

	private ResolvableType[] generics;


	private ResolvableType(Type type, TypeProvider typeProvider, VariableResolver variableResolver, Integer hash) {
		this.type = type;
		this.typeProvider = typeProvider;
		this.variableResolver = variableResolver;
		this.componentType = null;
		this.resolved = resolveClass();
		this.hash = hash;
	}
	
	private Class<?> resolveClass() {
		return null;
	}
	
	public static ResolvableType forMethodParameter(MethodParameter methodParameter) {
		return null;
	}
	
	public Class<?> resolve(Class<?> fallback) {
		return (this.resolved != null ? this.resolved : fallback);
	}
	
	public static ResolvableType forClass(Class<?> sourceClass) {
		return new ResolvableType(sourceClass);
	}
	
	private ResolvableType(Class<?> sourceClass) {
		this.resolved = (sourceClass != null ? sourceClass : Object.class);
		this.type = this.resolved;
		this.typeProvider = null;
		this.variableResolver = null;
		this.componentType = null;
		this.hash = null;
	}
	

	interface VariableResolver extends Serializable {

		/**
		 * Return the source of the resolver (used for hashCode and equals).
		 */
		Object getSource();

		/**
		 * Resolve the specified variable.
		 * @param variable the variable to resolve
		 * @return the resolved variable, or {@code null} if not found
		 */
		ResolvableType resolveVariable(TypeVariable<?> variable);
	}
}
