package de.telekom.microservices.server;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.telekom.microservices.utils.MicroBean;

@FeignClient(name = "microservice-server", fallback = MicroserviceServerFallback.class)
public interface MicroserviceServerProxy {

	@RequestMapping(value = "/getMicroResponse/{id}", method = RequestMethod.GET)
	MicroBean getService(@PathVariable("id") String id);

}