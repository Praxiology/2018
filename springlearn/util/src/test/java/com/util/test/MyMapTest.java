package com.util.test;

import org.junit.Test;

import com.step.uitl.PrintUtil;

public class MyMapTest {
	
	@Test
	public void testMp() {
		PrintUtil.putMap("jack1", "jack11").putMap("jack2", "jack22").putMap("jack3", "jack33").print();
	}

}
