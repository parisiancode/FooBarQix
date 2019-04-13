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
		Integer nbr = Integer.parseInt(input);
		StringBuilder sb = new StringBuilder();
		for (Entry<Integer, String> entry : myMap.entrySet()) {
			if (nbr % entry.getKey() == 0)
				sb.append(entry.getValue());
		}
		input.codePoints().mapToObj(c -> String.valueOf((char) c)).forEach(this::analyzeInput);
		return StringUtils.isBlank(sb.toString()) ? nbr.toString() : sb.toString();
	}

	private String analyzeInput(String number) {
		int key = Integer.parseInt(number);
		if (myMap.containsKey(key))
			return myMap.get(key);
		return "";
	}
}
