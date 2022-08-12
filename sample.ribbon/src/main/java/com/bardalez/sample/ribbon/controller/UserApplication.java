package com.bardalez.sample.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bardalez.sample.ribbon.config.SayHelloConfiguration;

@RestController
@RibbonClient(name = "SERVICIO.CATALOGO", configuration = SayHelloConfiguration.class)
public class UserApplication {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/prod")
	public String hi(@RequestParam(value = "codigo", defaultValue = "3") String codigo) {
		String prodTemp = this.restTemplate.getForObject("http://SERVICIO.CATALOGO/producto/"+codigo, String.class);
		return prodTemp;
	}

}