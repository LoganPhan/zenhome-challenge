# Zenhome Assigments
This is my home assignment to give some solution to tackle two issues:
- Business logic between Landlord and Tenant
- Energy consumption report
- Expect the end-to-end design of the system (a model, system architecture, technology, and frameworks choice, testing strategy, ER diagram, Java...
System has an API that is called by electricity counters:
POST /counter_callback
```json
{
   "counter_id": "1","amount": 10000.123
}
```
To get information additional information about the counter you have to call the following external API:
GET /counter?id=1
```json
{
   <code>"id": "1","village_name": "Villarriba"</code>
}
```
As a result, it's expected that your system will expose the following API:
GET /consumption_report?duration=24h
```json
{
  "villages": [
    {
      "village_name": "Villarriba",
      "consumption": 12345.123
    },
    {
      "village_name": "Villabajo",
      "consumption": 23456.123
    }
  ]
}
```
# Technologies
System is created with microservice Architecture, Service Registration pattern and including some technical stuffs below  :
- Spring-boot(2.2.2.RELEASE) - standalone rest-api application
- Spring-Cloud(Netflix-Eureka, Netflix-Zuul) - discovery, registry, loadbalancing service.
- Spring-data-jpa - Implementing a data access layer of an application
- Mapstruct 1.3.1.Final - Mapping POJO Entity and Dto
- H2db -  In-memory datable
- Liquibase - Migration tool
- FasterXML(Mapping POJO to Json or XML)
- Maven(3.5.3) - bundle application
- Lombok - Generate Getter/Setter/Builder 
- Java8
- Springfox-swagger2(2.9.2) - Document Api
- Junit4(Unit-test, Integration-test) - Testing strategy
# Overview
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
