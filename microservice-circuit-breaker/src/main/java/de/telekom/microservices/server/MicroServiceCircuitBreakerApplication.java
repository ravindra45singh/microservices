package de.telekom.microservices.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class MicroServiceCircuitBreakerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger( MicroServiceCircuitBreakerApplication.class );

    @Autowired
    RestClientCircuitBreaker restClientCircuitBreaker;

    public static void main( String[] args ) {
        SpringApplication app = new SpringApplication( MicroServiceCircuitBreakerApplication.class );
        app.setBannerMode( Banner.Mode.OFF );
        app.run( args );
        LOGGER.info( "0;MicroService CircuitBreaker Application Started" );
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Scheduled( fixedRate = 3000 )
    public void getInvoked() {
        String str = restClientCircuitBreaker.pingMicroserviceServer();
        LOGGER.info( "0;pingMicroserviceServer respond with {} ", str );
    }

}
