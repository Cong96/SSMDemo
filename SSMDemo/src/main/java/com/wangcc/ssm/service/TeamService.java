package com.wangcc.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangcc.ssm.dao.TeamDao;
import com.wangcc.ssm.entity.Team;

@Service
public class TeamService {
	@Autowired
	private TeamDao teamDao;
	public void insertTeam(Team team) {
		teamDao.insertTeam(team);
	}
	public Team getTeamById(Integer id) {
		return teamDao.getTeamById(id);
	}
}
