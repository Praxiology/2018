package org.springframework.util;


public class Assert {

	public static void notNull(Object object, String message) {
	}
	public static void isTrue(boolean expression, String message) {
		if (!expression) {
			throw new IllegalArgumentException(message);
		}
	}
	public static void state(boolean expression) {
		state(expression, "[Assertion failed] - this state invariant must be true");
	}
	
	public static void state(boolean expression, String message) {
		if (!expression) {
			throw new IllegalStateException(message);
		}
	}
	public static void hasText(String text, String message) {
		
	}
	
	public static void notNull(Object object) {
		notNull(object, "[Assertion failed] - this argument is required; it must not be null");
	}

}
