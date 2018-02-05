package com.step.demo.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class UserAspect {

	public void excuteBefor(JoinPoint jp) {

		System.out.println("i am bf methd!" + jp.getTarget());

	}

	public void excuteAfter(JoinPoint jp) {

		System.out.println("i am af methd!" + jp.getTarget());

	}

	public void excuteAround(ProceedingJoinPoint pjp) {

		System.out.println("i am ar methd bf!" + pjp.getTarget());
		try {
			Object result = pjp.proceed();
			System.out.println("ar result :" +result);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("i am ar methd af!" + pjp.getTarget());

	}

}
