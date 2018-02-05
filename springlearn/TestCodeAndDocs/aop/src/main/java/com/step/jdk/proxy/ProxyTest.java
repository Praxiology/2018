package com.step.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.junit.Test;

/**
 * JDK动态代理
 * Cglib代理
 * **/
public class ProxyTest {
	
	//@Test
	public void TestJdkProxy() {
		XxDaos target1 = new XxDaos();
		XxContoller target2 = new XxContoller();
		InvocationHandler hd1 = new LoggerHandler(target1);
		InvocationHandler hd2 = new LoggerHandler(target2);
		Dao da = JdkProxy(target1.getClass(),hd1);
		da.handleDb("user");
		Controller cl = JdkProxy(target2.getClass(),hd2);
		cl.checkLogin("jack|123");
	}
	
	public <T> T JdkProxy(Class<? extends T> tc,InvocationHandler hd) {
		T proxy = (T)Proxy.newProxyInstance(tc.getClassLoader(),tc.getInterfaces(), hd);
		return proxy;
	}
	
	
	
	//cglib代理测试
	@Test
	public void cglibTest() {
		CglibProxyBean cb = CglibPrxy(CglibProxyBean.class);
		cb.sayBye();
		//cb.sayHello();
	}
	
	public <T> T CglibPrxy(Class<? extends T> c) {
		CGLIBProxy cbp = new CGLIBProxy();
		T co = (T)cbp.getProxy(c);
		return co;
	}
	

}
