package com.step.jdk.proxy;

public class XxDaos implements Dao {
	@Override
	public Object handleDb(Object user) {
		System.out.println("save user!");
		return "Dao_SUC";

	}
}

class XxContoller implements Controller {

	@Override
	public String checkLogin(Object info) {
		System.out.println("try login..!");
		return "Contoller_SUC";
	}

}

interface Dao {

	Object handleDb(Object user);

}

interface Controller {

	String checkLogin(Object info);

}

// cglib代理
class CglibProxyBean {
	
	public void sayHello() {
		System.out.println("CGLIBUserServiceImpl的sayHello方法被调用！");
	}

	public void sayBye() {
		System.out.println("CGLIBUserServiceImpl的sayBye方法被调用！");
	}
}
