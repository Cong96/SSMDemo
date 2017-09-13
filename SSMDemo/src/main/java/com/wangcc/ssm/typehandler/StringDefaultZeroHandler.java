package com.wangcc.ssm.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class StringDefaultZeroHandler implements TypeHandler<String>
{

	@Override
	public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return (rs.getString(columnName) == null)
				 ? "0": rs.getString(columnName); 
	}

	@Override
	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return (rs.getString(columnIndex) == null)
				 ? "0": rs.getString(columnIndex);
	}

	@Override
	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return (cs.getString(columnIndex) == null)
				 ? "0": cs.getString(columnIndex);
	}

}
