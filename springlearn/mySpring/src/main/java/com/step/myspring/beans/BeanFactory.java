package com.step.myspring.beans;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.step.myspring.test.Dog;
import com.step.myspring.test.DogHua;

public class BeanFactory {
	
	Map<String, BeanDifiniton> bds = null;
	
	private void init() {
		String[] alais= {"dg","gh"};
		Class[] clss= {Dog.class,DogHua.class};
		bds = toBds(alais,clss);
	}


	Map<String, Object> bfs = new HashMap<String, Object>();

	public Object getObject(String alias) {
		init();
		Object target = createBeanByAlais(alias);
		bfs.put(alias, target);
		return target;
	}


	public Object createBeanByAlais(String alais) {
		Object target = null;
		if ("root".equals(alais)) {
			return "over";
		}
		target = bfs.get(alais);
		if (null != target) {
			return target;
		}
		BeanDifiniton bd = bds.get(alais);
		if (null != bd) {
			try {
				target = Class.forName(bd.getClassPath()).newInstance();
				handleDepends(target,bd.getDependsOnAlias());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return target;
	}

	public void handleDepends(Object target,String[] depends) {
		if (null != depends && depends.length > 0) {
			Object bean = null;
			for (String dpAlais : depends) {
				bean = createBeanByAlais(dpAlais);
				if (null != bean) {
					bfs.put(dpAlais, bean);
					objSetProperties(target,bean,dpAlais);
				}
			}
		}
	}
	
	public void objSetProperties(Object target,Object dp,String dpAlais) {
		if (null != target) {
			Class cls = target.getClass();
			Method[] mds = cls.getDeclaredMethods();
			for(Method md : mds) {
				String name = md.getName();
				if (setMdEq(name,dpAlais,"set")) {
					try {
						md.invoke(target, dp);
						return;
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
	
	public static boolean setMdEq(String a,String b,String pre) {
		if (null != a && null !=b) {
			a = a.toLowerCase();
			b = pre + b.toLowerCase();
			return a.equals(b);
		}
		return false;
	}
	
	public static Map<String,BeanDifiniton> toBds(String[] alsis,Class[] clss){
		Map<String,BeanDifiniton> map = new HashMap<String,BeanDifiniton>();
		for (int i = 0; i < alsis.length; i++) {
			map.put(alsis[i], getBd(alsis[i],clss[i]));
		}
		return map;
	}
	
	public static BeanDifiniton getBd(String alais,Class cls) {
		String classPath = cls.getName();
		Field[] fds = cls.getDeclaredFields();
		String[] dependes = new String[fds.length];
		for (int i = 0; i < fds.length; i++) {
			dependes[i] = fds[i].getName();
		}
		return new BeanDifiniton(alais,classPath,dependes);
	}

}
