package de.telekom.microservices.server;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import de.telekom.microservices.utils.MicroBean;

@Component
public class RestClientMicroService {

    private static final Logger LOGGER = LoggerFactory.getLogger( RestClientMicroService.class );

    @Autowired
    protected RestTemplate restTemplate;

    public static final String URL = "http://MICROSERVICE-SERVER";

    @Autowired
    DiscoveryClient client;

    @Scheduled( fixedRate = 5000 )
    public void getInvoked() {
        LOGGER.info( "0;getMicroResponse method invoked" );
        try {
            MicroBean res = restTemplate.getForObject( URL + "/getMicroResponse/{id}", MicroBean.class, DateTime.now() );

            LOGGER.info( "0;Request received in {}:{}:{} at {} ", res.getServiceId(), res.getHost(),
                    res.getPort(), res.getDate() );
            LOGGER.info( "0;Response received in Microservice Client at {} ", DateTime.now().toString() );
        } catch ( RestClientException ex ) {
            LOGGER.info( "0;RestClientException ---> {}", ex.getMessage() );
        }

    }

}
