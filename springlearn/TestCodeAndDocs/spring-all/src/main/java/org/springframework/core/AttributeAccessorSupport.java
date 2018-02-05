package org.springframework.core;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AttributeAccessorSupport implements AttributeAccessor, Serializable {

	/** Map with String keys and Object values */
	private final Map<String, Object> attributes = new LinkedHashMap<String, Object>(0);



}
