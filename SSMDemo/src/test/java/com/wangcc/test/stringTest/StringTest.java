package com.wangcc.test.stringTest;

import org.junit.Test;

public class StringTest {
	@Test
	public void testSubString() {
		String str = "com.ulic.gpolicyutils.pdf.EpolicyPdfTemplateHandler";
		// substring 首先String中的方法都会返回一个新的String对象,所以在一行代码中多次直接使用String的方法是没有关系的
		// substring方法，
		// 返回一个新字符串，它是此字符串的一个子字符串。该子字符串从指定的 beginIndex 处开始，直到索引 endIndex - 1
		// 处的字符。因此，该子字符串的长度为 endIndex-beginIndex。
		String beanName = str.substring(str.lastIndexOf(".") + 1, str.length());
		System.out.println(beanName);
	}
}
