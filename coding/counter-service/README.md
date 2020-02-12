# Counter-service
This service allow user receive and collect data about energy consumption from different villages
There are some data when application start.
# DB Schema
Column_name | Data-type | Description 
------------ | ------------- | ------------- 
id | Bigint | primary key (auto_inscrease)
counter_id | Bigint | Village Id from (village-service)
amount | decimal(12,3) | Energy amount of village
# Building
> ./mvnw clean package
# Start Application
> java -jar target/counter-service.0.0.1.SNAPSHOT.jar
# Usage
There are many option to invoke api: postman,swager-ui...
Here I choose swagger-ui that has been set-up in this project via link: http://localhost:8084/swagger-ui.html or from gateway-service(http://localhost:8082/swagger-ui)
![counter-service](https://serving.photos.photobox.com/80013698aaecb1fb78ac9290c361785c27cb1a8d6171dec0153e5761f958807fdf86812d.jpg)
How to use swagger-ui [Swagger-ui](https://swagger.io/tools/swagger-ui/)
