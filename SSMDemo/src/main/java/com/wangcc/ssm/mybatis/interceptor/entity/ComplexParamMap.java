package com.wangcc.ssm.mybatis.interceptor.entity;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * @ClassName: ComplexParamMap
 * @Description: Question:到底是怎样映射的，映射能力如此强，还需要好好看源码
 * @author wangcc
 * @date 2017年10月14日 下午8:45:41
 * 
 * @param <T>
 */
@Data
public class ComplexParamMap<T> {
	private ParamMap paramMap;
	private T obj;// 使用实体类的属性作为查询参数
	private Map<String, Object> params = new HashMap<String, Object>();// 其他的参数我们把它分装成一个Map对象
}
