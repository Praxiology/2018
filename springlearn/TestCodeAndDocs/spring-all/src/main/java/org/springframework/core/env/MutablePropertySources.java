package org.springframework.core.env;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MutablePropertySources implements PropertySources {


	private final List<PropertySource<?>> propertySourceList = new CopyOnWriteArrayList<PropertySource<?>>();

	public Iterator<PropertySource<?>> iterator() {
		return null;
	}

	public boolean contains(String name) {
		return false;
	}

	public PropertySource<?> get(String name) {
		return null;
	}


}
