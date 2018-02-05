package org.springframework.core;

import org.springframework.util.Assert;

public class NamedThreadLocal<T> extends ThreadLocal<T> {
	public NamedThreadLocal(String name) {
		//Assert.hasText(name, "Name must not be empty");
		//this.name = name;
	}
}
