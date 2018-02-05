package org.springframework.context.annotation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.parsing.SourceExtractor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

public class ConfigurationClassBeanDefinitionReader {
	
	private static final ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();

	private final BeanDefinitionRegistry registry;

	private final SourceExtractor sourceExtractor;

	private final ResourceLoader resourceLoader;

	private final Environment environment;

	private final BeanNameGenerator importBeanNameGenerator;

	private final ImportRegistry importRegistry;

	private final ConditionEvaluator conditionEvaluator;
	
	ConfigurationClassBeanDefinitionReader(BeanDefinitionRegistry registry, SourceExtractor sourceExtractor,
			ResourceLoader resourceLoader, Environment environment, BeanNameGenerator importBeanNameGenerator,
			ImportRegistry importRegistry) {

		this.registry = registry;
		this.sourceExtractor = sourceExtractor;
		this.resourceLoader = resourceLoader;
		this.environment = environment;
		this.importBeanNameGenerator = importBeanNameGenerator;
		this.importRegistry = importRegistry;
		this.conditionEvaluator = new ConditionEvaluator(registry, environment, resourceLoader);
	}
	
	private static class ConfigurationClassBeanDefinition extends RootBeanDefinition implements AnnotatedBeanDefinition {

		private final AnnotationMetadata annotationMetadata;

		private final MethodMetadata factoryMethodMetadata;

		public ConfigurationClassBeanDefinition(ConfigurationClass configClass, MethodMetadata beanMethodMetadata) {
			this.annotationMetadata = configClass.getMetadata();
			this.factoryMethodMetadata = beanMethodMetadata;
			//setLenientConstructorResolution(false);
		}

		public String getParentName() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setParentName(String parentName) {
			// TODO Auto-generated method stub
			
		}

		public String getBeanClassName() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setBeanClassName(String beanClassName) {
			// TODO Auto-generated method stub
			
		}

		public String getFactoryBeanName() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setFactoryBeanName(String factoryBeanName) {
			// TODO Auto-generated method stub
			
		}

		public String getFactoryMethodName() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setFactoryMethodName(String factoryMethodName) {
			// TODO Auto-generated method stub
			
		}

		public String getScope() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setScope(String scope) {
			// TODO Auto-generated method stub
			
		}

		public boolean isLazyInit() {
			// TODO Auto-generated method stub
			return false;
		}

		public void setLazyInit(boolean lazyInit) {
			// TODO Auto-generated method stub
			
		}

		public String[] getDependsOn() {
			// TODO Auto-generated method stub
			return null;
		}

		public void setDependsOn(String... dependsOn) {
			// TODO Auto-generated method stub
			
		}

		public boolean isAutowireCandidate() {
			// TODO Auto-generated method stub
			return false;
		}

		public void setAutowireCandidate(boolean autowireCandidate) {
			// TODO Auto-generated method stub
			
		}

		public boolean isPrimary() {
			// TODO Auto-generated method stub
			return false;
		}

		public void setPrimary(boolean primary) {
			// TODO Auto-generated method stub
			
		}

		public ConstructorArgumentValues getConstructorArgumentValues() {
			// TODO Auto-generated method stub
			return null;
		}

		public MutablePropertyValues getPropertyValues() {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean isSingleton() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isPrototype() {
			return false;
		}

		public boolean isAbstract() {
			return false;
		}

		public int getRole() {
			return 0;
		}

		public String getDescription() {
			return null;
		}

		public String getResourceDescription() {
			return null;
		}

		public BeanDefinition getOriginatingBeanDefinition() {
			return null;
		}

		public AnnotationMetadata getMetadata() {
			return null;
		}

		public MethodMetadata getFactoryMethodMetadata() {
			return null;
		}

	}
	
	/**
	 * Evaluate {@code @Conditional} annotations, tracking results and taking into
	 * account 'imported by'.
	 */
	private class TrackedConditionEvaluator {

		private final Map<ConfigurationClass, Boolean> skipped = new HashMap<ConfigurationClass, Boolean>();

		public boolean shouldSkip(ConfigurationClass configClass) {
			Boolean skip = this.skipped.get(configClass);
			return skip;
		}
	}

}
