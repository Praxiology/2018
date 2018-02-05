package org.springframework.core.env;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.util.SystemPropertyUtils;

public abstract class AbstractPropertyResolver implements ConfigurablePropertyResolver {


	protected ConfigurableConversionService conversionService = new DefaultConversionService();

	private PropertyPlaceholderHelper nonStrictHelper;

	private PropertyPlaceholderHelper strictHelper;

	private boolean ignoreUnresolvableNestedPlaceholders = false;

	private String placeholderPrefix = SystemPropertyUtils.PLACEHOLDER_PREFIX;

	private String placeholderSuffix = SystemPropertyUtils.PLACEHOLDER_SUFFIX;

	private String valueSeparator = SystemPropertyUtils.VALUE_SEPARATOR;

	private final Set<String> requiredProperties = new LinkedHashSet<String>();



}
