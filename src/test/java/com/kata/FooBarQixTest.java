package com.kata;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FooBarQixTest {

	private FooBarQix fbq = null;

	@BeforeEach
	void setUp() throws Exception {
		fbq = new FooBarQix();
	}

	@Test
	void Number_gives_number() {
		assertTrue(fbq.compute("1").equals("1"));
		assertTrue(fbq.compute("2").equals("2"));
		assertTrue(fbq.compute("4").equals("4"));
		assertTrue(fbq.compute("8").equals("8"));
	}

	@Test
	void divideBy3_gives_Foo() {
		assertTrue(fbq.compute("6").equals("Foo"));
		assertTrue(fbq.compute("9").equals("Foo"));
		assertTrue(fbq.compute("12").equals("Foo"));
		assertTrue(fbq.compute("13").equals("Foo"));
	}

	@Test
	void divideByNumber_contains_Number() {
		assertTrue(fbq.compute("3").equals("FooFoo"));
		assertTrue(fbq.compute("5").equals("BarBar"));
		assertTrue(fbq.compute("7").equals("QixQix"));
	}

	@Test
	void divideBy5_gives_Bar() {
		assertTrue(fbq.compute("10").equals("Bar"));
		assertTrue(fbq.compute("20").equals("Bar"));
	}

	@Test
	void divideBy7_gives_Qix() {
		assertTrue(fbq.compute("14").equals("Qix"));
		assertTrue(fbq.compute("28").equals("Qix"));
	}

	@Test
	void divideBy3_and_5_contains_5_gives_FooBarBar() {
		assertTrue(fbq.compute("15").equals("FooBarBar"));
	}

	@Test
	void divideBy3_and_7_gives_FooQix() {
		assertTrue(fbq.compute("21").equals("FooQix"));
	}

	@Test
	void divideBy5_and_7_pluscontains_3_and_5_gives_BarQixFooBar() {
		assertTrue(fbq.compute("35").equals("BarQixFooBar"));
	}

	@Test
	void divideBy3_contains_2_3() {
		assertTrue(fbq.compute("33").equals("FooFooFoo"));
	}

}
