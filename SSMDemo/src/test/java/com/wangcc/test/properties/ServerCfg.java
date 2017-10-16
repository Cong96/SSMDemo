package com.wangcc.test.properties;

import java.util.List;

import lombok.Data;

@Data
public class ServerCfg {
	private int port = 8005;
	private String shutDown = "SHUTDOWN";
	private List<ServiceCfg> services;
}
