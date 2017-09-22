package com.wangcc.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.googlecode.ehcache.annotations.When;
import com.wangcc.ssm.dao.PlayerDao;
import com.wangcc.ssm.entity.Player;
import com.wangcc.ssm.frame.aspect.annotation.MyLog;

@Service("playerService")
public class PlayerService {
	@Autowired
	private PlayerDao playerDao;

	// @TriggersRemove(cacheName = "userCache", when = When.AFTER_METHOD_INVOCATION,
	// removeAll = true)
	// @TriggersRemove(cacheName = "userCache", removeAll = true)

	@TriggersRemove(cacheName = "userCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void insert(Player player) {
		playerDao.insertPlayer(player);
	}

	@TriggersRemove(cacheName = "userCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)

	public Player selectById(Integer id) {
		return playerDao.selectById(id);
	}

	@MyLog(operationType = "²éÑ¯²Ù×÷", operationName = "²éÑ¯Player")
	@Cacheable(cacheName = "userCache")
	public List<Player> getPlayerList() {

		List<Player> players = playerDao.getPlayerList();

		return players;
	}
}
