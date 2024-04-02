### Repositories:
The "Repositories" folder contains classes responsible for data access and persistence. These classes interact with the 
underlying database or data store, providing methods for querying, saving, updating, and deleting data. Repositories 
often use Spring Data JPA or other persistence frameworks.

### Notes:
So to me this means that the "Repository" directory is *specifically* for database CRUD.

    // C.R.U.D. & HTTP Request Equivalents
    - Create - - - (HTTP Post)
    - Read - - - - (HTTP Get)
    - Update - - - (HTTP Put)
    - Delete - - - -(HTTP DELETE)

The repositories can also be called DAO's, Data Access Objects. As opposed to DTO's, Data Transfer Objects. Repositories
return only ***model*** entities.