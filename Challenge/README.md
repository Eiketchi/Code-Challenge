# Challenge - Project description

This project is a Spring boot application that allow the users to register themselves in the application, once done they can connect themselves to their facebook
account and see all their pictures. the application also offers the possibility of extracting those pictures and exporting them to a firebase cloud storage.

## Download and run the application
- Import the project on any IDE either as a maven project or a Spring boot project
- Lunch the application as a Java application (for exemple on eclipse) or as a spring boot app (like on STS Spring tool suite)  
- Enter to localhost:8080 and you can test it.

## Information

- The application user information are stored in a  XML file so you don't need any database configuration.
- xml file is in src/main/resources.
- the facebook information part is related to my account.
- the firestore part is also related to my account and the authentification config file is a .json file in src/main/resources