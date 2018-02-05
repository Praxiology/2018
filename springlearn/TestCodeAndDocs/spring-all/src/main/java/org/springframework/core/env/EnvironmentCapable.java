package org.springframework.core.env;

public interface EnvironmentCapable {
	
	/**
	 * Return the {@link Environment} associated with this component.
	 */
	public Environment getEnvironment();

}
