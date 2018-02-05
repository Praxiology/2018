package org.springframework.context.annotation;

import java.lang.annotation.Annotation;

public class AnnotationScopeMetadataResolver implements ScopeMetadataResolver {
	private final ScopedProxyMode defaultProxyMode;

	protected Class<? extends Annotation> scopeAnnotationType = Scope.class;
	
	public AnnotationScopeMetadataResolver() {
		this.defaultProxyMode = ScopedProxyMode.NO;
	}

}
