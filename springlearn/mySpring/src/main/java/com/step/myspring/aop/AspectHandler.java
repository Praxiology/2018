package com.step.myspring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class AspectHandler implements InvocationHandler {
	
	List<AspectBean> chains;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (null != chains) {
			
		}
		return null;
	}

	public List<AspectBean> getChains() {
		return chains;
	}

	public void setChains(List<AspectBean> chains) {
		this.chains = chains;
	}

}
