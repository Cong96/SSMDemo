package com.wangcc.test;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.wangcc.ssm.entity.Player;
import com.wangcc.ssm.service.PlayerService;
import com.wangcc.ssm.util.SpringUtil;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:mybatis-spring.xml" })
public class ReflectTest {
	private static Logger logger = Logger.getLogger(ReflectTest.class);

	@Test
	public void reflect() throws Exception {
		PlayerService playerService = (PlayerService) SpringUtil.getBean("playerService");
		// Class clazz =
		// this.getClass().getClassLoader().loadClass("com.wangcc.ssm.service.PlayerService");
		Class clazz = playerService.getClass();
		int i = 1;
		Method method = clazz.getDeclaredMethod("selectById", Integer.class);
		Object object = method.invoke(playerService, 1);
		Player player = (Player) object;
		logger.info(JSON.toJSONString(player));
	}
}
