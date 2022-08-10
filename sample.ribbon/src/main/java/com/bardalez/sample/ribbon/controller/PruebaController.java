package com.bardalez.sample.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bardalez.sample.ribbon.config.OtroClienteConfig;

@RestController
@RibbonClient(name = "SERVICIO.CESTA", configuration = OtroClienteConfig.class)
public class PruebaController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/prueba")
	public String hi(@RequestParam(value = "codigo", defaultValue = "3") String codigo) {
		String prodTemp = this.restTemplate.getForObject("http://SERVICIO.CESTA/producto/"+codigo, String.class);
		return prodTemp;
	}

}
