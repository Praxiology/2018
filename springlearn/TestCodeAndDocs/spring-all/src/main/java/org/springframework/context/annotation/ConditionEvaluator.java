package org.springframework.context.annotation;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.core.io.ResourceLoader;

class ConditionEvaluator {

	private final ConditionContextImpl context;


	/**
	 * Create a new {@link ConditionEvaluator} instance.
	 */
	public ConditionEvaluator(BeanDefinitionRegistry registry, Environment environment, ResourceLoader resourceLoader) {
		this.context = new ConditionContextImpl(registry, environment, resourceLoader);
	}
	private static class ConditionContextImpl implements ConditionContext {
		
		private final BeanDefinitionRegistry registry;

		private final ConfigurableListableBeanFactory beanFactory;

		private final Environment environment;

		private final ResourceLoader resourceLoader;

		public ConditionContextImpl(BeanDefinitionRegistry registry, Environment environment, ResourceLoader resourceLoader) {
			this.registry = registry;
			this.beanFactory = deduceBeanFactory(registry);
			this.environment = (environment != null ? environment : deduceEnvironment(registry));
			this.resourceLoader = (resourceLoader != null ? resourceLoader : deduceResourceLoader(registry));
		}
		private ConfigurableListableBeanFactory deduceBeanFactory(BeanDefinitionRegistry source) {
			if (source instanceof ConfigurableListableBeanFactory) {
				return (ConfigurableListableBeanFactory) source;
			}
			if (source instanceof ConfigurableApplicationContext) {
				return (((ConfigurableApplicationContext) source).getBeanFactory());
			}
			return null;
		}
		
		private Environment deduceEnvironment(BeanDefinitionRegistry source) {
			if (source instanceof EnvironmentCapable) {
				return ((EnvironmentCapable) source).getEnvironment();
			}
			return null;
		}
		private ResourceLoader deduceResourceLoader(BeanDefinitionRegistry source) {
			if (source instanceof ResourceLoader) {
				return (ResourceLoader) source;
			}
			return null;
		}
		public BeanDefinitionRegistry getRegistry() {
			return null;
		}
		public ConfigurableListableBeanFactory getBeanFactory() {
			return null;
		}
		public Environment getEnvironment() {
			return null;
		}
		public ResourceLoader getResourceLoader() {
			return null;
		}
		public ClassLoader getClassLoader() {
			return null;
		}

	}

}
