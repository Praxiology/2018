package org.springframework.core;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

import org.springframework.core.SerializableTypeWrapper.TypeProvider;
import org.springframework.util.ConcurrentReferenceHashMap;

public class SerializableTypeWrapper {
	
	private static final Class<?>[] SUPPORTED_SERIALIZABLE_TYPES = {
			GenericArrayType.class, ParameterizedType.class, TypeVariable.class, WildcardType.class};

	private static final ConcurrentReferenceHashMap<Type, Type> cache =
			new ConcurrentReferenceHashMap<Type, Type>(256);
	/**
	 * Additional interface implemented by the type proxy.
	 */
	interface SerializableTypeProxy {

		/**
		 * Return the underlying type provider.
		 */
		TypeProvider getTypeProvider();
	}

	/**
	 * A {@link Serializable} interface providing access to a {@link Type}.
	 */
	interface TypeProvider extends Serializable {

		/**
		 * Return the (possibly non {@link Serializable}) {@link Type}.
		 */
		Type getType();

		/**
		 * Return the source of the type or {@code null}.
		 */
		Object getSource();
	}
}
