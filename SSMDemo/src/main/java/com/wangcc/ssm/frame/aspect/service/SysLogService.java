package com.wangcc.ssm.frame.aspect.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangcc.ssm.frame.aspect.dao.SysLogDao;
import com.wangcc.ssm.frame.entity.SysLog;
import com.wangcc.test.SpringMybatisTest;

@Service
public class SysLogService {
	@Autowired
	private SysLogDao sysLogDao;
	public int deleteLog(String id) {
		return sysLogDao.deleteById(id);
	}
	public int insertLog(SysLog record) {
		return sysLogDao.insertById(record);
	}
	public SysLog getLog(String id) {
		return sysLogDao.selectById(id);
	}
}
