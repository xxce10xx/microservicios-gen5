package com.bardalez.sample.ribbon.config;

import javax.inject.Provider;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;

public class CedricEurekaClientProvider implements Provider<EurekaClient> {
	
	private volatile EurekaClient eurekaClient;
	
	@Override
	public synchronized EurekaClient get() {
		if (eurekaClient == null) {
			eurekaClient = DiscoveryManager.getInstance().getDiscoveryClient();
		}
        return eurekaClient;
	}
}
