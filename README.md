# Proof of concept application.
In the need of our organization which is developing a new important application for information security and data protection,\
we have developed a component to provide data collection and retrieval for this application.
## General Info
The application uses Microservices Architecture and is divided in 3 modules.
1. The first module, middlewear, is the data layer of the app. Including the entities and the communication with the NOSQL database(Mongodb).
2. The second module, rest, is the rest api which delivers data via http requests in JSON format.
3. The third module, mvc, is the model view controller architecture of the app which delivers data and implemets the add, edit, and delete UI actions.
## Technologies
* Java Amazon Corretto version 11.0.13 
* Maven 3.8.3
* Spring Boot 2.6.2
    Dependencies:
    * Lombok
    * Thymeleaf
    * Swagger UI
    * Devtools
    * Security
    * Web services
* Bootstrap  5
* MongoDB 
