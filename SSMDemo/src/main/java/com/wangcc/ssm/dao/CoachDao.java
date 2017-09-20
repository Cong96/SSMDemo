package com.wangcc.ssm.dao;

import com.wangcc.ssm.entity.Coach;

public interface CoachDao {
	public Coach getCoachById(Integer id);

	public Integer insertCoach(Coach coach);

}
