package com.kata;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.platform.commons.util.StringUtils;

public class FooBarQix {

	Map<Integer, String> myMap = createMap();

	private static Map<Integer, String> createMap() {
		Map<Integer, String> myMap = new HashMap<>();
		myMap.put(3, "Foo");
		myMap.put(5, "Bar");
		myMap.put(7, "Qix");
		return myMap;
	}

	public String compute(String input) {
		StringBuilder sb = new StringBuilder();
		divideNumbers(Integer.parseInt(input), sb);
		input.codePoints().mapToObj(c -> String.valueOf((char) c))
				.forEach(x -> containsNumbers(Integer.parseInt(x), sb));
		return StringUtils.isBlank(sb.toString()) ? input.replaceAll("0", "*") : sb.toString();
	}

	private void divideNumbers(Integer number, StringBuilder sb) {
		for (Entry<Integer, String> entry : myMap.entrySet()) {
			if (number % entry.getKey() == 0)
				sb.append(entry.getValue());
		}
	}

	private void containsNumbers(Integer number, StringBuilder sb) {
		for (Entry<Integer, String> entry : myMap.entrySet()) {
			if (number == entry.getKey())
				sb.append(entry.getValue());
			else if (number == 0 && sb.length() > 0) {
				sb.append("*");
				break;
			}
		}
	}
}
