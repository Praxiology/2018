package org.springframework.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class PrioritizedParameterNameDiscoverer implements ParameterNameDiscoverer {
	
	private final List<ParameterNameDiscoverer> parameterNameDiscoverers =
			new LinkedList<ParameterNameDiscoverer>();


	/**
	 * Add a further ParameterNameDiscoverer to the list of discoverers
	 * that this PrioritizedParameterNameDiscoverer checks.
	 */
	public void addDiscoverer(ParameterNameDiscoverer pnd) {
		this.parameterNameDiscoverers.add(pnd);
	}


	public String[] getParameterNames(Method method) {
		return null;
	}


	public String[] getParameterNames(Constructor<?> ctor) {
		return null;
	}

}
