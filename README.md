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
System is created with microservice Architecture, Service Registration pattern and including some technical stuffs below:
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
# Licensing
MIT
#
