package com.bardalez.sample.ribbon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import com.netflix.client.config.IClientConfig;
//import com.netflix.discovery.EurekaClient;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.NoOpPing;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
//import com.netflix.niws.loadbalancer.DiscoveryEnabledNIWSServerList;

public class SayHelloConfiguration {

	@Autowired
	IClientConfig ribbonClientConfig;

	@Autowired
	//private EurekaClient discoveryClient;

	@Bean
	public IPing ribbonPing() {
		return new PingUrl();
		//return new NoOpPing();
	}

	@Bean
	public IRule ribbonRule() {
		return new MyRule();
	}
	
	@Bean
    public ServerList<Server> ribbonServerList() {
		//List<ServiceInstance> list = discoveryClient.getInstances("SERVICIO.CATALOGO");
		//return new StaticServerList<>(new Server(list.get(0).getHost(), list.get(0).getPort()), new Server(list.get(1).getHost(), list.get(1).getPort()));
		//return new StaticServerList<>(new Server("localhost", 8080), new Server("localhost", 8081));
		
//		CedricEurekaClientProvider eurekaProvider = new CedricEurekaClientProvider();
		//DiscoveryEnabledNIWSServerList listOfServer_Eureka = new DiscoveryEnabledNIWSServerList(ribbonClientConfig, eurekaProvider);
		
		//Server[] serversAvailables = listOfServer_Eureka.getInitialListOfServers().stream()
//				.map(i -> new Server(i.getHost(), i.getPort()))
//				.toArray(Server[]::new);
		
//		return new StaticServerList<>(serversAvailables);
		return null;
    }
}