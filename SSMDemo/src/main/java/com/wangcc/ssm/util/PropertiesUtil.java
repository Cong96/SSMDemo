package com.wangcc.ssm.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class PropertiesUtil {
	private static ClassLoaderWrapper loader = ClassLoaderWrapper.getInstance();
	private static final String DEFAULT_RESOURCE = "";
	private static ConcurrentHashMap<String, Properties> propertiesMap = new ConcurrentHashMap<String, Properties>();

	private PropertiesUtil() {
		// 公用类
		throw new IllegalStateException("Utility class");
	}

	public static Object getValue(String key) throws IOException {
		Object value = getValue(DEFAULT_RESOURCE, key);
		return value;
	}

	public static Object getValue(String resource, String key) throws IOException {
		//
		Properties properties = getProperties(resource);
		Object value = properties.get(key);
		return value;
	}

	private static Properties getProperties(String resource) throws IOException {

		if (!propertiesMap.contains(resource)) {
			InputStream in = null;
			Properties prop = new Properties();

			in = loader.loadResource(resource);
			prop.load(in);
			propertiesMap.put(resource, prop);

		}
		Properties properties = propertiesMap.get(resource);
		return properties;
	}
}
