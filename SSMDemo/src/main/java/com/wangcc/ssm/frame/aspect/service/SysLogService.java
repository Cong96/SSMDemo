package com.wangcc.ssm.frame.aspect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangcc.ssm.frame.aspect.dao.SysLogDao;
import com.wangcc.ssm.frame.entity.SysLog;

@Service
public class SysLogService {
	@Autowired
	private SysLogDao sysLogDao;

	public int deleteLog(String id) {
		return sysLogDao.deleteById(id);
	}

	public int insertLog(SysLog record) {
		return sysLogDao.insertLog(record);
	}

	public SysLog getLog(String id) {
		return sysLogDao.selectById(id);
	}
}
