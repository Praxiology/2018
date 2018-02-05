package com.step.myspring.beans;

import java.io.Serializable;

public class BeanDifiniton implements Serializable {
	
	private static final long serialVersionUID = 1L;

	String alias="rootObject";
	
	String classPath="java.lang.Object";
	
	String[] dependsOnAlias = null;
	
	

	public BeanDifiniton() {
	}

	public BeanDifiniton(String alias, String classPath, String[] dependsOnAlias) {
		this.alias = alias;
		this.classPath = classPath;
		this.dependsOnAlias = dependsOnAlias;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	public String[] getDependsOnAlias() {
		return dependsOnAlias;
	}

	public void setDependsOnAlias(String[] dependsOnAlias) {
		this.dependsOnAlias = dependsOnAlias;
	}
	
}
