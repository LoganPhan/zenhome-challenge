package com.zenhomes.gateway.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@Primary
@EnableAutoConfiguration
@EnableSwagger2
public class GatewaySwaggerResourceProvider implements SwaggerResourcesProvider {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public GatewaySwaggerResourceProvider() {

	}

	@Override
	public List<SwaggerResource> get() {
		return this.discoveryClient.getServices().stream().map(serviceName -> {
			ServiceInstance instance = discoveryClient.getInstances(serviceName).get(0);
			return swaggerResource(serviceName, instance.getUri().toString() + "/v2/api-docs", "");
		}).collect(Collectors.toList());
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}
