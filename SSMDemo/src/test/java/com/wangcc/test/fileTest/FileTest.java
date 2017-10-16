package com.wangcc.test.fileTest;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

import org.junit.Test;

public class FileTest {
	@Test
	public void test() throws Exception {
		InputStream in = new FileInputStream("/ulic/partdev/epolicy/bjca/images/sign.gif");
		Reader reader = new FileReader("/ulic/partdev/epolicy/bjca/images/sign.gif");
	}
}
