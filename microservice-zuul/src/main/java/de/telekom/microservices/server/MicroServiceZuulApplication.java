package de.telekom.microservices.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import de.telekom.microservices.zuulfilters.ErrorFilter;
import de.telekom.microservices.zuulfilters.PostFilter;
import de.telekom.microservices.zuulfilters.PreFilter;
import de.telekom.microservices.zuulfilters.RouteFilter;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class MicroServiceZuulApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger( MicroServiceZuulApplication.class );

    public static void main( String[] args ) {
        SpringApplication app = new SpringApplication( MicroServiceZuulApplication.class );
        app.setBannerMode( Banner.Mode.OFF );
        app.run( args );
        LOGGER.info( "0;MicroService Zuul Application Started" );
    }
    
    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

}
