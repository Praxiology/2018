package org.springframework.beans.factory.support;

import java.beans.PropertyEditor;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanExpressionResolver;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.config.NamedBeanHolder;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.convert.ConversionService;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringValueResolver;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory 
implements ConfigurableListableBeanFactory, BeanDefinitionRegistry, Serializable {
	
	private static Class<?> javaUtilOptionalClass = null;

	private static Class<?> javaxInjectProviderClass = null;

	static {
		try {
			javaUtilOptionalClass =
					ClassUtils.forName("java.util.Optional", DefaultListableBeanFactory.class.getClassLoader());
		}
		catch (ClassNotFoundException ex) {
			// Java 8 not available - Optional references simply not supported then.
		}
		try {
			javaxInjectProviderClass =
					ClassUtils.forName("javax.inject.Provider", DefaultListableBeanFactory.class.getClassLoader());
		}
		catch (ClassNotFoundException ex) {
			// JSR-330 API not available - Provider interface simply not supported then.
		}
	}


	/** Map from serialized id to factory instance */
	private static final Map<String, Reference<DefaultListableBeanFactory>> serializableFactories =
			new ConcurrentHashMap<String, Reference<DefaultListableBeanFactory>>(8);

	/** Optional id for this factory, for serialization purposes */
	private String serializationId;

	/** Whether to allow re-registration of a different definition with the same name */
	private boolean allowBeanDefinitionOverriding = true;

	/** Whether to allow eager class loading even for lazy-init beans */
	private boolean allowEagerClassLoading = true;

	/** Optional OrderComparator for dependency Lists and arrays */
	private Comparator<Object> dependencyComparator;

	/** Resolver to use for checking if a bean definition is an autowire candidate */
	private AutowireCandidateResolver autowireCandidateResolver = new SimpleAutowireCandidateResolver();

	/** Map from dependency type to corresponding autowired value */
	private final Map<Class<?>, Object> resolvableDependencies = new ConcurrentHashMap<Class<?>, Object>(16);

	/** Map of bean definition objects, keyed by bean name */
	private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(256);

	/** Map of singleton and non-singleton bean names, keyed by dependency type */
	private final Map<Class<?>, String[]> allBeanNamesByType = new ConcurrentHashMap<Class<?>, String[]>(64);

	/** Map of singleton-only bean names, keyed by dependency type */
	private final Map<Class<?>, String[]> singletonBeanNamesByType = new ConcurrentHashMap<Class<?>, String[]>(64);

	/** List of bean definition names, in registration order */
	private volatile List<String> beanDefinitionNames = new ArrayList<String>(256);

	/** List of names of manually registered singletons, in registration order */
	private volatile Set<String> manualSingletonNames = new LinkedHashSet<String>(16);

	/** Cached array of bean definition names in case of frozen configuration */
	private volatile String[] frozenBeanDefinitionNames;

	/** Whether bean definition metadata may be cached for all beans */
	private volatile boolean configurationFrozen = false;

	public void registerAlias(String name, String alias) {
	}

	public void removeAlias(String alias) {
	}

	public boolean isAlias(String name) {
		return false;
	}

	public String[] getAliases(String name) {
		return null;
	}

	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		
	}

	public void removeBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
		
	}

	public BeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
		return null;
	}

	public boolean containsBeanDefinition(String beanName) {
		return false;
	}

	public String[] getBeanDefinitionNames() {
		return null;
	}

	public int getBeanDefinitionCount() {
		return 0;
	}

	public boolean isBeanNameInUse(String beanName) {
		return false;
	}

	public <T> T createBean(Class<T> beanClass) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public void autowireBean(Object existingBean) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	public Object configureBean(Object existingBean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object createBean(Class<?> beanClass, int autowireMode, boolean dependencyCheck) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object autowire(Class<?> beanClass, int autowireMode, boolean dependencyCheck) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public void autowireBeanProperties(Object existingBean, int autowireMode, boolean dependencyCheck)
			throws BeansException {
		// TODO Auto-generated method stub
		
	}

	public void applyBeanPropertyValues(Object existingBean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	public Object initializeBean(Object existingBean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public void destroyBean(Object existingBean) {
		// TODO Auto-generated method stub
		
	}

	public <T> NamedBeanHolder<T> resolveNamedBean(Class<T> requiredType) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object resolveDependency(DependencyDescriptor descriptor, String requestingBeanName) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object resolveDependency(DependencyDescriptor descriptor, String requestingBeanName,
			Set<String> autowiredBeanNames, TypeConverter typeConverter) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setParentBeanFactory(BeanFactory parentBeanFactory) throws IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	public void setBeanClassLoader(ClassLoader beanClassLoader) {
		// TODO Auto-generated method stub
		
	}

	public ClassLoader getBeanClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTempClassLoader(ClassLoader tempClassLoader) {
		// TODO Auto-generated method stub
		
	}

	public ClassLoader getTempClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCacheBeanMetadata(boolean cacheBeanMetadata) {
		// TODO Auto-generated method stub
		
	}

	public boolean isCacheBeanMetadata() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setBeanExpressionResolver(BeanExpressionResolver resolver) {
		// TODO Auto-generated method stub
		
	}

	public BeanExpressionResolver getBeanExpressionResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setConversionService(ConversionService conversionService) {
		// TODO Auto-generated method stub
		
	}

	public ConversionService getConversionService() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addPropertyEditorRegistrar(PropertyEditorRegistrar registrar) {
		// TODO Auto-generated method stub
		
	}

	public void registerCustomEditor(Class<?> requiredType, Class<? extends PropertyEditor> propertyEditorClass) {
		// TODO Auto-generated method stub
		
	}

	public void copyRegisteredEditorsTo(PropertyEditorRegistry registry) {
		// TODO Auto-generated method stub
		
	}

	public void setTypeConverter(TypeConverter typeConverter) {
		// TODO Auto-generated method stub
		
	}

	public TypeConverter getTypeConverter() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addEmbeddedValueResolver(StringValueResolver valueResolver) {
		// TODO Auto-generated method stub
		
	}

	public boolean hasEmbeddedValueResolver() {
		// TODO Auto-generated method stub
		return false;
	}

	public String resolveEmbeddedValue(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
		// TODO Auto-generated method stub
		
	}

	public int getBeanPostProcessorCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void registerScope(String scopeName, Scope scope) {
		// TODO Auto-generated method stub
		
	}

	public String[] getRegisteredScopeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public Scope getRegisteredScope(String scopeName) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccessControlContext getAccessControlContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public void copyConfigurationFrom(ConfigurableBeanFactory otherFactory) {
		// TODO Auto-generated method stub
		
	}

	public void resolveAliases(StringValueResolver valueResolver) {
		// TODO Auto-generated method stub
		
	}

	public BeanDefinition getMergedBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isFactoryBean(String name) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return false;
	}

	public void setCurrentlyInCreation(String beanName, boolean inCreation) {
		// TODO Auto-generated method stub
		
	}

	public boolean isCurrentlyInCreation(String beanName) {
		// TODO Auto-generated method stub
		return false;
	}

	public void registerDependentBean(String beanName, String dependentBeanName) {
		// TODO Auto-generated method stub
		
	}

	public String[] getDependentBeans(String beanName) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getDependenciesForBean(String beanName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void destroyBean(String beanName, Object beanInstance) {
		// TODO Auto-generated method stub
		
	}

	public void destroyScopedBean(String beanName) {
		// TODO Auto-generated method stub
		
	}

	public void destroySingletons() {
		// TODO Auto-generated method stub
		
	}

}
