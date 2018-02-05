package com.step.uitl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class PrintUtil {

	// public static int MAP_T = 0;
	/*public static Long nano = null;

	static {
		nano = System.nanoTime();
	};*/

	 //public static Object puLock = new Object();

	public static void printObjs(String name, Object... objs) {
		//synchronized (nano) {

			StringBuffer sb = new StringBuffer();
			int le = (null != objs) ? objs.length : 0;
			String reqNo = String.valueOf(Math.random());
			sb.append("[");
			sb.append(reqNo);
			sb.append(" ");
			sb.append(DateUtil.getTimeFormat());
			sb.append(":");
			sb.append(name);
			sb.append(" ");
			sb.append(le);
			sb.append("]");
			System.err.println(sb.toString());
			sb = new StringBuffer(reqNo);
			if (le > 0) {
				for (Object o : objs) {
					if (null != o) {
						if (!(o instanceof String)) {
							sb.append("\n  c:");
							sb.append(o.getClass().getName());
						}
						try {
							sb.append("\n  v:");
							sb.append(JSON.toJSONString(o));
						} catch (Exception ex) {
							sb.append("异常!");
						}
					}
				}
				System.out.println(sb.toString());
			}
		//}
	}

	/*public static Long getTimeBucket() {
		Long bucket = System.nanoTime() - nano;
		nano += bucket;
		return bucket;
	}*/

	public static String getTraceInfo() {
		StringBuffer sb = new StringBuffer();

		StackTraceElement[] stacks = new Throwable().getStackTrace();
		// int stacksLen = stacks.length;
		sb.append("class ").append(stacks[1].getClassName()).append(".").append(stacks[1].getMethodName()).append(":")
				.append(stacks[1].getLineNumber());
		return sb.toString();
	}

	public static String getLineInfo() {
		StackTraceElement ste = new Throwable().getStackTrace()[1];
		return ste.getFileName() + ": Line " + ste.getLineNumber();
	}

	public static void printObjs(String name, List<Object> objs) {
		/*
		 * System.out.println("["+DateUtil.getDateTimeFormat()+":"+name+"]"); if (null
		 * != objs) { objs.forEach(new Consumer<Object>() {
		 * 
		 * @Override public void accept(Object e) { if (e != null) {
		 * System.out.println("  " + e.getClass().getName()); try {
		 * System.out.println("  " + e.toString()); } catch (Exception ex) {
		 * System.out.println("异常!"); } }
		 * 
		 * } }); }
		 */
	}

	public static void printObjs(String name, int mapT, Map<String, Object> map) {
		/*
		 * System.out.println("["+DateUtil.getDateTimeFormat()+":"+name+"]"); if (null
		 * != map) { System.out.println(JSON.toJSON(map)); }
		 */
	}

	public static void printKV(String name, Object value) {
		/*
		 * String pv = null; String vClassName = null; if (null == value) { pv = ""; }
		 * else { vClassName = value.getClass().getName(); try { pv =
		 * JSON.toJSONString(value); } catch (Exception e) {
		 * System.out.println("异常!"+vClassName);
		 * System.out.println("value!"+value.toString()); } }
		 * 
		 * System.out.println("["+DateUtil.getDateTimeFormat()+":"+
		 * name+"]\n vClassName:"+vClassName+"\n"+pv);
		 */
	}

	public static <T> List<T> toList(T[] arr) {
		if (null == arr)
			return null;
		List<T> list = new ArrayList<T>(arr.length);
		for (T t : arr) {
			list.add(t);
		}
		return list;
	}

	public static MyMap putMap(String k, Object v) {
		MyMap mm = null;
		if (mm == null) {
			mm = new MyMap();
		}
		return mm.putMap(k, v);
	}

	public static class MyMap {
		Map<String, Object> map = new HashMap<String, Object>();

		public MyMap putMap(String k, Object v) {
			try {
				JSON.toJSONString(v);
			} catch (Exception e) {
				v = null;
			}
			map.put(k, v);
			return this;
		}

		public void print() {
			try {
				String j = toString();
				if (j.contains("usrDao")) {
					System.out.println(j);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public String toString() {
			return JSON.toJSONString(map);
		}
	}

}
