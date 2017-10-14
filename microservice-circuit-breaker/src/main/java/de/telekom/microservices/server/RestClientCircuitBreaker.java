package de.telekom.microservices.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class RestClientCircuitBreaker {

    @Autowired
    protected RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger( RestClientCircuitBreaker.class );
    public static final String URL = "http://localhost:2222";

    @HystrixCommand( fallbackMethod = "pingFallback" )
    public String pingMicroserviceServer() {
        LOGGER.info( "0;pingMicroserviceServer method invoked" );

        return restTemplate.getForObject( URL + "/pingService/{id}", String.class, "12345" );
    }

    public String pingFallback() {
        LOGGER.info( "0;pingFallback method get invoked" );
        return "Couldn't connect to microservice Server. It's either busy or offline";
    }

}
