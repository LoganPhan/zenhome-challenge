# Village-service
Village service store village's general information, API support for Counter-service.
GET /counter?id=1
```json
{
   <code>"id": "1","village_name": "Villarriba"</code>
} 
```
# DB Schema
Column_name | Data-type | Description 
------------ | ------------- | ------------- 
id | Bigint | primary key (auto_inscrease)
name | varchar(255) | Village name
# Building
> ./mvnw clean package
# Start Application
> java -jar target/village-service.0.0.1.SNAPSHOT.jar
# Usage
There are many option to invoke api: postman,swager-ui...
Here I choose swagger-ui that has been set-up in this project via link: http://localhost:8083/swagger-ui.html or from gateway-service(http://localhost:8083/swagger-ui)
![village-service](https://serving.photos.photobox.com/924116252906958034388093f6745aa9fdd69ce37b38dcf7221c5f895e7d9acedb3410a1.jpg)
How to use swagger-ui [Swagger-ui](https://swagger.io/tools/swagger-ui/)
