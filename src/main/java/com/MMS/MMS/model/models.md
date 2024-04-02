### Models: 
The "models" folder stores the data models or entities that represent the structure and behavior of the application's 
domain. These classes typically map to database tables or external data sources and define the properties and 
relationships of the application's data.

### Notes:
"Represent the structure and behavior of the application's domain" is a bit jargony... But I can understand the second 
one, "These classes typically map to database tables and define the properties and relationships of the applications 
data". This means that I'm doing it right, so far. 

To simplify, my motto with this will be "Models" stands for "Models of Database Data".
- This is the stuff that the database information will be PLUGGED INTO so that the application can do what it needs to 
do with it.
- The models don't do anything other than manage and manipulate the data. They don't do any of the PROGRAM LOGIC, that
is handled by the SERVICE folder.
- Models are simple and know NOTHING about the larger program. They represent data, and manipulate their own data as
needed, and prepare it for outside classes to do things with.
- External classes shouldn't have to know ANYTHING about what's happening inside of these classes. Models give them the 
information, and they can do what they need to do without concern for how things work inside. They should be 
"Black Boxes" and that shouldn't matter.