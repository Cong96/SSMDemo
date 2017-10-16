package com.wangcc.test.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:mybatis-spring.xml" })
public class TestConfig {
	private static Logger logger = LoggerFactory.getLogger(TestConfig.class);
	@Autowired
	ServerCfg cfg;

	@Test
	public void testJSON() {
		ServiceCfg scf = cfg.getServices().get(0);
		// System.out.println(scf.toString());
		logger.info(JSON.toJSONString(scf));
		logger.info(JSON.toJSONString(cfg));

		// System.out.println(cfg.toString());

	}
}
