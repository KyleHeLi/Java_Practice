package com.hl;

public class CaseConvertionTest {
	public static String camelToSnake(String origin) {
		StringBuilder stringBuilder = new StringBuilder();
		char[] strArray = origin.toCharArray();
		for (int i = 0; i < strArray.length; i++) {
			if (i != 0) {
				if (isLowerCase(strArray[i - 1]) && isUpperCase(strArray[i])) {
					stringBuilder.append("_");
				} else if (i != strArray.length - 1 && (isUpperCase(strArray[i - 1]) || isDigit(strArray[i - 1]))
						&& isUpperCase(strArray[i]) && isLowerCase(strArray[i + 1])) {
					stringBuilder.append("_");
				}
			}
			stringBuilder.append(strArray[i]);
		}
		return stringBuilder.toString();
	}

	public static String snakeToCamel(String origin) {
		StringBuilder stringBuilder = new StringBuilder();
		String[] strArray = origin.toLowerCase().split("_");
		for (int i = 0; i < strArray.length; i++) {
			String capitalizeOrNot = strArray[i];
			if (i != 0) {
				capitalizeOrNot = strArray[i].substring(0, 1).toUpperCase() + strArray[i].substring(1);
			}

			stringBuilder.append(capitalizeOrNot);
		}
		return stringBuilder.toString();
	}

	private static boolean isUpperCase(char c) {
		return (int) c >= 65 && (int) c <= 90;
	}

	private static boolean isLowerCase(char c) {
		return (int) c >= 97 && (int) c <= 122;
	}

	private static boolean isDigit(char c) {
		return (int) c >= 48 && (int) c <= 57;
	}

	public static void main(String[] args) {
		String test = "";
		System.out.println(camelToSnake(test));

		test = "a";
		System.out.println(camelToSnake(test));

		test = "ab";
		System.out.println(camelToSnake(test));

		test = "Ab";
		System.out.println(camelToSnake(test));

		test = "SAP";
		System.out.println(camelToSnake(test));

		test = "computerStatus";
		System.out.println(camelToSnake(test));
		System.out.println(snakeToCamel(camelToSnake(test)));

		test = "allSecurityModules";
		System.out.println(camelToSnake(test));
		System.out.println(snakeToCamel(camelToSnake(test)));

		test = "ESXSummary";
		System.out.println(camelToSnake(test));
		System.out.println(snakeToCamel(camelToSnake(test)));

		test = "ec2VirtualMachineSummary";
		System.out.println(camelToSnake(test));
		System.out.println(snakeToCamel(camelToSnake(test)));

		test = "ec32VirtualMachineSummary";
		System.out.println(camelToSnake(test));
		System.out.println(snakeToCamel(camelToSnake(test)));
	}
}
