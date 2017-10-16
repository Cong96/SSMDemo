package com.wangcc.ssm.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	// mybatis相关配置路径
	private final static String config = "mybatis.xml";
	private static SqlSessionFactory sessionFactory = null;

	public static ThreadLocal<SqlSession> localsession = new ThreadLocal<SqlSession>();
	static {
		try {
			// Reader reader = Resources.getResourceAsReader(config);
			// sessionFactory=new SqlSessionFactoryBuilder().build(reader);
			InputStream in = MybatisUtil.class.getClassLoader().getResourceAsStream(config);
			sessionFactory = new SqlSessionFactoryBuilder().build(in);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	public static SqlSession getSession() {
		return sessionFactory.openSession();
	}

	public static SqlSession getCurrentSession() {
		SqlSession session = localsession.get();
		if (session == null) {
			session = getSession();
			localsession.set(session);
		}
		return session;
	}
}
