### DTOs:
The "POJO" or "DTOs" (Data Transfer Objects) folder contains classes that serve as plain old Java objects or data 
transfer objects used for transferring data between layers of the application. They encapsulate data and provide a 
standardized format for communication between different components.


### Notes:
"Transferring data between layers of the application". This, to me, means the layer between the back-end


### Interesting Tidbits:
https://stackoverflow.com/questions/33604765/dtos-with-hibernate-frontend-objects-vs-backend-objects

I prefer using DTO's:

The Database layer (your repositories or DAO's) gets and returns only model entities.
The Service layer gets and returns only DTO's.
So the Service layer is in charge of mapping DTO's into entities and viceversa.

This decouples the view from the database model and gives much more flexibility when sending data from the server to the
client.

Mapping DTO's into entities generates a lot of code, but in the end it tends to pay off. You can use a library like 
Orika or Dozer to help you out with that.