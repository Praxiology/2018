package org.springframework.core;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

public class Constants {
	
	/** The name of the introspected class */
	private final String className;

	/** Map from String field name to object value */
	private final Map<String, Object> fieldCache = new HashMap<String, Object>();


	/**
	 * Create a new Constants converter class wrapping the given class.
	 * <p>All <b>public</b> static final variables will be exposed, whatever their type.
	 * @param clazz the class to analyze
	 * @throws IllegalArgumentException if the supplied {@code clazz} is {@code null}
	 */
	public Constants(Class<?> clazz) {
		Assert.notNull(clazz);
		this.className = clazz.getName();
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			if (ReflectionUtils.isPublicStaticFinal(field)) {
				String name = field.getName();
				try {
					Object value = field.get(null);
					this.fieldCache.put(name, value);
				}
				catch (IllegalAccessException ex) {
					// just leave this field and continue
				}
			}
		}
	}

}
