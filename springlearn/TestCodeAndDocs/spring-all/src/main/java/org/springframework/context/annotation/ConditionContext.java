package org.springframework.context.annotation;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;

public interface ConditionContext {
	/**
	 * Return the {@link BeanDefinitionRegistry} that will hold the bean definition
	 * should the condition match or {@code null} if the registry is not available.
	 * @return the registry or {@code null}
	 */
	BeanDefinitionRegistry getRegistry();

	/**
	 * Return the {@link ConfigurableListableBeanFactory} that will hold the bean
	 * definition should the condition match or {@code null} if the bean factory
	 * is not available.
	 * @return the bean factory or {@code null}
	 */
	ConfigurableListableBeanFactory getBeanFactory();

	/**
	 * Return the {@link Environment} for which the current application is running
	 * or {@code null} if no environment is available.
	 * @return the environment or {@code null}
	 */
	Environment getEnvironment();

	/**
	 * Return the {@link ResourceLoader} currently being used or {@code null}
	 * if the resource loader cannot be obtained.
	 * @return a resource loader or {@code null}
	 */
	ResourceLoader getResourceLoader();

	/**
	 * Return the {@link ClassLoader} that should be used to load additional
	 * classes or {@code null} if the default classloader should be used.
	 * @return the class loader or {@code null}
	 */
	ClassLoader getClassLoader();
}
