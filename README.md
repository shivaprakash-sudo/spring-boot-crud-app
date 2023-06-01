# Spring Boot CRUD App

This is a Spring Boot application with CRUD operations using MySQL for data persistence.

[Java Version - 17](https://www.oracle.com/java/technologies/downloads/#java17)

[Maven Version - 3.9.2](https://maven.apache.org/download.cgi)

### Required Maven dependencies
 - Starter web
 - Starter Data JPA
 - Starter Thymeleaf
 - Starter Test
 - Hibernate Core
 - Javax Persistence API
 - MySQL Driver
 - Bootstrap
 - Webjars Locator Core


### Local Development

If you want to run this app locally, then you need to download and install both Java 17 and Maven in your system.

Once you have both of them, go to the terminal in your root directory and run the command `mvn install clean`. It should install all the maven packages written in pom file.

Now, if everything is set up and the IDE doesn't complain about anything, then run the main method in the `SimpleCRUDAppApplication` class using the command `mvn spring-boot:run` from the terminal. It should run on port 3000 if everything is set up correct.