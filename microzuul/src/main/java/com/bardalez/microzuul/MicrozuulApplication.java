package com.bardalez.microzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.bardalez.microzuul.filters.MiPreFiltro;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class MicrozuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrozuulApplication.class, args);
	}
	
	@Bean
	public MiPreFiltro miPreFiltro() {
		return new MiPreFiltro();
	}
	
	@Bean
	public IRule miRegla() {
		return new WeightedResponseTimeRule();
	}

}
