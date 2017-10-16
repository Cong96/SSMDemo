package com.wangcc.test.properties;

import java.util.List;

import lombok.Data;

@Data
public class ServiceCfg {
	private String name;
	private List<ConnectorCfg> connectors;
}
