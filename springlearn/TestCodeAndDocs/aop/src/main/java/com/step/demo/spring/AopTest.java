package com.step.demo.spring;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.step.uitl.ClassUtil;

public class AopTest {
	
	private static String basepath = "com/step/demo/spring/config";
	
	private static String[] path = {basepath+"/app.xml"};
	
	private static String[] paths = {path[0],basepath+"/aopAr.xml"};
	
	@Test
	public void testIoc() {
		ApplicationContext app = new ClassPathXmlApplicationContext(path);
		//app.getBean("");
		UserDaoInf usrDao =  app.getBean("usrDao",UserDaoInf.class);
		usrDao.syaHello(new User("jack"));
		//ClassUtil.getObjectInfoByClass(usrDao);
	}
	
	//@Test
	public void testAop() {
		ApplicationContext app = new ClassPathXmlApplicationContext(paths);
		UserDaoInf usrDao =  app.getBean("usrDao",UserDaoInf.class);
		//usrDao.syaHello(new User("jack"));
		Class<? extends Object> cls = usrDao.getClass();
		String objectName = Object.class.getName();
		String suClassName = null; 
		while (null != cls && !objectName.equals(suClassName)) {
			ClassUtil.getObjectInfoByClass(cls);
			cls = cls.getSuperclass();
			suClassName = cls.getName();
			System.out.println(objectName+":"+suClassName);
		}
	}
	
	/**
	 * ProxyFactory 
	 * ***/
	//@Test
	public void TestProxyFactory() {
		ProxyFactory pfbf = new ProxyFactory();
		pfbf.setTarget(new UserDao());
		pfbf.addAdvice(new SayImplBeforeAdvice());
		UserDaoInf ud = (UserDaoInf) pfbf.getProxy();
		ud.syaHello(new User());
		ProxyFactory pfar = new ProxyFactory();
		pfar.setTarget(ud);
		pfar.addAdvice(new SayImplAroundAdvice());
		UserDaoInf udend = (UserDaoInf) pfar.getProxy();
		udend.syaHello(new User());
	}

}
