package com.wangcc.test;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();
		double result = calculator.add(10, 50);
		Assert.assertEquals(60, result, 0);
	}
}
