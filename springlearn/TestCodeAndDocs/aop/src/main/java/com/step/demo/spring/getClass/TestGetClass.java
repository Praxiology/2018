package com.step.demo.spring.getClass;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

import com.step.uitl.ClassUtil;

public class TestGetClass {
	
	//@Test
	public void TestSimple() {
		
		Simple si = new Simple();
		//SringAspect sa =new SringAspect();
		ClassUtil.getObjectInfoByClass(si);
		//ClassUtil.getObjectInfoByClass(sa.getClass());
		ProxyFactory pf = new ProxyFactory(si);
		//pf.addAdvice(sa);
		Simple sip = (Simple)pf.getProxy();
		ClassUtil.getObjectInfoByClass(sip);
	}
	
	@Test
	public void TestSimpleAop() {
		SimpleAop sa = new SimpleAop();
		ClassUtil.getObjectInfoByClass(sa);
		ProxyFactory pf = new ProxyFactory(sa);
		pf.addAdvice(new SringAspect());
		SimpleAop sap = (SimpleAop)pf.getProxy();
		sap.hello();
		ClassUtil.getObjectInfoByClass(sap);
	}

}
