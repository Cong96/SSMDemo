package com.wangcc.ssm.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericsUtil {
	/**
	 *
	 * 
	 * @param clazz
	 * @return Class
	 */
	@SuppressWarnings("unchecked")
	public static Class getGenericType(Class clazz) {
		Type genType = clazz.getGenericSuperclass();
		Type[] types = ((ParameterizedType) genType).getActualTypeArguments();
		if (!(types[0] instanceof Class)) {
			return Object.class;
		}
		return (Class) types[0];
	}

	/**
	 * ��ȡ�����������
	 * 
	 * @param clazz
	 * @return ������
	 */
	@SuppressWarnings("unchecked")
	public static String getGenericName(Class clazz) {
		return clazz.getSimpleName();
	}
}
