package com.step.uitl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

import sun.misc.ProxyGenerator;

public class ClassUtil {
	
	
	public static void printObjClassInfo(Object obj) {
		Objects.requireNonNull(obj);
		
		
	}
	
	public static void getObjectInfoByClass(Object obj) {
		if (null != obj) {
			getObjectInfoByClass(obj.getClass());
		} else {
			System.out.println("target class is null");
		}
	}
	
	//反编译获得类源码
	public static void getObjectInfoByClass(Class<? extends Object> cls) {
		String proxyName = cls.getSimpleName();
		//proxyName=cls.getName();
		//proxyName="com.step.demo.spring."+proxyName;
		byte[] proxyClassFile = ProxyGenerator.generateProxyClass(proxyName,new Class[] {cls});
		FileOutputStream out = null;
		try {
			String path = "D:\\DEV\\worspace\\jdkClass\\";
			String filePath = path+proxyName;
			out = new FileOutputStream(filePath+".class");
			out.write(proxyClassFile);
			out.flush();
			System.out.println("fby:"+filePath+".class");
		}catch(Exception e){
			e.fillInStackTrace();
		}finally {
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
