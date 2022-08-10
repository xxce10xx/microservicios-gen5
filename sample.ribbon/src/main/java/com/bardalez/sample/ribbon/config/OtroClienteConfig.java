package com.bardalez.sample.ribbon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

public class OtroClienteConfig {
	
	@Autowired
	IClientConfig ribbonClientConfig;


	@Bean
    public ServerList<Server> ribbonServerList() {
		System.out.println(ribbonClientConfig.getClientName());

		return  new StaticServerList<>(new Server("localhost", 3333));
	}
}
