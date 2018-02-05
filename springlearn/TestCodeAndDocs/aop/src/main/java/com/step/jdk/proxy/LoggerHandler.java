package com.step.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class LoggerHandler implements InvocationHandler {
	
	private Object target;
	
	public LoggerHandler(Object target){
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		befor(args);
		Object result = method.invoke(target, args);
		after(result);
		return result;
	}
	
	public void befor(Object[] params) {
		List<Object> list = Arrays.asList(params);
		list.forEach(e->System.out.println("params:"+e));
	}
	
	public void after(Object result) {
		System.out.println("i am after! and result is "+result);
	}

}
