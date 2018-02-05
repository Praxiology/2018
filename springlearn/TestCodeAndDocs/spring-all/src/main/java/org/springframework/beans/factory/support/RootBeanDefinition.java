package org.springframework.beans.factory.support;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.util.Set;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.core.ResolvableType;

public class RootBeanDefinition extends AbstractBeanDefinition {

	private BeanDefinitionHolder decoratedDefinition;

	private AnnotatedElement qualifiedElement;

	boolean allowCaching = true;

	boolean isFactoryMethodUnique = false;

	volatile ResolvableType targetType;

	/** Package-visible field for caching the determined Class of a given bean definition */
	volatile Class<?> resolvedTargetType;

	/** Package-visible field for caching the return type of a generically typed factory method */
	volatile ResolvableType factoryMethodReturnType;

	/** Common lock for the four constructor fields below */
	final Object constructorArgumentLock = new Object();

	/** Package-visible field for caching the resolved constructor or factory method */
	Object resolvedConstructorOrFactoryMethod;

	/** Package-visible field that marks the constructor arguments as resolved */
	boolean constructorArgumentsResolved = false;

	/** Package-visible field for caching fully resolved constructor arguments */
	Object[] resolvedConstructorArguments;

	/** Package-visible field for caching partly prepared constructor arguments */
	Object[] preparedConstructorArguments;

	/** Common lock for the two post-processing fields below */
	final Object postProcessingLock = new Object();

	/** Package-visible field that indicates MergedBeanDefinitionPostProcessor having been applied */
	boolean postProcessed = false;

	/** Package-visible field that indicates a before-instantiation post-processor having kicked in */
	volatile Boolean beforeInstantiationResolved;

	private Set<Member> externallyManagedConfigMembers;

	private Set<String> externallyManagedInitMethods;

	private Set<String> externallyManagedDestroyMethods;

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
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAbstract() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getRole() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getResourceDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public BeanDefinition getOriginatingBeanDefinition() {
		// TODO Auto-generated method stub
		return null;
	}

}
