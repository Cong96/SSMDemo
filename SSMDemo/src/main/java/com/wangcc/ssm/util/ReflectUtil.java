package com.wangcc.ssm.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectUtil {
	private static Logger logger = LoggerFactory.getLogger(ReflectUtil.class);

	private static <T> T getFieldValueByPD(Object obj, String key) throws Exception {
		Class<?> clazz = obj.getClass();
		PropertyDescriptor pd = new PropertyDescriptor(key, clazz);
		Method readMethod = pd.getReadMethod();
		return (T) readMethod.invoke(obj);
	}

	private static void setFieldValueByPD(Object obj, String fieldName, Object fieldValue) throws Exception {
		Class<?> clazz = obj.getClass();
		//         符合JavaBean规范的属性访问器
		PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);
		Method writerMethod = pd.getWriteMethod();
		writerMethod.invoke(obj, fieldValue);

	}

	public static <T> T getFieldValue(Object entity, String key) throws Exception {

		String[] keyArray = key.split(",");
		Class clazz = entity.getClass();

		Field field = null;
		Object obj = entity;
		for (int i = 0; i < keyArray.length; i++) {
			if (i > 0) {
				clazz = field.getType();
			}
			field = getField(clazz, keyArray[i]);

			field.setAccessible(true);

			obj = field.get(obj);
		}
		return (T) obj;
	}

	public static Field getField(Class clazz, String fieldName) {
		Field field = null;
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				field = clazz.getDeclaredField(fieldName);
				break;
			} catch (Exception e) {
				//
			}
		}
		return field;
	}

	public static void setFieldValue(Object entity, String fieldName, Object fieldValue) throws Exception {
		String[] keyArray = fieldName.split(",");
		Class clazz = entity.getClass();

		Field field = null;
		Object obj = entity;
		for (int i = 0; i < keyArray.length; i++) {
			if (i > 0) {
				clazz = field.getType();
			}
			field = getField(clazz, keyArray[i]);

			field.setAccessible(true);
			if (i < keyArray.length - 1) {
				obj = field.get(obj);
			}

		}
		field.set(obj, fieldValue);

	}

}
