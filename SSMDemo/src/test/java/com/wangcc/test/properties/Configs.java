package com.wangcc.test.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSON;

@Configuration
public class Configs {
	@Value("classpath:config/server.json")

	File serverCfgjson;

	@Bean
	ServerCfg getServerCfg() throws IOException {
		// fastjson读取本地json配置文件
		InputStream inputStream = new FileInputStream(serverCfgjson);
		String text = IOUtils.toString(inputStream, "utf8");
		return JSON.parseObject(text, ServerCfg.class);
	}
	// @Bean
	// public ServerCfg createTestBean() {
	// ServerCfg server = new ServerCfg();
	//
	// //
	// List<ServiceCfg> services = new ArrayList<ServiceCfg>();
	// server.setServices(services);
	//
	// //
	// ServiceCfg service = new ServiceCfg();
	// services.add(service);
	//
	// service.setName("Kitty");
	//
	// //
	// List<ConnectorCfg> connectors = new ArrayList<ConnectorCfg>();
	// service.setConnectors(connectors);
	//
	// //
	// ConnectorCfg connectorhttp11 = new ConnectorCfg();
	//
	// connectorhttp11.setPort(8088);
	// connectorhttp11.setProtocol("HTTP/1.1");
	//
	// connectors.add(connectorhttp11);
	//
	// //
	// ConnectorCfg connectorAJP = new ConnectorCfg();
	//
	// connectorAJP.setPort(8089);
	// connectorAJP.setProtocol("AJP");
	//
	// connectors.add(connectorAJP);
	//
	// return server;
	// }
}
