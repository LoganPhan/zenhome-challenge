# Overview
System is created with microservice Architecture, Service Registration pattern
# Deploy
Those services need to start-up by following command:
## gateway-service:
> cd gateway-service  
> ./mvnw clean package  
> java -jar gateway-service/target/gateway-service.0.0.1.SNAPSHOT.jar
## discovery-service:
> cd discovery-service  
> ./mvnw clean package  
> java -jar discovery-service/target/discovery-service.0.0.1.SNAPSHOT.jar
## counter-service:
> cd counter-service  
> ./mvnw clean package  
> java -jar counter-service/target/counter-service.0.0.1.SNAPSHOT.jar
## village-service:
> cd village-service  
> ./mvnw clean package  
> java -jar village-service/target/village-service.0.0.1.SNAPSHOT.jar
## Service Registration - Discovery-service
Reference link: [Spring-Service-Segistration](https://spring.io/guides/gs/service-registration-and-discovery/)
![Image of Discovery](https://serving.photos.photobox.com/41197949c58da7078ab1f2b7169c27c970c29eec78677f8bcd182d2effdc012ce8fd83a5.jpg)
This UI listed out registered services, it is helpful to tracking service is running or down and counting the instance of particular service
## Gateway-service
Routing is an integral part of a microservice architecture. More detail: [Spring-Cloud-Zuul](https://spring.io/guides/gs/routing-and-filtering/)
**Swagger**:
Swagger-ui was configured in gateway-service. It will combine all swagger-ui from services(services in Registration pool above) into one page. It is helpful for FE,QA,BE team can have some overview the AIPS
![Image of Gateway](https://serving.photos.photobox.com/40866687ccf4764db086deb80f7c08c9cadae21124a6b57a02493e80dc641de845855a80.jpg)
**Tesing API**
![Image of testing](https://serving.photos.photobox.com/158915570f54c3934461e46e55759e18403fec29519f9fb02e17abb1bb57b03449612721.jpg)
# Licensing
MIT
#
