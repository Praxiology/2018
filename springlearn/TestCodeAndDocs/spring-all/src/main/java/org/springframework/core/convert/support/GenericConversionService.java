package org.springframework.core.convert.support;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.converter.GenericConverter.ConvertiblePair;
import org.springframework.util.ClassUtils;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.springframework.util.ObjectUtils;

public class GenericConversionService implements ConfigurableConversionService {

	/**
	 * General NO-OP converter used when conversion is not required.
	 */
	private static final GenericConverter NO_OP_CONVERTER = new NoOpConverter("NO_OP");

	/**
	 * Used as a cache entry when no converter is available.  This converter is never
	 * returned.
	 */
	private static final GenericConverter NO_MATCH = new NoOpConverter("NO_MATCH");


	/** Java 8's java.util.Optional.empty() */
	private static Object javaUtilOptionalEmpty = null;

	static {
		try {
			Class<?> clazz = ClassUtils.forName("java.util.Optional", GenericConversionService.class.getClassLoader());
			javaUtilOptionalEmpty = ClassUtils.getMethod(clazz, "empty").invoke(null);
		}
		catch (Exception ex) {
			// Java 8 not available - conversion to Optional not supported then.
		}
	}


	private final Converters converters = new Converters();

	private final Map<ConverterCacheKey, GenericConverter> converterCache =
			new ConcurrentReferenceHashMap<ConverterCacheKey, GenericConverter>(64);
	/**
	 * Key for use with the converter cache.
	 */
	private static final class ConverterCacheKey implements Comparable<ConverterCacheKey> {

		private final TypeDescriptor sourceType;

		private final TypeDescriptor targetType;

		public ConverterCacheKey(TypeDescriptor sourceType, TypeDescriptor targetType) {
			this.sourceType = sourceType;
			this.targetType = targetType;
		}

		@Override
		public boolean equals(Object other) {
			if (this == other) {
				return true;
			}
			if (!(other instanceof ConverterCacheKey)) {
				return false;
			}
			ConverterCacheKey otherKey = (ConverterCacheKey) other;
			return (ObjectUtils.nullSafeEquals(this.sourceType, otherKey.sourceType) &&
					ObjectUtils.nullSafeEquals(this.targetType, otherKey.targetType));
		}

		@Override
		public int hashCode() {
			return (ObjectUtils.nullSafeHashCode(this.sourceType) * 29 +
					ObjectUtils.nullSafeHashCode(this.targetType));
		}

		@Override
		public String toString() {
			return ("ConverterCacheKey [sourceType = " + this.sourceType +
					", targetType = " + this.targetType + "]");
		}

//		/@Override
		public int compareTo(ConverterCacheKey other) {
			/*int result = this.sourceType.getResolvableType().toString().compareTo(
					other.sourceType.getResolvableType().toString());
			if (result == 0) {
				result = this.targetType.getResolvableType().toString().compareTo(
						other.targetType.getResolvableType().toString());
			}
			return result;*/
			return -1;
		}
	}
	private static class Converters {

		private final Set<GenericConverter> globalConverters = new LinkedHashSet<GenericConverter>();

		private final Map<ConvertiblePair, ConvertersForPair> converters =
				new LinkedHashMap<ConvertiblePair, ConvertersForPair>(36);
	}
	/**
	 * Manages converters registered with a specific {@link ConvertiblePair}.
	 */
	private static class ConvertersForPair {

		private final LinkedList<GenericConverter> converters = new LinkedList<GenericConverter>();

		public void add(GenericConverter converter) {
			this.converters.addFirst(converter);
		}

		public GenericConverter getConverter(TypeDescriptor sourceType, TypeDescriptor targetType) {
			return null;
		}

		@Override
		public String toString() {
			return null;
			//return StringUtils.collectionToCommaDelimitedString(this.converters);
		}
	}
	
	private static class NoOpConverter implements GenericConverter {

		private final String name;

		public NoOpConverter(String name) {
			this.name = name;
		}


		@Override
		public String toString() {
			return this.name;
		}


		public Set<ConvertiblePair> getConvertibleTypes() {
			// TODO Auto-generated method stub
			return null;
		}


		public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	public void addConverter(Converter<?, ?> converter) {
		// TODO Auto-generated method stub
		
	}

	public <S, T> void addConverter(Class<S> sourceType, Class<T> targetType,
			Converter<? super S, ? extends T> converter) {
		// TODO Auto-generated method stub
		
	}

	public void addConverter(GenericConverter converter) {
		// TODO Auto-generated method stub
		
	}

	public void addConverterFactory(ConverterFactory<?, ?> converterFactory) {
		// TODO Auto-generated method stub
		
	}

	public void removeConvertible(Class<?> sourceType, Class<?> targetType) {
		// TODO Auto-generated method stub
		
	}


}
