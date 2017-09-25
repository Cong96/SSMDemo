package com.wangcc.test.util;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import frame.util.map.MyPDFMap;

public class PropTest {
	@Test
	public void test() {
		// Map<String, List<String>> map = new PdfMap().getMap();
		Map<String, List<String>> map = MyPDFMap.getMap();
		System.out.println(JSON.toJSONString(map));
	}
}
