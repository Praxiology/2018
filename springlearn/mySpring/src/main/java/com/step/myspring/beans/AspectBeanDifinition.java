package com.step.myspring.beans;

public class AspectBeanDifinition extends BeanDifiniton {
	
	public static int BF = 1;

	public static int AF = 2;
	
	public static int AR = 3;
	
	public static int EX = 4;
	
	private static final long serialVersionUID = 1L;
	
	String targetMethldMatch;
	
	int aspectType;

	public String getTargetMethldMatch() {
		return targetMethldMatch;
	}

	public void setTargetMethldMatch(String targetMethldMatch) {
		this.targetMethldMatch = targetMethldMatch;
	}

	public int getAspectType() {
		return aspectType;
	}

	public void setAspectType(int aspectType) {
		this.aspectType = aspectType;
	}
}
