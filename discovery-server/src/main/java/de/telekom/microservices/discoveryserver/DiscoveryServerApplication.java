package de.telekom.microservices.discoveryserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryServerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger( DiscoveryServerApplication.class );

    public static void main( String[] args ) {
        SpringApplication app = new SpringApplication( DiscoveryServerApplication.class );
        app.setBannerMode( Banner.Mode.OFF );
        app.run( args );
        LOGGER.info( "0;Discovery Server Started" );
    }

}
