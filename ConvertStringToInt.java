package com.mub.main;
/**
 * Class to parse string to int
 * Created by @author Mubarak Hussain.
 */
public class ConvertStringToInt {

	public static int strToInt(String str) {
		int i = 0;
		int num = 0;
		boolean isNeg = false;

		if (str == null) {
			throw new NumberFormatException("Expected String is null");
		}

		// Check for negative sign and set isNeg flag
		if (str.charAt(0) == '-') {
			isNeg = true;
			i = 1;
		}

		// Process each character of the string;
		while (i < str.length()) {
			if (Character.isDigit(str.charAt(i))) {
				num *= 10;
				num += str.charAt(i++) - '0';
			} else {
				throw new NumberFormatException("String is not a valid");
			}
		}

		if (isNeg)
			num = -num;
		return num;
	}
}
