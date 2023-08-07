# todo-api
ToDo API using Spring Boot

This is a sample project for learning Spring Boot.

### Run the project:
Open a console and run the following maven commands:
- **mvn clean**: this command will clean the project, it will delete all previously compiled Java .class files
- **mvn install**: will then compile, test and package the Java project and even install/copy your built .jar file 
into your local Maven repository.

After cleaning, compiling and packaging the app, run the app
- **mvn spring-boot:run**

### Access to the database:
http://localhost:8080/h2-console/

  - **user:** a
  - **password:** a

### Access Swagger and test the API methods from Swagger:
http://localhost:8080/swagger-ui.html 

### Access to all API methods:
http://localhost:8080/swagger-ui.html#/task-controller