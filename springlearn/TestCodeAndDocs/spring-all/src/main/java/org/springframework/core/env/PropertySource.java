package org.springframework.core.env;

import org.springframework.util.Assert;

public abstract class PropertySource<T> {

	protected final String name;

	protected final T source;
	
	public PropertySource(String name, T source) {
		Assert.hasText(name, "Property source name must contain at least one character");
		Assert.notNull(source, "Property source must not be null");
		this.name = name;
		this.source = source;
	}

}
