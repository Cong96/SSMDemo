package com.wangcc.ssm.dao;

import org.springframework.stereotype.Repository;

import com.wangcc.ssm.entity.Player;

public interface PlayerDao {
	//	public void updatePlayerById();
	
		public void insertPlayer(Player player);
		public Player selectById(Integer id);
}
