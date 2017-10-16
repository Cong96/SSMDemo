package com.wangcc.ssm.mybatis.interceptor.entity;

import java.util.HashMap;

public class ParamMap extends HashMap<String, String> {

	/**
	 * 作为Key的字段对应MapParam的Key
	 */
	public static final String KEY_FIELD = "mapKeyField";
	/**
	 * 作为Value的字段对应MapParam的Key
	 */
	public static final String VALUE_FIELD = "mapValueField";

	public ParamMap() {

	}

	/**
	 * 指定keyField和valueField
	 * 
	 * @param keyField
	 *            Map中key对应的字段
	 * @param valueField
	 *            Map中value对应的字段
	 */
	public ParamMap(String keyField, String valueField) {
		this.put(KEY_FIELD, keyField);
		this.put(VALUE_FIELD, valueField);
	}
}
