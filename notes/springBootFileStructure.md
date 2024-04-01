https://malshani-wijekoon.medium.com/spring-boot-folder-structure-best-practices-18ef78a81819 

# Spring Boot Folder Structure Best Practices *(excerpt with notes)*
*-- Malshani Wijekoon*


Here I’m going to explain the files that need to include above folders.


1. ### Config:
   Contains configuration classes, where you configure application settings, or AppConfig for other application-level configurations.


2. ### Controller:
   Contains your RESTful controller classes. These classes handle incoming HTTP requests and define the API endpoints.


3. ### DTO (Data Transfer Object):
    A DTO, is a design pattern used to transfer data between different layers or components of an application. The main purpose of a DTO is to encapsulate data and provide a simple data structure that can be easily passed around the application. DTOs are often used to transfer data between the front-end and back-end of a web application, between microservices, or between different layers of an application, like the service layer and the presentation layer.
    ### Characteristics of a DTO:
    *It typically contains only private fields with getters and setters to access the data.
DTOs do not contain any business logic, and their primary focus is to carry data.
They are often used to represent a subset of data from an entity or a combination of data from multiple entities.
DTOs help to reduce the amount of data transferred over the network, improving performance by avoiding excessive data exchange.*


4. ### Enum (Enumeration class):
   Enum classes are typically used to represent a set of closely related and pre-defined values. Examples of common use cases for Enum classes include request status like SUCCESS, FAIL, PENDING and more.


5. ### Model:
   The model folder stores data models or entities that represent structure and behaviour of the application domain. These classes are mapped to database tables and define the properties and relationships of the application data. 
   -- "To me, model is more or less data classes which in some way represents the database (or the data we are trying to model)."

6. ### Repository:
    Contains repository classes that deal with data access. These classes typically use an ORM (Object-Relational Mapping) framework or JPA (Java Persistence API) to interact with the database.


7. ### Service:
   Contains service classes that implement business logic. Controllers use these services to perform operations on data.


8. ### Util (Utilities):
   The “util” folder is not specific to Spring Boot; it is a general practice followed in many programming languages and frameworks. In Spring Boot projects, you might find a “util” package or folder where developers place utility classes to keep the codebase organized and modular.


Other than src/main/java folders there are other folders that need to have in a spring boot application. There are as follows.

### src/main/resources:
This folder contains non-Java resources like static files, templates, and configuration files.
### src/test:
This folder contains all your test classes. Inside this folder there is another folder which is same to src/main/java folder structure. As an example src/test/java/service folder contains test classes for testing the service classes of src/main/java/service classes.
Note: This folder structure can vary from company to company. But this is the basic folder structure of a Spring Boot application.