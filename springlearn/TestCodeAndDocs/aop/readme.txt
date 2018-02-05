高手的Spring解读
http://www.cnblogs.com/leiOOlei/p/3613352.html
https://www.cnblogs.com/xrq730/p/6753160.html

1:spring框架中常用的类以及关系
AbstractBeanDefinitionReader							   
	XmlBeanDefinitionReader	(org.springframework.beans.factory.xml)
	DefaultBeanDefinitionDocumentReader
	
	
Object
SimpleAliasRegistry
	DefaultSingletonBeanRegistry
		FactoryBeanRegistrySupport
			AbstractBeanFactory
				AbstractAutowireCapableBeanFactory
					DefaultListableBeanFactory(有很多属性)



Object
	DefaultResourceLoader
		AbstractApplicationContext
			AbstractApplicationContext(有一些属性)
				AbstractRefreshableApplicationContext(有一些属性)
					AbstractRefreshableConfigApplicationContext(有一些属性)
						  AbstractXmlApplicationContext
							   ClassPathXmlApplicationContext
							   
							   
BeanDefinition
AttributeAccessorSupport
	BeanMetadataAttributeAccessor
		AbstractBeanDefinition
			RootBeanDefinition(org.springframework.beans.factory.support),有很多属性	
				ConfigurationClassBeanDefinition

				
ProxyFactory	
DefaultAopProxyFactory
AopProxyFactory
JdkDynamicAopProxy(org.springframework.aop.framework:有很多属性)
ObjenesisCglibAopProxy -->CglibAopProxy(org.springframework.aop.framework;有很多属性)

AdvisedSupport
AbstractAspectJAdvice(很多属性)

