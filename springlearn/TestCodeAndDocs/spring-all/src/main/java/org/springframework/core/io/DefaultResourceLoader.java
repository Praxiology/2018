package org.springframework.core.io;

import java.util.LinkedHashSet;
import java.util.Set;

public class DefaultResourceLoader implements ResourceLoader {
	private ClassLoader classLoader;

	private final Set<ProtocolResolver> protocolResolvers = new LinkedHashSet<ProtocolResolver>(4);

	public Resource getResource(String location) {
		return null;
	}

	public ClassLoader getClassLoader() {
		return null;
	}

}
