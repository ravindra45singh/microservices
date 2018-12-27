package de.telekom.microservices.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = { "de.telekom.microservices.server" })
@EnableCircuitBreaker
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class MicroServiceClientApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger( MicroServiceClientApplication.class );

    public static void main( String[] args ) {
        SpringApplication app = new SpringApplication( MicroServiceClientApplication.class );
        app.setBannerMode( Banner.Mode.OFF );
        app.run( args );
        LOGGER.info( "0;MicroService Client Started" );
    }
}
