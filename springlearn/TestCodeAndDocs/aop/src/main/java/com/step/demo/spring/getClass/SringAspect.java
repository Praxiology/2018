package com.step.demo.spring.getClass;

import java.util.Arrays;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SringAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		/** 前置处理入参 **/
		befor(invocation.getArguments());
		/** 最关键的一步 **/
		Object result = invocation.proceed();
		return result;
	}
	
	public void befor(Object[] params) {
		List<Object> list = Arrays.asList(params);
		list.forEach(e->System.out.println("params:"+e));
	}
	
	

}
