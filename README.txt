Poc : Microservices in Springboot 

Steps to run(also docker is avaiavle to run applications) :

For Discovery Service

*  Run 'discovery server' application as Eureka Discovery Service.
*  Then open in browser http://localhost:8761/ to see Dashboard where you can check all services registered with Eureka.

For Load Balancing

*  Run 2 or 3 instances of 'microservice-server' application(By running on different ports).
*  When all the services is up refresh Eureka Discovery Server Dashboard (at http://localhost:8761/).
*  Now you can see all instances of microservice-server registered to the Eureka server with Service Name “MICROSERVICE-  SERVER” and port where they are running.
*  Now run 'microservice-client' application.
*  You can see microservice-client also registered to the Eureka server with Service Name “MICROSERVICE-ClIENT”.
*  So once this service is up it will keep invoking microservice-server(rest call) via Eureka server on every 5 seconds.
*  You can see logs where loads are distributed among all instances of 'microservice-server' aplllication.

For Circuit Breaker

*  Simply run 'microservice-server' application(if already not running).
*  Then run 'microservice-circuit-breaker', You can check it on Eureka Dashboard.
*  This servise will keep invoking microservice-server(rest call) on every 3 seconds.
*  Then after sometime shut down 'microservice-server' application.
*  You will see, since application is down it will  invoke defined 'fallbackMethod'. Check logs.
