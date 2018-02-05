package org.springframework.beans.factory.xml;

import org.springframework.beans.factory.parsing.DefaultsDefinition;

public class DocumentDefaultsDefinition implements DefaultsDefinition {

	private String lazyInit;

	private String merge;

	private String autowire;

	private String dependencyCheck;

	private String autowireCandidates;

	private String initMethod;

	private String destroyMethod;

	private Object source;

	public Object getSource() {
		return source;
	}

}
