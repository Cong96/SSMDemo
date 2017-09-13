package com.wangcc.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangcc.ssm.dao.CoachDao;
import com.wangcc.ssm.entity.Coach;

@Service
public class CoachService {
	@Autowired
	private CoachDao coachDao;
	public Integer insertCoach(Coach coach) {
			return coachDao.insertCoach(coach);
	}	

}
