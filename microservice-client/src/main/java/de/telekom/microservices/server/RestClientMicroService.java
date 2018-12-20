package de.telekom.microservices.server;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import de.telekom.microservices.utils.MicroBean;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.*;

@Component
public class RestClientMicroService {

    private static final Logger LOGGER = LoggerFactory.getLogger( RestClientMicroService.class );

    @Autowired
    protected RestTemplate restTemplate;
    
    @Autowired
	private LoadBalancerClient loadBalancer;

    public static final String URL = "http://MICROSERVICE-SERVER/getMicroResponse/{id}";

    

    @Scheduled( fixedRate = 10000 )
    public void getInvoked() {
        LOGGER.info( "0;getMicroResponse method invoked" );
        
        String serviceId=null;
        
        ServiceInstance serviceInstance=loadBalancer.choose("microservice-server");
        System.out.println(serviceInstance.getServiceId()+ ","+serviceInstance.getUri());
        serviceId=serviceInstance.getServiceId().toString();
        
        String baseUrl=URL;
        if(serviceId!=null)
        	baseUrl  = "http://"+serviceId+"/getMicroResponse/{id}";
         	
        
        LOGGER.info( "0;baseUrl: {}", baseUrl);
        
        try {
            MicroBean res = restTemplate.getForObject( baseUrl, MicroBean.class, DateTime.now() );

            LOGGER.info( "0;Request received in {}:{}:{} at {} ", res.getServiceId(), res.getHost(),
                    res.getPort(), res.getDate() );
            LOGGER.info( "0;Response received in Microservice Client at {} ", DateTime.now().toString() );
        } catch ( RestClientException ex ) {
            LOGGER.info( "0;RestClientException ---> {}", ex.getMessage() );
        }

    }

}
