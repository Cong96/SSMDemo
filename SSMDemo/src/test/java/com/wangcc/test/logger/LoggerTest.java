package com.wangcc.test.logger;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(LoggerTest.class);
		logger.info("hello {}", new Date());
	}
}