package com.wangcc.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.wangcc.ssm.entity.Player;
import com.wangcc.ssm.service.PlayerService;
//不支持junit4.4，需要更高版本的junit
//http://blog.csdn.net/zacry/article/details/37052973  http://blog.csdn.net/bruce128/article/details/9792283
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:mybatis-spring.xml"})  
public class SpringMybatisTest {
	 private static Logger logger = Logger.getLogger(SpringMybatisTest.class);  
	    @Resource  
	    private PlayerService playerService = null;  
	    @Test  
	    public void test1() {  
		    Player player=new Player("JAMdES",13,33);
		    playerService.insert(player);
	        // System.out.println(user.getUserName());  
	        // logger.info("值："+user.getUserName());  
	        logger.info(JSON.toJSONString(player));  
	    }  

}
