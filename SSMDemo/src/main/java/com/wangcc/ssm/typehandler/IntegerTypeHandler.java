package com.wangcc.ssm.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class IntegerTypeHandler implements TypeHandler<Integer>{

	@Override
	public void setParameter(PreparedStatement ps, int i, Integer parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		if(rs.getObject(columnName)!=null) {
			return rs.getInt(columnName);
			
		}
		return -1;
	}

	@Override
	public Integer getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		if(rs.getObject(columnIndex)!=null) {
			return rs.getInt(columnIndex);
			
		}
		return -1;
	}

	@Override
	public Integer getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		if(cs.getObject(columnIndex)!=null) {
			return cs.getInt(columnIndex);
			
		}
		return -1;
	}

}
