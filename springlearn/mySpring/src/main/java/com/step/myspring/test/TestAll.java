package com.step.myspring.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.step.myspring.beans.BeanDifiniton;
import com.step.myspring.beans.BeanFactory;

public class TestAll {
	
	@org.junit.Test
	public void TestBf() {
		BeanFactory bf = new BeanFactory();	
		Dog dg = (Dog)bf.getObject("dg");
		dg.name="hsq";
		dg.say();
	}
	
	//@Test
	public void TestBeanDifiniton(){
		List<BeanDifiniton> bds = new ArrayList<BeanDifiniton>();
		bds.add(getBd("gh",DogHua.class));
		bds.add(getBd("dg",Dog.class));
		ptList(bds,true);
	}
	
	public BeanDifiniton getBd(String alais,Class cls) {
		String classPath = cls.getName();
		Field[] fds = cls.getDeclaredFields();
		String[] dependes = new String[fds.length];
		for (int i = 0; i < fds.length; i++) {
			dependes[i] = fds[i].getName();
		}
		return new BeanDifiniton(alais,classPath,dependes);
	}
	
	//@Test
	public void TestBeanDifinitonP(){
		try {
			//String json = FileUtils.readFileToString(new File("app.json"));
			//System.out.println(json);
			//List<BeanDifiniton> bds = (List<BeanDifiniton>) JsonUtils.jsonToObj(json, List.class, BeanDifiniton.class);
			//ptList(bds,true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static <T> void ptList(List<T> list,boolean over){
		if (null != list) {
			for (Object o : list) {
				System.out.println(JSON.toJSONString(o));
			}
			String json = JSON.toJSONString(list);
			System.out.println(json);
			if (over){
				return;
			}
		///	List<BeanDifiniton> bds = (List<BeanDifiniton>) JsonUtils.jsonToObj(json, List.class, BeanDifiniton.class);
		//	ptList(bds,true);
		}
	}
	
	
	//
	//@Test
	public void TestMd() {
		DogHua gh = new DogHua();
		gh.setRoot("哈士奇");
		//Method[] mds = Dog.class.getDeclaredMethods();
		Dog d = new Dog("dog"); 
		Method[] mds2 = d.getClass().getMethods();
		for(Method md : mds2) {
			String mdName=md.getName();
			System.out.println(mdName);
			if (mdName.toLowerCase().equals("setgh")) {
				try {
					md.invoke(d, gh);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
