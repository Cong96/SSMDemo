package com.wangcc.ssm.typehandler;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class BigDecimalTypeHandler implements TypeHandler<BigDecimal> {

	@Override
	public void setParameter(PreparedStatement ps, int i, BigDecimal parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BigDecimal getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return (rs.getBigDecimal(columnName)==null)? new BigDecimal("0"):rs.getBigDecimal(columnName);
		
	}

	@Override
	public BigDecimal getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return (rs.getBigDecimal(columnIndex)==null)? new BigDecimal("0"):rs.getBigDecimal(columnIndex);

	}

	@Override
	public BigDecimal getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return (cs.getBigDecimal(columnIndex)==null)? new BigDecimal("0"):cs.getBigDecimal(columnIndex);

	}

}
