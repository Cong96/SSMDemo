package com.wangcc.test.util;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import frame.util.map.ConfigRegister;
import frame.util.map.PropConfiger;
import frame.util.map.XmlParseConfiger;

public class XMlTest {
	private static Logger logger = LoggerFactory.getLogger(XMlTest.class);

	@Test
	public void test() {
		XmlParseConfiger xml = new XmlParseConfiger("config/ConfigMap.xml");
		List<Object> list = xml.getListValue("props.prop");
		List<String> strs = (List<String>) (List) list;
		for (String str : strs) {
			System.out.println(str);
		}
		logger.info(JSON.toJSONString(strs));
	}

	@Test
	public void testConfig() {
		PropConfiger prop = (PropConfiger) ConfigRegister.getValue("PDF.properties");
		String[] values = prop.getArrayValue("14062.pdf");
		logger.info(JSON.toJSONString(values));

	}

	@Test
	public void testStr() {
		String str = "config/PDF.properties";
		System.out.println(str.indexOf("/"));
		System.out.println(str.substring(str.lastIndexOf("/") + 1));
		System.out.println(str);
	}
}
