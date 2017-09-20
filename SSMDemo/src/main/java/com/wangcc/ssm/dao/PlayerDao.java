package com.wangcc.ssm.dao;

import java.util.List;

import com.googlecode.ehcache.annotations.Cacheable;
import com.wangcc.ssm.entity.Player;

public interface PlayerDao {
	// public void updatePlayerById();
	@Cacheable(cacheName = "userCache")

	public List<Player> getPlayerList();

	public void insertPlayer(Player player);

	public Player selectById(Integer id);
}
