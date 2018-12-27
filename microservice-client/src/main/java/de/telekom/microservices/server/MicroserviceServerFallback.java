package de.telekom.microservices.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import de.telekom.microservices.utils.MicroBean;

@Component
public class MicroserviceServerFallback implements MicroserviceServerProxy {

	@Override
	public MicroBean getService(String id) {
		final Logger LOGGER = LoggerFactory.getLogger(RestClientMicroService.class);

		LOGGER.info("0;MicroserviceServerFallback method called");
		return new MicroBean(0, "Service is Down", "Service is Down", "Service is Down", 0);
	}

}
