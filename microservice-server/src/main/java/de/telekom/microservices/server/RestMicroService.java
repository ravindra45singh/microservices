package de.telekom.microservices.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import de.telekom.microservices.utils.MicroBean;

@RestController
public class RestMicroService {

    private static final Logger LOGGER = LoggerFactory.getLogger( RestMicroService.class );

    @Autowired
    DiscoveryClient client;

    @RequestMapping( value = "/getMicroResponse/{id}", method = RequestMethod.GET )
    public ResponseEntity<MicroBean> getRestService( @PathVariable( "id" ) String time ) {
        LOGGER.info( "0;Request received in RestMicroService at {}", time );

        ServiceInstance localInstance = client.getLocalServiceInstance();

        MicroBean bean = new MicroBean();
        bean.setDate( time );
        bean.setServiceId( localInstance.getServiceId() );
        bean.setHost( localInstance.getHost() );
        bean.setPort( localInstance.getPort() );
        return new ResponseEntity<MicroBean>( bean, HttpStatus.OK );
    }

    @RequestMapping( value = "/pingService/{id}", method = RequestMethod.GET )
    public ResponseEntity<String> pingService( @PathVariable( "id" ) String reqString ) {
        LOGGER.info( "0;Request received in pingService with id {}", reqString );

        return new ResponseEntity<String>( reqString, HttpStatus.OK );
    }

}
