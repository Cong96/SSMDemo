package com.wangcc.ssm.dao;

import com.wangcc.ssm.entity.Team;

public interface TeamDao {
	public Team getTeamById(Integer id);
	public void insertTeam(Team team);
}
