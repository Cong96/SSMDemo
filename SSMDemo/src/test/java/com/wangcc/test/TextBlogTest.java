package com.wangcc.test;

public class TextBlogTest {
	@Test
	public void testException() {
		try {
			ClassLoader loader = this.getClass().getClassLoader();
		} catch (Exception e) {
			// TODO: handle exception
			throw new NoClassDefFoundError();
		}
	}
}
