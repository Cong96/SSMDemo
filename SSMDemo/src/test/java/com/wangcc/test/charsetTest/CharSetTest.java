package com.wangcc.test.charsetTest;

import org.junit.Test;

public class CharSetTest {
	@Test
	public void test() {
		StringBuilder b = new StringBuilder();
		for (char c = 'a'; c < 'd'; c++) {
			b.append(c);
		}
		b.append("\u00a5"); // 日语符号Yen
		b.append("\u01FC"); // 带有强重音的罗马AE
		b.append("\u0391"); // 希腊字母：大写的α
		b.append("\u03A9"); // 希腊字母：Ω
		for (int i = 0; i < b.length(); i++) {
			System.out.printf("Character #%d is %c%n", i, b.charAt(i));
		}
		System.out.println(b.toString());
	}
}
