package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.DependencyDescriptor;

public class SimpleAutowireCandidateResolver implements AutowireCandidateResolver {

	public boolean isAutowireCandidate(BeanDefinitionHolder bdHolder, DependencyDescriptor descriptor) {
		return false;
	}

	public Object getSuggestedValue(DependencyDescriptor descriptor) {
		return null;
	}

	public Object getLazyResolutionProxyIfNecessary(DependencyDescriptor descriptor, String beanName) {
		return null;
	}


}
