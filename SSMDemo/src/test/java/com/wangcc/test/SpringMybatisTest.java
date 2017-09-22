package com.wangcc.test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.wangcc.ssm.dao.PlayerDao;
import com.wangcc.ssm.entity.Coach;
import com.wangcc.ssm.entity.Player;
import com.wangcc.ssm.entity.Team;
import com.wangcc.ssm.service.CoachService;
import com.wangcc.ssm.service.PlayerService;
import com.wangcc.ssm.service.TeamService;

//不支持junit4.4，需要更高版本的junit
//http://blog.csdn.net/zacry/article/details/37052973  http://blog.csdn.net/bruce128/article/details/9792283
@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:mybatis-spring.xml" })
public class SpringMybatisTest {
	private static Logger logger = Logger.getLogger(SpringMybatisTest.class);
	@Resource
	private PlayerService playerService = null;
	@Resource
	private CoachService coachService;
	@Resource
	private TeamService teamService;
	@Resource
	private PlayerDao playerDao;

	@Test
	public void test1() {
		Player player = new Player("ddd", 23, 34);
		playerService.insert(player);
		// System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
		logger.info(JSON.toJSONString(player));
	}

	@Test
	public void getListByDao() {
		System.out.println("First Time");
		long l1 = new Date().getTime();
		List<Player> players = playerDao.getPlayerList();
		long l2 = new Date().getTime();

		System.out.println("++++++++++++total time use: " + (l2 - l1));
		System.out.println("Second Time");
		long l3 = new Date().getTime();
		List<Player> players1 = playerDao.getPlayerList();
		long l4 = new Date().getTime();
		System.out.println("++++++++++++total time use: " + (l4 - l3));

		logger.info(JSON.toJSONString(players1));

	}

	@Test
	public void getList() {
		System.out.println("First Time");

		List<Player> players = playerService.getPlayerList();
		System.out.println("Second Time");
		logger.info(JSON.toJSONString(players));

		long l1 = new Date().getTime();
		List<Player> players1 = playerService.getPlayerList();
		long l2 = new Date().getTime();
		System.out.println("++++++++++++total time use: " + (l2 - l1));

		logger.info(JSON.toJSONString(players1));

	}

	@Test
	public void testGet() {
		Player player = playerService.selectById(24);
		if (player.getName() != null && player.getName().equals("")) {
			System.out.println("SUCCESS!");
		}
	}

	@Test
	public void testGetInt() {
		Player player = playerService.selectById(14);
		System.out.println(player.getAge());
	}

	@Test
	public void testOneToOne() {
		Coach coach = new Coach("phil jackson", 66, 11111.1f);
		coachService.insertCoach(coach);
		System.out.println(coach.getId());
		Team team = new Team("lakerss", "los angeles", 1112334.1f, coach);
		teamService.insertTeam(team);

	}

	@Test
	public void testGetOneToOne() {
		Team team = teamService.getTeamById(5);
		logger.info(JSON.toJSONString(team));

		Coach coach = team.getCoach();
		logger.info(JSON.toJSONString(coach));
	}

	@Test
	public void testInsertTeam() {
		Coach coach = new Coach("phil jackson1", 80, 11111.1f);
		coachService.insertCoach(coach);
		logger.info(JSON.toJSONString(coach));
		Team team = new Team("my lakerss1", "los angeles", 1112334.1f, coach);
		teamService.insertTeam(team);
		logger.info(JSON.toJSONString(team));
		Player player = new Player("kobe paul", 32, team.getId());
		playerService.insert(player);
		Player player1 = new Player("paul", 32, team.getId());
		playerService.insert(player1);

	}

	@Test
	public void testGetTeam() {
		Team team = teamService.getTeamById(7);
		logger.info(JSON.toJSONString(team));
		Coach coach = team.getCoach();
		logger.info(JSON.toJSONString(coach));
		List<Player> players = team.getPlayers();
		logger.info(JSON.toJSONString(players));
	}
}
