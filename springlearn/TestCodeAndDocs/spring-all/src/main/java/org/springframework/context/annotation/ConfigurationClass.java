package org.springframework.context.annotation;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.util.Assert;

final class ConfigurationClass {

	private final AnnotationMetadata metadata;

	private final Resource resource;

	private String beanName;

	private final Set<ConfigurationClass> importedBy = new LinkedHashSet<ConfigurationClass>(1);

	private final Set<BeanMethod> beanMethods = new LinkedHashSet<BeanMethod>();

	private final Map<String, Class<? extends BeanDefinitionReader>> importedResources =
			new LinkedHashMap<String, Class<? extends BeanDefinitionReader>>();

	private final Map<ImportBeanDefinitionRegistrar, AnnotationMetadata> importBeanDefinitionRegistrars =
			new LinkedHashMap<ImportBeanDefinitionRegistrar, AnnotationMetadata>();

	final Set<String> skippedBeanMethods = new HashSet<String>();


	/**
	 * Create a new {@link ConfigurationClass} with the given name.
	 * @param metadataReader reader used to parse the underlying {@link Class}
	 * @param beanName must not be {@code null}
	 * @see ConfigurationClass#ConfigurationClass(Class, ConfigurationClass)
	 */
	public ConfigurationClass(MetadataReader metadataReader, String beanName) {
		Assert.hasText(beanName, "Bean name must not be null");
		this.metadata = metadataReader.getAnnotationMetadata();
		this.resource = metadataReader.getResource();
		this.beanName = beanName;
	}


	public AnnotationMetadata getMetadata() {
		return this.metadata;
	}

}
