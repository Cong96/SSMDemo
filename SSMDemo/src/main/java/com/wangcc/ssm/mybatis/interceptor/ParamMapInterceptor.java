package com.wangcc.ssm.mybatis.interceptor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wangcc.ssm.mybatis.interceptor.entity.ComplexParamMap;
import com.wangcc.ssm.mybatis.interceptor.entity.ParamMap;
import com.wangcc.ssm.util.ReflectUtil;

@Intercepts(@Signature(method = "handleResultSets", type = ResultSetHandler.class, args = { Statement.class }))

public class ParamMapInterceptor implements Interceptor {
	private static Logger logger = LoggerFactory.getLogger(ParamMapInterceptor.class);

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		//
		Object target = invocation.getTarget();
		if (target instanceof DefaultResultSetHandler) {
			DefaultResultSetHandler resultSetHandler = (DefaultResultSetHandler) target;

			ParameterHandler parameterHandler = ReflectUtil.getFieldValue(resultSetHandler, "parameterHandler");
			Object parameterObj = parameterHandler.getParameterObject();
			if (parameterObj instanceof ComplexParamMap) {
				ComplexParamMap paramMap = (ComplexParamMap) parameterObj;
				Statement stmt = (Statement) invocation.getArgs()[0];

				return handleResultSet(stmt.getResultSet(), paramMap);

			}

		}
		return invocation.proceed();
	}

	private Object handleResultSet(ResultSet resultSet, ComplexParamMap cmap) {
		if (resultSet != null) {
			ParamMap paramMap = cmap.getParamMap();
			String keyField = paramMap.get(ParamMap.KEY_FIELD);
			String valueField = paramMap.get(ParamMap.VALUE_FIELD);
			Map<Object, Object> map = new HashMap<Object, Object>();
			// 因为原方法返回的是List<Object>类型，所以
			List<Object> resultList = new ArrayList<Object>();
			try {
				while (resultSet.next()) {
					Object key = resultSet.getObject(keyField);
					Object value = resultSet.getObject(valueField);
					map.put(key, value);
				}
			} catch (Exception e) {
				logger.error("ParamMapInterceptor 的Method handleResultSet 使用ResultSet时出错");
			} finally {
				closeResultSet(resultSet);

			}
			resultList.add(map);
			return resultList;
		}
		return null;
	}

	private void closeResultSet(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			logger.error("关闭ResultSet资源时出错");
		}
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}

}
