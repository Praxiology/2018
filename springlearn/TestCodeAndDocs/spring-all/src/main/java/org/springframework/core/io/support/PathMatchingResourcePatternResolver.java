package org.springframework.core.io.support;

import java.lang.reflect.Method;
import java.net.URL;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ClassUtils;
import org.springframework.util.PathMatcher;

public class PathMatchingResourcePatternResolver implements ResourcePatternResolver {


	private static Method equinoxResolveMethod;

	static {
		try {
			// Detect Equinox OSGi (e.g. on WebSphere 6.1)
			Class<?> fileLocatorClass = ClassUtils.forName("org.eclipse.core.runtime.FileLocator",
					PathMatchingResourcePatternResolver.class.getClassLoader());
			equinoxResolveMethod = fileLocatorClass.getMethod("resolve", URL.class);
		}
		catch (Throwable ex) {
			equinoxResolveMethod = null;
		}
	}


	private final ResourceLoader resourceLoader;

	private PathMatcher pathMatcher = new AntPathMatcher();


	/**
	 * Create a new PathMatchingResourcePatternResolver with a DefaultResourceLoader.
	 * <p>ClassLoader access will happen via the thread context class loader.
	 * @see org.springframework.core.io.DefaultResourceLoader
	 */
	public PathMatchingResourcePatternResolver() {
		this.resourceLoader = new DefaultResourceLoader();
	}


	public Resource getResource(String location) {
		// TODO Auto-generated method stub
		return null;
	}


	public ClassLoader getClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}

}
