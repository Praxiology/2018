package com.step.work.spring;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.step.demo.spring.SayImplAroundAdvice;
import com.step.demo.spring.SayImplBeforeAdvice;
import com.step.demo.spring.User;
import com.step.demo.spring.UserDao;
import com.step.demo.spring.UserDaoInf;
import com.step.demo.spring.UserDaoInf2;

/**
 * 参考资料:
 *   (IOC详解):http://blog.csdn.net/qq418517226/article/details/51249117
 *   (AOP):http://blog.csdn.net/qq418517226/article/details/51282035
 * Spring如何工作的?
 * 1:spring如何解析*.XML文件,将其转换成Java文档对像?
 * 2:Spring将包含类信息的java文档对象转换成Spring内部的数据结构是什么样子的?
 * 3:Spring是如何构建管理各种类对象的?
 * 
 * 总结:
 * 1:核心的类:
 *   1:{@link org.springframework.beans.factory.support.DefaultListableBeanFactory}存放类信息
 *   2:{@link org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader}解析XML节点
 *   3:{@link org.springframework.beans.factory.config.BeanDefinitionHolder}
 *   4:{@link org.springframework.beans.factory.support.RootBeanDefinition}
 *   5:{@link org.springframework.beans.factory.support.GenericBeanDefinition}普通bean的保存
 *   6:{@link org.springframework.beans.factory.support.RootBeanDefinition}aop bean的保存
 *   7:{@link org.springframework.aop.framework.ProxyFactory}代理类的生成
 *   8:{@link org.springframework.aop.framework.DefaultAopProxyFactory}调用JDK或Cglib代理
 *   9:{@link org.springframework.aop.framework.ProxyConfig}代理类的顶层
 * **/
public class HowSpringWork {
	
private static String basepath = "com/step/demo/spring/config";
	
	private static String[] path = {basepath+"/app.xml"};
	
	private static String[] paths = {path[0],basepath+"/aopAr.xml"};
	
	@Test
	public void springInit() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(paths);
		
		//System.out.println(JSON.toJSONString(app.getInfors(0)));
		UserDaoInf usrDao =  app.getBean("usrDao",UserDaoInf.class);
		usrDao.syaHello(new User("jack"));
	}
	
	public void paresXml() {
		//com.sun.org.apache.xerces.internal.dom.DeferredElementNSImpl.;
		//DeferredElementNSImpl
	}
	
	/**
	 *以下种情况可以强转 
	 * **/
	//@Test
	public void TestProxyFactory() {
		ProxyFactory pfbf = new ProxyFactory();
		pfbf.setTarget(new UserDao());
		pfbf.addAdvice(new SayImplAroundAdvice());
		pfbf.addAdvice(new SayImplBeforeAdvice());
		
		//Object => UserDaoInf
		UserDaoInf usd =  (UserDaoInf) pfbf.getProxy();
		usd.syaHello(new User());
		
		//Object => UserDaoInf2
		UserDaoInf2 usd2 =  (UserDaoInf2) pfbf.getProxy();
		usd2.sayHi("uf1");
		
		//UserDaoInf => object => UserDaoInf2
		Object o1 = usd;
		UserDaoInf2 uf2 = (UserDaoInf2) o1;
		uf2.sayHi("uf2");
		
		//UserDaoInf => UserDaoInf2
		UserDaoInf2 uf3 = (UserDaoInf2) usd;
		uf3.sayHi("uf3");
	}
	

}
