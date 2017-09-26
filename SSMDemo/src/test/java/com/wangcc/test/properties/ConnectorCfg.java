package com.wangcc.test.properties;

import lombok.Data;

@Data
public class ConnectorCfg {
	private int port = 8080;
	private String protocol = "HTTP/1.1";
}
