package com.wangcc.test.jndi;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.Test;

public class JNDITset {
	@Test
	public void testJNDI() throws NamingException, SQLException {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/oracle");
		Connection conn = ds.getConnection();
		System.out.println(conn.isClosed());

	}
}
