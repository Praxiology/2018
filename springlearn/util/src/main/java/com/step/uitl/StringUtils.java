package com.step.uitl;

public class StringUtils {

	public static boolean isNotBlank(String formatStr) {
		if (null != formatStr) {
			formatStr = formatStr.replace(" ","").trim();
			if (0 == formatStr.length())
			return true;
		}
		return false;
	}

}
