package com.wangcc.ssm.frame.aspect.dao;

import com.wangcc.ssm.frame.entity.SysLog;

public interface SysLogDao {
	public int insertLog(SysLog record);

	public SysLog selectById(String id);

	public int deleteById(String id);
}
