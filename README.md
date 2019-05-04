# simple-form-based-crud

An application that integrates Angular, Angular Material, Bootstrap, Spring Boot, Hibernate, MySQL, Swagger, Map Struct, Lombok so on to demonstrate:

* A form based data gathering and persisting in the database
* Retrieval of the data from the database and listing in the UI
* An API based integration with JIRA to create an issue as soon as the data is stored in the database.  

### Technology

This sample application uses a number of open source projects:   

* [Angular 7] - HTML enhanced for web apps.
* [Springboot 2.1.4] - awesome lightweight application framework.
* [Twitter Bootstrap] - great UI boilerplate for modern web apps

### Installation

Make sure you have below mentioned development tools:  

* Maven, Git   
* NodeJS, NPM, JDK 8.0+   
* Visual Studio Code, Eclipse   

### Development

##### Local Environment      

Build and run frontend:   
```sh
$ npm i && npm run start
```
Build and run backend:    
```sh
$ mvn clean install spring-boot:run
```
(access) Browser:   
UI: https://localhost:4200   
Backend: http://localhost:8082   
Swagger-UI: http://localhost:8082/swagger-ui.html   