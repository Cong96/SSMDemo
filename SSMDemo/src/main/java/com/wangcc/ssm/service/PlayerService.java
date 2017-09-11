package com.wangcc.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangcc.ssm.dao.PlayerDao;
import com.wangcc.ssm.entity.Player;

@Service("playerService")
public class PlayerService {
	@Autowired
	private PlayerDao playerDao;
	public void insert(Player player) {
		playerDao.insertPlayer(player);
	}
	public Player selectById(Integer id) {
		return playerDao.selectById(id);
	}
	
}
